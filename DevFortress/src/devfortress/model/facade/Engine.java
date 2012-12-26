/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model.facade;

import devfortress.model.*;
import devfortress.model.dificulity.DifficultLevel;
import devfortress.model.dificulity.EasyLevel;
import devfortress.model.dificulity.GameLevel;
import devfortress.model.dificulity.MediumLevel;
import devfortress.model.employee.Employee;
import devfortress.model.event.IndividualEvent;
import devfortress.model.exception.*;
import devfortress.model.project.Project;
import devfortress.utilities.Event;
import devfortress.utilities.Skill;
import devfortress.utilities.Utilities;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cathoanghuy
 */
public class Engine extends Observable implements Model {

    private Company company;
    private GameLevel level;
    private DateTime dateTime;
    private EasyLevel easyLevel;
    private MediumLevel mediumLevel;
    private DifficultLevel difficultLevel;
    private List<Employee> availableEmployees;
    private List<Project> availableProjects;
    private Utilities utilities;
    private ArrayList<Event> events;

    public Engine() throws EmployeeNotExist {
        this(new Company());
    }

    public Engine(Company company) throws EmployeeNotExist {
        utilities = Utilities.getInstance();
        this.company = company;
        dateTime = new DateTime();
        easyLevel = new EasyLevel();
        level = easyLevel;
        mediumLevel = new MediumLevel();
        difficultLevel = new DifficultLevel();
        availableEmployees = generateEmployeeList();
        availableProjects = generateProjectList();
        events = new ArrayList<Event>();
    }

    /**
     * Buy an item with quantity
     *
     * @param item
     * @param quantity
     */
    @Override
    public void buyItem(Item item, int quantity) throws UnaffordableException {

        company.buyItem(item, quantity);
        setChanged();
        String message = String.format("Bought %d new %s: -$%.2f.",
                quantity, item.getName() + (quantity > 1 ? "s" : ""),
                (item.getPrice() * quantity));
        DataObject data = new DataObject(message, null);
        notifyObservers(data);

    }

    /**
     * Hire more employee
     *
     * @param employee
     * @throws OvercrowdedException when the number of employee more than number
     * of computer
     */
    @Override
    public void hireEmployee(Employee employee) throws UnaffordableException, OvercrowdedException {
        //assume that Company will automatically buy computer for new employee in case of lacking computer
        //TODO fix this in next phase
        if (!utilities.assignComputerToEmployee(company, employee)) {
            throw new OvercrowdedException();
        }
        company.addEmployee(employee);
        setChanged();
        String message = String.format("Hired new employee %s: -$%.2f.",
                employee.getName(), employee.getSalary());
        DataObject data = new DataObject(message, null);
        notifyObservers(data);
    }

    @Override
    public void fireEmployee(Employee employee) throws EmployeeNotExist {
        company.removeEmployee(employee);
        setChanged();
        String message = String.format("Fired employee %s: +$%.2f.",
                employee.getName(), employee.getSalary());
        notifyObservers(message);
    }

    @Override
    public void takeProject(Project project) {
        company.addProject(project);
        setChanged();
        String message = String.format("Contracted new project %s: +$%.2f.",
                project.getName(), project.getPayment() / 2);
        DataObject data = new DataObject(message, null);
        notifyObservers(data);
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
        String message = String.format("Cancel project %s: -$%.2f.",
                project.getName(), project.getPayment() * 0.8);
        DataObject data = new DataObject(message, null);
        notifyObservers(data);
    }

    /**
     * Invoke method each week to calculate chance which event will happen in
     * that week
     */
    @Override
    public void eventOccur() {
        for (Employee employee : availableEmployees) {
            events.add(level.generateEvent(employee, company));
        }
        String message = String.format("Event occurred!");
        DataObject data = new DataObject(message, events);
        notifyObservers(data);
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
        DataObject data = new DataObject(message, null);
        notifyObservers(data);
    }

