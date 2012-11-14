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
import devfortress.utilities.Skills;
import devfortress.utilities.Utilities;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Random;
// TODO implement statergy partern

/**
 *
 * @author cathoanghuy
 */
public class Engine extends Observable implements Model {

    private Company company;
    private GameLevel level;
    DateTime dateTime;

    public Engine() {
        this(new Company());
    }

    public Engine(Company company) {
        this.company = company;
        dateTime = new DateTime();
        Map<Skills, Integer> skillList = new HashMap<Skills, Integer>();
        skillList.put(Skills.C, 5);
        skillList.put(Skills.LISP, 4);
        skillList.put(Skills.DESIGN, 8);
        skillList.put(Skills.ALGORITHMS, 6);
        skillList.put(Skills.CONFIG_MANAGEMENT, 5);
        takeProject(new Project(200, 500, 1, new DateTime(0, 6, 0), skillList));
    }

    @Override
    public void buyItem(Item item, int quantity) {
        try {
            company.buyItem(item, quantity);
            setChanged();
            notifyObservers("Buy Item");

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
        notifyObservers("Hire Employee");
    }

    @Override
    public void fireEmployee(Employee employee) {
        company.removeEmployee(employee);
        setChanged();
        notifyObservers("Fire Employee");

    }

    @Override
    public void takeProject(Project project) {
        company.addProject(project);
        setChanged();
        notifyObservers("Take Project");
    }

    @Override
    public void cancelProject(Project project) {
        company.cancelProject(project);
        setChanged();
        notifyObservers("Cancel Project");
    }

    @Override
    public void eventOccur() {
        //TODO do this shit
    }

    @Override
    public void levelUp(Project project) {
        project.levelUp();
        setChanged();
        notifyObservers("Employee's skill has leveled up");
    }

    @Override
    public void paySalary() {
        try {
            company.paySalary();
            setChanged();
            notifyObservers("Pay salary");
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
    public void nextTurn() throws MoneyRunOutException {
        for (int i = 0; i < 4; i++) {
            nextWeek();
        }
        for (Project project : company.getCurrentProjectList()) {
            try {
                if (project.checkProjectProcess()) {
                    company.removeProject(project);
                }
            } catch (ProjectFailsException ex) {
                company.cancelProject(project);
                System.out.println(ex.getMessage());
            }
        }
        generateProjectList();
        generateEmployeeList();
        paySalary();
        if (company.getMoney() <= 0) {
            throw new MoneyRunOutException();
        }
        company.clearItemList();
        setChanged();
        notifyObservers("Next turn");
    }

    private void nextWeek() {
        eventOccur();
        dateTime.nextWeek();

    }

    @Override
    public Map<String, Float> getItems() {
        return company.getItems();
    }

    @Override
    public List<Employee> getEmployeeList() {
        return company.getEmployeeList();
    }

    @Override
    public List<Project> getProjectList() {
        return company.getCurrentProjectList();
    }

    @Override
    public DateTime getCurrentTimePlayed() {
        return dateTime;
    }

    @Override
    public float getBudget() {
        return company.getMoney();
    }

    @Override
    public float getTotalSalary() {
        return company.calculateTotalSalary();
    }

    @Override
    public float getExpenses() {
        return company.getExpenses();
    }

    @Override
    public float getFoodandDrinkExpense() {
        return company.getFoodandDrinkExpense();
    }

    @Override
    public float getComputerExpense() {
        return company.getComputerExpense();
    }
}