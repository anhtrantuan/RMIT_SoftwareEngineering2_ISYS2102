/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model.facade;

import devfortress.model.DateTime;
import devfortress.model.Employee;
import devfortress.model.Item;
import devfortress.model.Project;
import devfortress.model.exception.EmployeeIsBusyException;
import devfortress.model.exception.MoneyRunOutException;
import devfortress.model.exception.OvercrowdedException;
import devfortress.utilities.Skill;
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

    List<Employee> getAvailableEmployeeList();

    List<Project> getAvailableProjectList();

    void nextTurn() throws MoneyRunOutException;

    Map<String, Float> getItems();

    List<Employee> getEmployeeList();

    List<Project> getProjectList();

    DateTime getCurrentTimePlayed();

    float getBudget();

    float getTotalSalary();

    float getExpenses();

    float getItemExpenses();

    Map<String, Float> getExpenseItems();

    Employee getEmployeeByName(String name);

    Project getProjectByName(String name);

    void assignEmployeeToProject(Employee emp, Project proj, Skill field) throws EmployeeIsBusyException;

    void unassignEmployee(Project proj, Employee emp);
}
