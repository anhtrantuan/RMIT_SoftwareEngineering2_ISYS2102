/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model.difficulty;

import devfortress.model.DateTime;
import devfortress.model.dificulity.DifficultLevel;
import devfortress.model.dificulity.GameLevel;
import devfortress.utilities.Skill;
import java.lang.Integer;
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
public class DifficultTest {

    private static GameLevel level;

    public DifficultTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        level = new DifficultLevel();
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
        System.out.println("Test generate skill list: difficult level");
        Map<Skill, Integer> list = level.generateSkillList();
        assertEquals(10, list.size(), 3);
        for (Skill skill : list.keySet()) {
            assertEquals(6, list.get(skill), 4);
        }
    }

    @Test
    public void generateProjectLevel() {
        System.out.println("Test generate project level: difficult level");
        assertEquals(4, level.generateProjectLevel(), 2);
    }

    @Test
    public void generateProjectPayment() {
        System.out.println("Test generate project payment: difficult level");
        assertEquals(300 * 10000, level.generateProjectPayment(), 200 * 10000);
    }

    @Test
    public void generateProjectTime() {
        System.out.println("Test generate project time: difficult level");
        DateTime time = level.generateProjectTime();
        assertEquals(1, time.getYear(), 1);
        assertEquals(0, time.getMonthOfYear(), 12);
    }
}
