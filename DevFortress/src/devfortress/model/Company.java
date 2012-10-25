/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model;

/**
 *
 * @author Sherlock
 */
public class Company {

    private int money;

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
    
    public void test(){
        
    }
}
