/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model;

import devfortress.model.employee.Employee;
import devfortress.model.exception.EmployeeNotExist;
import devfortress.model.exception.MoneyRunOutException;
import devfortress.model.exception.UnaffordableException;
import devfortress.model.project.Project;
import devfortress.utilities.Skill;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cat Hoang Huy
 */
public class CompanyTest {

    private static Company company;
    private static Employee employee;
    private static Project project;

    public CompanyTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        company = new Company();
        employee = new Employee("employee1", new HashMap<Skill, Integer>());
        project = new Project("project1", 100, 100, 1, new DateTime(), new HashMap<Skill, Integer>());
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
    public void increaseMoney() {
        System.out.println("Test increase money: increase budget by 100");
        company.increaseMoney(100);
        assertEquals(1000f + 100f, company.getMoney(), 0);
    }

    @Test
    public void decreaseMoney() throws MoneyRunOutException {
        System.out.println("Test decrease money: decrease budget by 100");
        company.decreaseMoney(100f);
        assertEquals(1000f, company.getMoney(), 0);
    }

    @Test
    public void getEmployeeByName() throws EmployeeNotExist, MoneyRunOutException {
        System.out.println("Test get employee by name: valid name");
        company.addEmployee(employee);
        assertEquals(employee, company.getEmployeeByName("employee1"));
    }

    @Test
    public void getEmployeeByName2() throws EmployeeNotExist {
        System.out.println("Test get employee by name: invalid name");
        assertEquals(null, company.getEmployeeByName("abc"));
    }

    @Test
    public void removeEmployee() throws EmployeeNotExist {
        System.out.println("Test remove employee: valid employee");

        company.removeEmployee(employee);

        assertEquals(null, company.getEmployeeByName("employee1"));

    }

    @Test(expected = EmployeeNotExist.class)
    public void removeEmployee2() throws EmployeeNotExist {
        System.out.println("Test remove employee: invalid employee");

        company.removeEmployee(employee);
    }

    @Test
    public void buyItem() throws UnaffordableException, MoneyRunOutException {
        System.out.println("Test buy item: buy affordable item");
        company.buyItem(new Computer(100f), 1);
        assertEquals(1000f - 100f, company.getMoney(), 0);

    }

    @Test(expected = UnaffordableException.class)
    public void buyItem2() throws UnaffordableException, MoneyRunOutException {
        System.out.println("Test buy item: buy unaffordable item");
        company.buyItem(new Computer(1000f), 1);
    }

    @Test
    public void getProjectByName() {
        System.out.println("Test get project by name: valid project");
        company.addProject(project);
        assertEquals(project, company.getProjectByName("project1"));
    }

    @Test
    public void getProjectByName2() {
        System.out.println("Test get project by name: invalid project");
        assertEquals(null, company.getProjectByName("project2"));
    }

    @Test
    public void cancelProject() throws MoneyRunOutException {
        System.out.println("Test cancel project: valid project");
        company.cancelProject(project);
        assertEquals(null, company.getProjectByName("project1"));
    }

    @Test
    public void addEmployee() {
        System.out.println("Test add employee");
        int numberEmp = company.getEmployeeList().size();
        company.addEmployee(employee);
        assertEquals(numberEmp, company.getEmployeeList().size() - 1);
    }

    @Test
    public void addProject() {
        System.out.println("Test add project");
        int numberPro = company.getCurrentProjectList().size();
        company.addProject(project);
        assertEquals(numberPro, company.getCurrentProjectList().size() - 1);
    }

    @Test
    public void clearItemList() {
        System.out.println("Test clear item list");
        company.clearItemList();
        assertEquals(company.getItems().size(), 0);
    }
}
