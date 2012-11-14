/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model;

import devfortress.model.exception.MoneyRunOutException;
import devfortress.model.exception.UnaffordableException;
import devfortress.utilities.Constant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Sherlock
 */
public class Company {

    private float money;
    private List<Employee> employeeList;
    private Map<Computer, Employee> computerList;
    private List<Project> currentProjectList;
    private float expenses;
    private Map<String, Float> items;

    public Company() {
        this(1000f, new ArrayList<>(), new HashMap<>(), new ArrayList<>(), new HashMap<>());
    }

    public Company(float money, List empList, Map computerList, List projectList, Map itemsList) {
        this.money = money;
        employeeList = empList;
        this.computerList = computerList;
        currentProjectList = projectList;
        items = itemsList;
        expenses = 0;
    }

    public float getMoney() {
        return money;
    }

    public void increaseMoney(float amount) {
        money += amount;
    }

    public void decreaseMoney(float amount) {
        money -= amount;
    }

    public void addEmployee(Employee newEmp) {
        calculateTotalSalary();
        employeeList.add(newEmp);
        decreaseMoney(newEmp.getSalary());
        expenses += newEmp.getSalary();
    }

    public void removeEmployee(Employee emp) {
        calculateTotalSalary();
        employeeList.remove(emp);
        increaseMoney(emp.getSalary());
        expenses -= emp.getSalary();
    }

    public void buyItem(Item item, int quantity) throws UnaffordableException {
        float value = item.getPrice() * quantity;
        if (money < (item.getPrice() * quantity)) {
            throw new UnaffordableException("You do not have enough money to buy");
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
            } else if (item instanceof Beer) {
                name = Constant.EXPENSE_BEERS;
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

    public boolean paySalary() throws MoneyRunOutException {

        money -= calculateTotalSalary();
        if (money <= 0) {
            throw new MoneyRunOutException("You are out of money");
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

    public void addProject(Project project) {
        currentProjectList.add(project);
        increaseMoney(project.getPayment() / 2);
    }

    public void cancelProject(Project project) {
        currentProjectList.remove(project);
        decreaseMoney(project.getPayment() * 0.8f);
    }

    public void removeProject(Project project) {
        currentProjectList.remove(project);
    }

    public void test() {
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
}
