/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model.facade;

import devfortress.model.*;
import devfortress.model.exception.MoneyRunOutException;
import devfortress.model.exception.UnaffordableException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cathoanghuy
 */
public class Engine implements Model {

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
        // TODO implement Engine.hireEmployee
    }

    @Override
    public void fireEmployee(Employee employee) {
        company.removeEmployee(employee);
        // TOD implement Engine.fireEmployee
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
    public List<Project> generateProject(int numberOfProject) {
        List<Project> projects = new ArrayList<>();
        for (int i = 0; i < numberOfProject; i++) {
            // TODO implement Engine.generateProject
        }
        return projects;
    }

    @Override
    public List<Employee> genterateEmployee(int numberofEmployee) {
        List<Employee> employee = new ArrayList<>();
        for (int i = 0; i < numberofEmployee; i++) {
            //TODO implement Engine.generateEmployee
        }
        return employee;
    }
}
