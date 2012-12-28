/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model;

import devfortress.model.employee.Employee;
import devfortress.model.exception.EmployeeNotExist;
import devfortress.model.exception.UnaffordableException;
import devfortress.model.project.Project;
import devfortress.utilities.Constant;
import devfortress.utilities.Skill;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/**
 *
 * @author Sherlock
 */
public class Company {

    private float budget;
    private List<Employee> employeeList;
    private Map<Computer, Employee> computerList;
    private List<Project> currentProjectList;
    private float expenses;
    private Map<String, Float> items;
    private int foodStock, beerStock;
    private ArrayList<Employee> removeEmployeeList;
//    private LinkedHashMap<>

    public Company() {
        this(1000f, new ArrayList<Employee>(),
                new HashMap<Computer, Employee>(),
                new ArrayList<Project>(), new HashMap<String, Float>());
        removeEmployeeList = new ArrayList<Employee>();
    }

    public Company(float money, List<Employee> empList,
            Map<Computer, Employee> computerList, List<Project> projectList,
            Map<String, Float> itemsList) {
        this.budget = money;
        employeeList = empList;
        this.computerList = computerList;
        currentProjectList = projectList;
        items = itemsList;
        removeEmployeeList = new ArrayList<Employee>();
        expenses = 0;
    }

    public float getMoney() {
        return budget;
    }

    /**
     *
     * @param amount
     */
    public void increaseMoney(float amount) {
        budget += amount;
    }

    /**
     *
     * @param amount
     */
    public void decreaseMoney(float amount) {
        budget -= amount;
    }

    /**
     *
     * @param newEmp
     */
    public void addEmployee(Employee newEmp) {
        employeeList.add(newEmp);
        calculateTotalSalary();
        expenses += newEmp.getSalary();
    }

