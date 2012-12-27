/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.utilities;

import devfortress.model.employee.Employee;
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
public class UtilityTest {

    private static Utilities util;

    public UtilityTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        util = Utilities.getInstance();
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
    public void getInstance() {
        System.out.println("Test get instance");
        Utilities u = Utilities.getInstance();
        assertTrue(u != null);
    }

    @Test
    public void calculateSalaryPoint() {
        System.out.println("Test calculate salary point: level 1 - orinal is not 24");
        int point = util.calculateSalaryPoint(Skill.C, 1);
        assertEquals(point, 1);

    }

    @Test
    public void calculateSalaryPoint2() {
        System.out.println("Test calculate salary point: level 1 - orinal is 24");
        int point = util.calculateSalaryPoint(Skill.CONFIG_MANAGEMENT, 1);
        assertEquals(point, 5);

    }

    @Test
    public void calculateSalaryPoint3() {
        System.out.println("Test calculate salary point: level 1 - orinal is 29");
        int point = util.calculateSalaryPoint(Skill.ALGORITHMS, 1);
        assertEquals(point, 3);
    }

    @Test
    public void generateGoldenEmployee() {
        System.out.println("Test generate Golden employee");
        Employee em = util.generateGoldenEmployee();
        for (Skill sk : em.getSkillList().keySet()) {
            assertEquals(em.getSkillList().get(sk).intValue(), 10);
        }
    }
}
