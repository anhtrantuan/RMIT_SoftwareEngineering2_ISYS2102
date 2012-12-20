/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model.facade;

import devfortress.model.Company;
import devfortress.model.Food;
import devfortress.model.Item;
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

    private Item item;

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
        Company company = new Company();
        System.out.println("Test Buy 0 Item");
        float money = company.getMoney();
        company.buyItem(item, 0);
        assertEquals(money, company.getMoney(), 0);
    }
    
    @Test
    public void testBuyItem() throws UnaffordableException {
        Company company = new Company();
        System.out.println("Test Buy 1 Item:");
        float money = company.getMoney() - item.getPrice();
        company.buyItem(item, 1);
        assertEquals(money, company.getMoney(), 0);
    }

    @Test(expected=UnaffordableException.class)
    public void testBuyManyItem() throws UnaffordableException{
        Company company = new Company();
        System.out.println("Test Buy too much Item");
        company.buyItem(item, 11);      
    }
}
