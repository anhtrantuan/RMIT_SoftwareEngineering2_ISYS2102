/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model.facade;

import devfortress.model.Company;
import devfortress.model.Computer;
import devfortress.model.Food;
import devfortress.model.Item;
import devfortress.model.employee.Employee;
import devfortress.model.exception.EmployeeNotExist;
import devfortress.model.exception.OvercrowdedException;
import devfortress.model.exception.UnaffordableException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tommy
 */
public class DevFortressTest {

    private Model company;
    private Item item;
    private Employee employee;

    public DevFortressTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        item = new Food(100, "pizza");
        employee = new Employee();
    }

    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

//    @Test
//    public void sample() {
//        System.out.println("Sample Test");
//        assertTrue(true);
//    }
    @Test
    public void testBuyItem2() throws UnaffordableException {
        Model company = new Engine();
        System.out.println("Test Buy 0 Item");
        float money = company.getBudget();
        company.buyItem(item, 0);
        assertEquals(money, company.getBudget(), 0);
    }

    @Test
    public void testBuyItem() throws UnaffordableException {
        Model company = new Engine();
        System.out.println("Test Buy 1 Item:");
        float money = company.getBudget() - item.getPrice();
        company.buyItem(item, 1);
        assertEquals(money, company.getBudget(), 0);
    }

    @Test(expected = UnaffordableException.class)
    public void testBuyManyItem() throws UnaffordableException {
        Model company = new Engine();
        company.buyItem(item, 11);
        System.out.println("Test Buy too much Item");
    }

    @Test(expected = OvercrowdedException.class)
    public void testHireEmployee() throws OvercrowdedException, UnaffordableException {
        Model company = new Engine();
        System.out.println("Test hire employee");
        company.hireEmployee(employee);
        assertEquals("Result: ", 1, company.getEmployeeList().size());
    }

    @Test
    public void testHireEmployee2() throws OvercrowdedException, UnaffordableException {

        System.out.println("Test hire employee");
        company.buyItem(new Computer(), 1);
        company.hireEmployee(employee);
        assertEquals("Result: ", 1, company.getEmployeeList().size());
    }

    @Test
    public void testFireEmployee() throws EmployeeNotExist {
        System.out.println("Test fire employee");
        company.fireEmployee(employee);
        assertEquals("Result", 0, company.getEmployeeList().size());
    }
    
    
}
