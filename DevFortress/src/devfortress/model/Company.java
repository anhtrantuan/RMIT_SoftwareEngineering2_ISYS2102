/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model;

import devfortress.model.exception.MoneyRunOutException;
import devfortress.model.exception.UnaffordableException;
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


    public Company() {
        money = 1000;
    }

    public Company(int money, List empList, Map computerList, List projectList) {
        this.money = money;
        employeeList = empList;
        this.computerList = computerList;
        currentProjectList = projectList;
        totalSalary =0;
        expenses=0;
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
        employeeList.add(newEmp);
    }

    public void removeEmployee(Employee emp) {
        employeeList.remove(emp);
    }

    public void buyItem(Item item) throws UnaffordableException {

        if (money > item.getPrice()) {
            throw new UnaffordableException("You do not have enough money to buy");
        } else {  
            decreaseMoney(item.getPrice());
            expenses+=item.getPrice();
            if (item instanceof Computer) {
                computerList.put((Computer) item, null);
            }
        }
    }    

    public boolean paySalary() throws MoneyRunOutException {
        calculateTotalSalary();
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
    
    public float getExpenses(){
        return expenses;
    }
}