    /**
     * loop through employee list and reduce user's capital
     */
    @Override
    public void paySalary() {

        company.paySalary();
        setChanged();
        String message = String.format("Paid salary: -$%.2f.",
                company.calculateTotalSalary());
        DataObject data = new DataObject(message, null);
        notifyObservers(data);

    }

    /**
     * Generate new Employee list
     *
     * @return List of Employee
     */
    private List<Employee> generateEmployeeList() {
        Random random = new Random();
        int number = random.nextInt(3) + 3;
        return utilities.generateEmployeeList(level, number, this);
    }

    /**
     * Generate new Project list
     *
     * @return List of Project
     */
    private List<Project> generateProjectList() {
        Random random = new Random();
        int number = random.nextInt(3) + 8;
        return utilities.generateProjectList(level, number, this);
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
    public void nextTurn() {

        List<Project> succeededProject = new ArrayList();
        List<Project> failedProject = new ArrayList();

        if (dateTime.getYear() < 2) {
            level = easyLevel;
        } else if (dateTime.getYear() < 4) {
            level = mediumLevel;
        } else {
            level = difficultLevel;
        }

        for (int i = 0; i < 4; i++) {
            nextWeek();
        }

        for (Project project : company.getCurrentProjectList()) {
            if (project.checkProjectProcess()) {
                succeededProject.add(project);
            } else {
                project.getRemainingTime().nextTurn();
                if (project.getRemainingTime().getMonths() == 0) {
                    failedProject.add(project);
                }
            }
        }

        for (Project proj : failedProject) {
            company.cancelProject(proj);
        }
        for (Project proj : succeededProject) {
            company.finishProject(proj);
        }

        availableProjects = generateProjectList();
        availableEmployees = generateEmployeeList();
        paySalary();

        try {
            checkBudget();
        } catch (MoneyRunOutException ex) {
            Logger.getLogger(Engine.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            company.clearItemList();

            setChanged();

            String message = String.format("New turn began: Year %d Month %d Week %d.",
                    dateTime.getYear(), dateTime.getMonthOfYear(),
                    dateTime.getWeekOfMonth());
            DataObject data = new DataObject(message, events);
            notifyObservers(data);
        }
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

    @Override
    public void assignEmployeeToProject(Employee emp, Project proj, Skill field) throws EmployeeIsBusyException {
        if (!company.assignEmployeeToProject(emp, proj, field)) {
            throw new EmployeeIsBusyException();
        }

        setChanged();
        String message = String.format("Assigned employee %s to skill %s in project %s.",
                emp.getName(), field.toString(), proj.getName());
        DataObject data = new DataObject(message, null);
        notifyObservers(data);
    }

    private void consumeFood() {
        company.consumeItem();
    }

    /**
     * Get available employee list.
     *
     * @return
     */
    @Override
    public List<Employee> getAvailableEmployeeList() {
        return availableEmployees;
    }

    /**
     * Get available project list.
     *
     * @return
     */
    @Override
    public List<Project> getAvailableProjectList() {
        return availableProjects;
    }

    @Override
    public void unassignEmployee(Project proj, Employee emp) {
        company.unassignEmployee(proj, emp);
        setChanged();
        String message = String.format("Unassigned employee %s from project %s.",
                emp.getName(), proj.getName());
        DataObject data = new DataObject(message, null);
        notifyObservers(data);
    }

    @Override
    public Project getWorkingProjectOfEmployee(Employee emp) {
        return emp.getWorkingProject();
    }

    @Override
    public void train(Employee emp, Skill sk) throws UnaffordableException {
        company.trainEmployee(emp, sk);
    }

    @Override
    public void checkBudget() throws MoneyRunOutException {
        if (company.getMoney() <= 0) {
            throw new MoneyRunOutException();
        }
    }

    @Override
    public void drink(Employee emp) {
        company.drinkBeer(emp);
    }
}