    /**
     * Get employee by name.
     *
     * @param name
     * @return
     */
    public Employee getEmployeeByName(String name) {
        for (ListIterator<Employee> iterator = employeeList.listIterator();
                iterator.hasNext();) {
            Employee employee = iterator.next();
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }

    /**
     *
     * @param emp Employee that user want to fire
     */
    public void removeEmployee(Employee emp) throws EmployeeNotExist {
        Project workingProj = emp.getWorkingProject();
        if (!employeeList.contains(emp)) {
            throw new EmployeeNotExist();
        }
        if (workingProj != null) {
            unassignEmployee(workingProj, emp);
        }
        calculateTotalSalary();
        employeeList.remove(emp);
        //increaseMoney(emp.getSalary());
        expenses -= emp.getSalary();
    }

    /**
     *
     * @param item
     * @param quantity
     * @throws UnaffordableException
     */
    public void buyItem(Item item, int quantity) throws UnaffordableException {
        float value = item.getPrice() * quantity;
        if (budget < (value)) {
            throw new UnaffordableException();
        } else {
            decreaseMoney(item.getPrice() * quantity);
            expenses += value;
            String name = "";
            if (item instanceof Computer) {
                for (int i = 0; i < quantity; i++) {
                    computerList.put(new Computer(item.getPrice()), null);
                }
                name = Constant.EXPENSE_COMPUTERS;
            } else if (item instanceof Food) {
                name = Constant.EXPENSE_FOODS;
                foodStock += quantity;
            } else if (item instanceof Beer) {
                name = Constant.EXPENSE_BEERS;
                beerStock += quantity;
            }
            float newValue;
            if (items.containsKey(name)) {
                newValue = items.get(name) + value;
            } else {
                newValue = value;
            }
            items.put(name, newValue);
        }
    }

    /**
     *
     * @return @throws MoneyRunOutException when the capital is less or equal
     * than zero
     */
    public boolean paySalary() {

        budget -= calculateTotalSalary();
        if (budget <= 0) {
            return false;
        }
        return true;
    }

    public Map<Computer, Employee> getComputerList() {
        return computerList;
    }

    public void setComputerList(Map<Computer, Employee> computerList) {
        this.computerList = computerList;
    }

    public Map<String, Float> getItems() {
        return items;
    }

    public void setItems(Map<String, Float> items) {
        this.items = items;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<Project> getCurrentProjectList() {
        return currentProjectList;
    }

    public void setCurrentProjectList(List<Project> currentProjectList) {
        this.currentProjectList = currentProjectList;
    }

    /**
     * Add project to project list
     *
     * @param project
     */
    public void addProject(Project project) {
        currentProjectList.add(project);
        increaseMoney(project.getPayment() / 2);
    }

    /**
     * Get project by name.
     *
     * @param name
     * @return
     */
    public Project getProjectByName(String name) {
        for (ListIterator<Project> iterator = currentProjectList.listIterator();
                iterator.hasNext();) {
            Project project = iterator.next();
            if (project.getName().equals(name)) {
                return project;
            }
        }

        return null;
    }

    /**
     * remove project when project fail or be canceled.
     *
     * @param project
     */
    public void cancelProject(Project project) {
        project.unassignEmployees();
        currentProjectList.remove(project);
        decreaseMoney(project.getPayment() * 0.8f);
    }

    /**
     * remove project when project success
     *
     * @param project
     */
    public void finishProject(Project project) {
        currentProjectList.remove(project);
        increaseMoney(project.getPayment() / 2);
    }

    public float calculateTotalSalary() {
        float totalSalary = 0;
        for (Employee employee : employeeList) {
            totalSalary += employee.getSalary();
        }
        return totalSalary;
    }

    public float getExpenses() {
        return expenses;
    }

    public void nextTurn() {
        expenses = calculateTotalSalary();
        items.clear();
    }

    /**
     *
     * @return
     */
    public float getItemExpenses() {
        float total = 0;

        if (items.containsKey(Constant.EXPENSE_FOODS)) {
            total += items.get(Constant.EXPENSE_FOODS);
        }
        if (items.containsKey(Constant.EXPENSE_BEERS)) {
            total += items.get(Constant.EXPENSE_BEERS);
        }
        if (items.containsKey(Constant.EXPENSE_COMPUTERS)) {
            total += items.get(Constant.EXPENSE_COMPUTERS);
        }

        return total;
    }

    public void clearItemList() {
        items.clear();
    }

    /**
     * assign an employee to selected project with a specific field, employee
     * will be happy if he/she is assigned into a project which having the
     * project type similar as his/her main skill, get sad otherwise
     *
     * @param emp
     * @param field
     */
    public boolean assignEmployeeToProject(Employee emp, Project proj, Skill field) {
        return proj.assignEmployeeToProject(emp, field);
    }

    /**
     *
     * @param proj
     * @param emp
     */
    public void unassignEmployee(Project proj, Employee emp) {
        proj.unassignEmployee(emp);
    }

    public void trainEmployee(Employee e, Skill sk) throws UnaffordableException {
        float fee = e.getTrainingFee(sk);
        if (budget - fee < 0) {
            throw new UnaffordableException("Not enough money");
        } else {
            e.saveState(fee);
            e.skillLevelUp(sk);
            budget -= fee;
        }
    }

    public void consumeFood(Employee emp) {
        if (foodStock > 0) {
            emp.eat();
            foodStock--;
        }
    }

    public void drinkBeer(Employee e) {
        if (beerStock > 0) {
            e.drink();
            beerStock--;
        }
    }

    public int getBeerStock() {
        return beerStock;
    }

    public int getFoodStock() {
        return foodStock;
    }

    public void unTrain(Employee em) {
        budget += em.back();
    }
    
    public void addEmployeeToRemoveList(Employee e){
        removeEmployeeList.add(e);
    }
    
    public ArrayList<Employee> getEmployeeRemovedList(){
        return removeEmployeeList;
    }
    
}
