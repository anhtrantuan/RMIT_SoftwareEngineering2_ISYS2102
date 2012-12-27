/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model.facade;

import devfortress.model.Company;
import devfortress.model.DateTime;
import devfortress.model.Item;
import devfortress.model.employee.Employee;
import devfortress.model.exception.EmployeeIsBusyException;
import devfortress.model.exception.EmployeeNotExist;
import devfortress.model.exception.MoneyRunOutException;
import devfortress.model.exception.OvercrowdedException;
import devfortress.model.exception.UnaffordableException;
import devfortress.model.project.Project;
import devfortress.utilities.Skill;
import java.util.List;
import java.util.Map;

/**
 *
 * @author cathoanghuy
 */
public interface Model {

    void buyItem(Item item, int quantity) throws UnaffordableException, MoneyRunOutException;

    void hireEmployee(Employee employee) throws OvercrowdedException, UnaffordableException, MoneyRunOutException;

    void fireEmployee(Employee employee) throws EmployeeNotExist;

    void takeProject(Project project);

    void cancelProject(Project project) throws MoneyRunOutException;

    void eventOccur();

    void levelUp(Project project);

    void paySalary() throws MoneyRunOutException;

    List<Employee> getAvailableEmployeeList();

    List<Project> getAvailableProjectList();

    void nextTurn() throws MoneyRunOutException, EmployeeNotExist;

    Map<String, Float> getItems();

    List<Employee> getEmployeeList();

    List<Project> getProjectList();

    DateTime getCurrentTimePlayed();

    float getBudget();

    public void checkBudget() throws MoneyRunOutException;

    float getTotalSalary();

    float getExpenses();

    float getItemExpenses();

    Map<String, Float> getExpenseItems();

    Employee getEmployeeByName(String name);

    Project getProjectByName(String name);

    void assignEmployeeToProject(Employee emp, Project proj, Skill field) throws EmployeeIsBusyException;

    void unassignEmployee(Project proj, Employee emp);

    Project getWorkingProjectOfEmployee(Employee emp);

    void train(Employee emp, Skill sk) throws UnaffordableException;

    void untrain(Employee emp);

    void drink(Employee emp);

    void createGoldenEmployee();

    List<Employee> getUnassignedEmployeeList();

    Company getCompany();
}
