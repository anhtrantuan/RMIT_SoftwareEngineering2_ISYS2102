/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model.facade;

import devfortress.model.*;
import devfortress.model.dificulity.GameLevel;
import devfortress.model.exception.*;
import devfortress.utilities.Skill;
import devfortress.utilities.Utilities;
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
    }

    /**
     * Buy an item with quantity
     *
     * @param item
     * @param quantity
     */
    @Override
    public void buyItem(Item item, int quantity) {
        try {
            company.buyItem(item, quantity);
            setChanged();
            String message = String.format("Bought %d new %s: -$%.2f",
                    quantity, item.getName() + (quantity > 1 ? "s" : ""),
                    (item.getPrice() * quantity));
            notifyObservers(message);

            // TODO implement Engine.buyItem
        } catch (UnaffordableException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Hire more employee
     *
     * @param employee
     * @throws OvercrowdedException when the number of employee more than number
     * of computer
     */
    @Override
    public void hireEmployee(Employee employee) throws OvercrowdedException {
        if (!Utilities.assignComputerToEmployee(company, employee)) {
            throw new OvercrowdedException("Not enough computer");
        }
        company.addEmployee(employee);
        setChanged();
        String message = String.format("Hired new employee %s: -$%.2f",
                employee.getName(), employee.getSalary());
        notifyObservers(message);
    }

    @Override
    public void fireEmployee(Employee employee) {
        company.removeEmployee(employee);
        setChanged();
        String message = String.format("Fired employee %s: +$%.2f",
                employee.getName(), employee.getSalary());
        notifyObservers(message);
    }

    @Override
    public void takeProject(Project project) {
        company.addProject(project);
        setChanged();
        String message = String.format("Contracted new project %s: +$%.2f",
                project.getName(), project.getPayment() / 2);
        notifyObservers(message);
    }

    /**
     * Invoke method when project is fail or canceled
     *
     * @param project
     */
    @Override
    public void cancelProject(Project project) {
        company.cancelProject(project);
        setChanged();
        String message = String.format("Cancel project %s: -$%.2f",
                project.getName(), project.getPayment() * 0.8);
        notifyObservers(message);
    }

    /**
     * Invoke method each week to calculate chance which event will happen in
     * that week
     */
    @Override
    public void eventOccur() {
        //TODO do this next sprint
    }

    /**
     * After finish project, invoke method to calculate the chance of leveling
     * up of each employee.
     *
     * @param project
     */
    @Override
    public void levelUp(Project project) {
        project.levelUp();
        setChanged();
        String message = String.format("Leveled up employees in project %s.",
                project.getName());
        notifyObservers(message);
    }

    /**
     * loop through employee list and reduce user's capital
     */
    @Override
    public void paySalary() {
        try {
            company.paySalary();
            setChanged();
            String message = String.format("Paid salary: -$%.2f",
                    company.calculateTotalSalary());
            notifyObservers(message);
        } catch (MoneyRunOutException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Generate new Employee list
     *
     * @return List of Employee
     */
    @Override
    public List<Employee> generateEmployeeList() {
        Random random = new Random();
        int number = random.nextInt(3) + 3;
        return Utilities.generateEmployeeList(level, number, this);
    }

    /**
     * Generate new Project list
     *
     * @return List of Project
     */
    @Override
    public List<Project> generateProjectList() {
        Random random = new Random();
        int number = random.nextInt(3) + 8;
        return Utilities.generateProjectList(level, number, this);
    }

    /**
     * The next turn button in GUI will invoke this method and do the following
     * - check any project success or fail - generate Project list and Employee
     * list incase user want to take new projects or hire new employees.
     *
     * @throws MoneyRunOutException when user's capital is less than or equal
     * zero
     */
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
        String message = String.format("New turn began: Year %d Month %d Week %d",
                dateTime.getYear(), dateTime.getMonthOfYear(),
                dateTime.getWeekOfMonth());
        notifyObservers(message);
    }

    /**
     * Increase the week number by one
     */
    private void nextWeek() {
        eventOccur();
        consumeFood();
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
    public float getItemExpenses() {
        return company.getItemExpenses();
    }

    @Override
    public Map<String, Float> getExpenseItems() {
        return company.getItems();
    }

    /**
     * Get employee by name.
     *
     * @param name
     * @return
     */
    @Override
    public Employee getEmployeeByName(String name) {
        return company.getEmployeeByName(name);
    }

    /**
     * Get project by name.
     *
     * @param name
     * @return
     */
    @Override
    public Project getProjectByName(String name) {
        return company.getProjectByName(name);
    }
    
    public void assignEmployeeToProject(Employee emp,Project proj,Skill field) throws EmployeeIsBusyException{
        if(!company.assignEmployeeToProject(emp, proj, field)){
            throw new EmployeeIsBusyException();
        }
    }
    
       
    private void consumeFood(){
        //TODO next sprint
    }
}
