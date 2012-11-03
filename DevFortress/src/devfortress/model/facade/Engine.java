/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model.facade;

import devfortress.model.*;

import devfortress.model.dificulity.GameLevel;
import devfortress.model.exception.*;

import devfortress.model.exception.MoneyRunOutException;
import devfortress.model.exception.OvercrowdedException;
import devfortress.model.exception.UnaffordableException;

import devfortress.utilities.Utilities;
import java.util.List;
import java.util.Observable;
import java.util.Random;
// TODO implement statergy partern

/**
 *
 * @author cathoanghuy
 */
public class Engine extends Observable implements Model, Runnable {

    private Company company;
    private GameLevel level;

    public Engine(Company company) {
        this.company = company;
    }

    @Override
    public void buyItem(Item item) {
        try {
            company.buyItem(item);
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
    }

    @Override
    public void fireEmployee(Employee employee) {
        company.removeEmployee(employee);
        // TODO implement Engine.fireEmployee
    }

    @Override
    public void takeProject(Project project) {
        company.addProject(project);
    }

    @Override
    public void cancelProject(Project project) {
        company.cancelProject(project);
    }

    @Override
    public void eventOccure() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void levelUp(Project project) {
        project.levelUp();
    }

    @Override
    public void paySalary() {
        try {
            company.paySalary();
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
    public void run() {
    }
}
