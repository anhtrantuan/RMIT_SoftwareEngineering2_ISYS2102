/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model.facade;

import devfortress.model.*;
import devfortress.model.exception.MoneyRunOutException;
import devfortress.model.exception.UnaffordableException;
import devfortress.utilities.Utilities;
import java.util.Observable;
// TODO implement statergy partern

/**
 *
 * @author cathoanghuy
 */
public class Engine extends Observable implements Model, Runnable {

    private Company company;

    public Engine(Company company) {
        this.company = company;
    }

    @Override
    public void buyItem(Item item) {
        try {
            company.buyItem(item);
            // TODO implement Engine.buyItem
        } catch (UnaffordableException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void hireEmployee(Employee employee) {
        company.addEmployee(employee);
        if (!Utilities.assignComputerToEmployee(company, employee)) {
            System.out.println("Do not enough computer");
        }

        // TODO implement Engine.hireEmployee
    }

    @Override
    public void fireEmployee(Employee employee) {
        company.removeEmployee(employee);
        // TODO implement Engine.fireEmployee
    }

    @Override
    public void takeProject(Project project) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void cancelProject(Project project) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void eventOccure() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void levelUp(Project project) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void paySalary() {
        try {
            company.paySalary();
        } catch (MoneyRunOutException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void run() {
        
    }
}
