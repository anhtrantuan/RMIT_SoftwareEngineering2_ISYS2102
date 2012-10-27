/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model.facade;

import devfortress.model.*;

/**
 *
 * @author cathoanghuy
 */
public class Engine implements Model {

    private Company company;

    @Override
    public void buyItem(Item item) {
        company.buyItem(item);
        // TODO implement Engine.buyItem
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
    
    public void paySalary(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
