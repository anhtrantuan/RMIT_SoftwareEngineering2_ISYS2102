/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model.event;

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
public class IndividualEventTest {
    private static IndividualEvent e;
    public IndividualEventTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        e = new IndividualEvent();
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
    public void developerSick(){
//        e.developerHasBaby(null)
    }
}
