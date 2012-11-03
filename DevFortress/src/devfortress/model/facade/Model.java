/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model.facade;

import devfortress.model.Employee;
import devfortress.model.Item;
import devfortress.model.Project;

import devfortress.model.dificulity.GameLevel;

import devfortress.model.exception.OvercrowdedException;

import java.util.List;

/**
 *
 * @author cathoanghuy
 */
public interface Model {

    void buyItem(Item item);

    void hireEmployee(Employee employee) throws OvercrowdedException;

    void fireEmployee(Employee employee);

    void takeProject(Project project);

    void cancelProject(Project project);

    void eventOccure();

    void levelUp(Project project);

    void paySalary();

    List<Employee> generateEmployeeList();

    List<Project> generateProjectList();
}
