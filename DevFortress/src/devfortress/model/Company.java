/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model;

import devfortress.model.exception.MoneyRunOutException;
import devfortress.model.exception.UnaffordableException;
import devfortress.utilities.Constant;
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
    private float totalSalary;
    private float expenses;
    private Map<String, Float> items;

    public Company() {
        money = 1000f;
    }

    public Company(int money, List empList, Map computerList, List projectList, Map itemsList) {
        this.money = money;
        employeeList = empList;
        this.computerList = computerList;
        currentProjectList = projectList;
        items = itemsList;
        totalSalary = 0;
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
    }

    public void removeEmployee(Employee emp) {
        calculateTotalSalary();
        employeeList.remove(emp);
    }

    public void buyItem(Item item, int quantity) throws UnaffordableException {
        float value = item.getPrice() * quantity;
        if (money > (item.getPrice() * quantity)) {
            throw new UnaffordableException("You do not have enough money to buy");
        } else {
            decreaseMoney(item.getPrice() * quantity);
            expenses += value;
            if (item instanceof Computer) {
                computerList.put((Computer) item, null);

                items.put(Constant.COMPUTER_EXPENSE, value);

            } else if (item instanceof Beer || item instanceof Food) {

                items.put(Constant.FOOD_N_DRINK_EXPENSE, value);

            }
        }
    }

    public boolean paySalary() throws MoneyRunOutException {
        
        money -= totalSalary;
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
        for (Employee employee : employeeList) {
            totalSalary += employee.getSalary();
        }
        return totalSalary;
    }

    public float getExpenses() {
        return expenses;
    }

    
    public void resetExpense(){
        expenses = 0;
    }


    public float getFoodandDrinkExpense() {
        if (items.containsKey(Constant.FOOD_N_DRINK_EXPENSE)) {
            return items.get(Constant.FOOD_N_DRINK_EXPENSE);
        }
        return 0f;
    }

    public float getComputerExpense() {
        if (items.containsKey(Constant.COMPUTER_EXPENSE)) {
            return items.get(Constant.COMPUTER_EXPENSE);
        }
        return 0f;
    }

    public void clearItemList() {
        items.clear();
    }

}
