/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model;

import devfortress.model.exception.MoneyRunOutException;
import devfortress.model.exception.UnaffordableException;
import java.util.List;

/**
 *
 * @author Sherlock
 */
public class Company {
    
    private float money;
    private List<Employee> employeeList;
    
    public Company() {
        money = 1000;
    }
    
    public Company(int money) {
        this.money = money;
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
        }
    }
    
    public boolean paySalary() throws MoneyRunOutException {
        for (Employee employee : employeeList) {
            decreaseMoney(employee.getSalary());
            if (money <= 0) {
                throw new MoneyRunOutException("You are out of money");
            }
        }
        return true;
    }
    
    public void test() {
    }
}
