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
public interface Model {

    void buyFood(Item item);  
    
    void hireEmployee(Employee employee);
    
    void fireEmployee(Employee employee);
    
    void takeProject(Project project);
    
    void cancelProject(Project project);
    
    
}
