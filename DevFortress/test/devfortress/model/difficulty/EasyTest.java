/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model.difficulty;

import devfortress.model.DateTime;
import devfortress.model.dificulity.DifficultLevel;
import devfortress.model.dificulity.EasyLevel;
import devfortress.model.dificulity.GameLevel;
import devfortress.utilities.Skill;
import java.util.Map;
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
public class EasyTest {
    
    private static GameLevel level;
    public EasyTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        level = new EasyLevel();
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
    public void generateSkillList() {
        System.out.println("Test generate skill list: easy level");
        Map<Skill, Integer> list = level.generateSkillList();
        assertEquals(4, list.size(), 3);
        for (Skill skill : list.keySet()) {
            assertEquals(1, list.get(skill), 3);
        }
    }

    @Test
    public void generateProjectLevel() {
        System.out.println("Test generate project level: easy level");
        assertEquals(1, level.generateProjectLevel(), 1);
    }

    @Test
    public void generateProjectPayment() {
        System.out.println("Test generate project payment: easy level");
        assertEquals(15 * 10000, level.generateProjectPayment(), 25 * 10000);
    }

    @Test
    public void generateProjectTime() {
        System.out.println("Test generate project time: easy level");
        DateTime time = level.generateProjectTime();
        assertEquals(0, time.getYear(), 0);
        assertEquals(2, time.getMonthOfYear(), 6);
    }
}
