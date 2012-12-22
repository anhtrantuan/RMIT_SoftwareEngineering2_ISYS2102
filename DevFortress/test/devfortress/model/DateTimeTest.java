/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model;

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
public class DateTimeTest {

//    private static DateTime date;
    public DateTimeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
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
    public void nextWeek() {
        System.out.println("Test next week method");
        DateTime date = new DateTime(4, 4, 1);
        date.nextWeek();
        assertEquals(1, date.getWeekOfMonth());
        assertEquals(5, date.getMonthOfYear());
        
    }
    
    @Test
    public void nextMonth() {
        System.out.println("Test next month method");
        DateTime date = new DateTime(4, 12, 1);
        date.nextMonth();
        assertEquals(1, date.getMonthOfYear());
        assertEquals(2, date.getYear());
    }
    
    @Test
    public void nextTurn() {
        System.out.println("Test next turn method");
        DateTime date = new DateTime(2, 0, 1);
        date.nextTurn();
        assertEquals(12, date.getMonthOfYear());
        assertEquals(0, date.getYear());
    }
}
