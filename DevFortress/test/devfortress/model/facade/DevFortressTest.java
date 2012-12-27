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
import devfortress.model.exception.MoneyRunOutException;
import devfortress.model.exception.OvercrowdedException;
import devfortress.model.exception.UnaffordableException;
import devfortress.utilities.Skill;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
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

    private static Model company;
    private static Item item;
    private static Employee employee;

    public DevFortressTest() {
    }

    @BeforeClass
    public static void setUpClass() throws EmployeeNotExist {
        company = new Engine();
        item = new Food(100, "pizza");
        employee = new Employee("employee1", new EnumMap<Skill, Integer>(Skill.class));
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

//    @Test
//    public void sample() {
//        System.out.println("Sample Test");
//        assertTrue(true);
//    }
    @Test
    public void testBuyItem2() throws UnaffordableException, EmployeeNotExist, MoneyRunOutException {
        Model company = new Engine();
        System.out.println("Test Buy 0 Item");
        float money = company.getBudget();
        company.buyItem(item, 0);
        assertEquals(money, company.getBudget(), 0);
    }

    @Test
    public void testBuyItem() throws UnaffordableException, EmployeeNotExist, MoneyRunOutException {
        Model company = new Engine();
        System.out.println("Test Buy 1 Item:");
        float money = company.getBudget() - item.getPrice();
        company.buyItem(item, 1);
        assertEquals(money, company.getBudget(), 0);
    }

    @Test(expected = UnaffordableException.class)
    public void testBuyManyItem() throws UnaffordableException, EmployeeNotExist, MoneyRunOutException {
        Model company = new Engine();
        company.buyItem(item, 11);
        System.out.println("Test Buy too much Item");
    }

    @Test(expected = OvercrowdedException.class)
    public void testHireEmployee() throws OvercrowdedException, UnaffordableException, EmployeeNotExist, MoneyRunOutException {
        Model company = new Engine();
        System.out.println("Test hire employee");
        company.hireEmployee(employee);
        assertEquals("Result: ", 1, company.getEmployeeList().size());
    }

    @Test
    public void testHireEmployee2() throws OvercrowdedException, UnaffordableException, MoneyRunOutException {
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
    
    @Test
    public void createGoldenEmployee(){
        System.out.println("Test create Golden employee");
        int highest;
        company.createGoldenEmployee();
        List<Employee> list = company.getAvailableEmployeeList();
        Employee emp = list.get(list.size()-1);
        assertEquals("Result", 10, emp.getSkillList().get(emp.getMainSkill()).intValue());
    }
    
    @Test
    public void drink(){
        System.out.println("Test drink");
    }
    
    @Test
    public void train(){
        System.out.println("Test train");
    }
    
    @Test
    public void untrain(){
        System.out.println("Test untrain");
    }
    
    @Test
    public void getWorkingProjectOfEmployee(){
        System.out.println("Test get working project of employee");
    }
}
