/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model;

import devfortress.model.employee.Employee;
import devfortress.model.exception.EmployeeNotExist;
import devfortress.utilities.Skill;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public CompanyTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        company = new Company();
        employee = new Employee("employee1", new HashMap<Skill, Integer>());
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
    public void decreaseMoney() {
        System.out.println("Test decrease money: decrease budget by 100");
        company.decreaseMoney(100f);
        assertEquals(1000f, company.getMoney(), 0);
    }

    @Test
    public void getEmployeeByName() throws EmployeeNotExist {
        System.out.println("Test get employee by name: valid name");
        company.addEmployee(employee);
        assertEquals(employee, company.getEmployeeByName("employee1"));
    }

    @Test(expected = EmployeeNotExist.class)
    public void getEmployeeByName2() throws EmployeeNotExist {
        System.out.println("Test get employee by name: invalid name");
        company.getEmployeeByName("abc");
    }

    @Test(expected = EmployeeNotExist.class)
    public void removeEmployee() throws EmployeeNotExist {
        System.out.println("Test remove employee: valid employee");
        try {
            company.removeEmployee(employee);
        } catch (EmployeeNotExist ex) {
            Logger.getLogger(CompanyTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        company.getEmployeeByName("employee1");

    }

    @Test(expected = EmployeeNotExist.class)
    public void removeEmployee2() throws EmployeeNotExist {
        System.out.println("Test remove employee: invalid employee");

        company.removeEmployee(employee);
    }
    
    @Test
    public void buyItem(){
        System.out.println("Test buy item:");
    }
}
