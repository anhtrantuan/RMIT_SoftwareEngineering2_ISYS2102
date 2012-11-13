/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model.facade;

import devfortress.model.DateTime;
import devfortress.model.Employee;
import devfortress.model.Item;
import devfortress.model.Project;
import devfortress.model.exception.MoneyRunOutException;
import devfortress.model.exception.OvercrowdedException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author cathoanghuy
 */
public interface Model {

    void buyItem(Item item, int quantity);

    void hireEmployee(Employee employee) throws OvercrowdedException;

    void fireEmployee(Employee employee);

    void takeProject(Project project);

    void cancelProject(Project project);

    void eventOccur();

    void levelUp(Project project);

    void paySalary();

    List<Employee> generateEmployeeList();

    List<Project> generateProjectList();
    
    void nextTurn() throws MoneyRunOutException;
    
    List getEmployeeList();
    
    List getProjectList();
            
    DateTime getCurrentTimePlayed();
    
    float getBudget();
    
    float getTotalSalary();
    
    float getExpenses();
    
    Map getItemsBoughtInMonth();
}
