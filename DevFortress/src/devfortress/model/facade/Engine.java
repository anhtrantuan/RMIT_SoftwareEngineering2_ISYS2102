/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model.facade;

import devfortress.model.*;
import devfortress.model.dificulity.GameLevel;
import devfortress.model.exception.MoneyRunOutException;
import devfortress.model.exception.OvercrowdedException;
import devfortress.model.exception.ProjectFailsException;
import devfortress.model.exception.UnaffordableException;
import devfortress.utilities.Utilities;
import java.util.List;
import java.util.Observable;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
// TODO implement statergy partern

/**
 *
 * @author cathoanghuy
 */
public class Engine extends Observable implements Model, Runnable {

    private Company company;
    private GameLevel level;
    DateTime dateTime;
    
    public Engine(Company company) {
        this.company = company;
    }

    @Override
    public void buyItem(Item item) {
        try {
            company.buyItem(item);
            setChanged();
            notifyObservers();
            
            // TODO implement Engine.buyItem
        } catch (UnaffordableException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void hireEmployee(Employee employee) throws OvercrowdedException {
        if (!Utilities.assignComputerToEmployee(company, employee)) {
            throw new OvercrowdedException("Not enough computer");
        }
        company.addEmployee(employee);
        setChanged();
        notifyObservers();
    }

    @Override
    public void fireEmployee(Employee employee) {
        company.removeEmployee(employee);
        setChanged();
        notifyObservers();
        
    }

    @Override
    public void takeProject(Project project) {
        company.addProject(project);
        setChanged();
        notifyObservers();
    }

    @Override
    public void cancelProject(Project project) {
        company.cancelProject(project);
        setChanged();
        notifyObservers();
    }

    @Override
    public void eventOccur() {
        //TODO do this shit
    }

    @Override
    public void levelUp(Project project) {
        project.levelUp();
        setChanged();
        notifyObservers();
    }

    @Override
    public void paySalary() {
        try {
            company.paySalary();
            setChanged();
            notifyObservers();
        } catch (MoneyRunOutException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Employee> generateEmployeeList() {
        Random random = new Random();
        int number = random.nextInt(3) + 3;
        return Utilities.generateEmployeeList(level, number);
    }

    @Override
    public List<Project> generateProjectList() {
        Random random = new Random();
        int number = random.nextInt(3) + 8;
        return Utilities.generateProjectList(level, number);
    }

    @Override
    public void nextTurn() throws MoneyRunOutException{
        for(int i = 0; i<4;i++){
            nextWeek();
        }
        for(Project project:company.getCurrentProjectList()){
            try {
                if(project.checkProjectProcess()){
                    company.increaseMoney(project.getPayment());
                }
            } catch (ProjectFailsException ex) {
                company.decreaseMoney(project.getPayment()*0.8f);
                System.out.println(ex.getMessage());
            }
        }
        generateProjectList();
        generateEmployeeList();
        if(company.getMoney()<=0){
            throw new MoneyRunOutException();
        }
        setChanged();
        notifyObservers();
    }
    
    @Override
    public void run() {
        
    }

    private void nextWeek() {
        eventOccur();
        dateTime.nextWeek();
        
    }
    
    private int calculateTotalFuntionPointDeliveredThisMonth(){
        int result = 0;
        for(Project project:company.getCurrentProjectList()){
            result+= project.getTotalFunctionPointDelivered();
        }
        setChanged();
        notifyObservers();
        return result;
    }
}