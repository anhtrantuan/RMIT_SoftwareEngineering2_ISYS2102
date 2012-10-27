/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model;

import java.util.List;

/**
 *
 * @author Sherlock
 */
public class Company {

    private int money;
    private List<Employee> employeeList;

    public Company() {
        money =1000;
    }

    public Company(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void increaseMoney(int amount) {
        money += amount;
    }

    public void decreaseMoney(int amount) {
        money -= amount;
    }
    
    public void addEmployee(Employee newEmp){
        employeeList.add(newEmp);
    }
    
    public void removeEmployee(Employee emp){
        employeeList.remove(emp);
    }
    
    public void buyItem(Item item){
        // TODO implement Company.buyItem
    }
    
    public void paySalary(){
        // TODO implement Company.paySalary
    }
    
    public void test(){
        
    }
}
