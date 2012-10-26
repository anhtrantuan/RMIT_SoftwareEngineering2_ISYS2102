/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model.facade;

import devfortress.model.Employee;
import devfortress.model.Item;
import devfortress.model.Project;

/**
 *
 * @author cathoanghuy
 */
public class Engine implements Model{

    @Override
    public void buyFood(Item item) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void hireEmployee(Employee employee) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void fireEmployee(Employee employee) {
        throw new UnsupportedOperationException("Not supported yet.");
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
    
}
