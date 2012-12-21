/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model.employee;

import devfortress.utilities.Skill;
import java.util.ArrayList;
import java.util.HashMap;
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
public class EmployeeTest {

    private Map<Skill, Integer> list;
    private Employee e;

    public EmployeeTest() {
        e = new Employee();

        list = new HashMap<Skill, Integer>();
        list.put(Skill.C, 1);
        list.put(Skill.COMMUNICATION, 2);
        list.put(Skill.C_SHARP, 3);
        list.put(Skill.C_PLUSS_PLUSS, 4);

        e.setSkillList(list);
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

    @Test
    public void skillLevelUp() {
        System.out.println("Skill Level Up Test");
        e.skillLevelUp(Skill.C);
        assertEquals("Result", 2, e.getSkillList().get(Skill.C).intValue());
    }

    @Test
    public void getMainSkill() {
        System.out.println("Get Main Skill");

        assertEquals(Skill.C_PLUSS_PLUSS, e.getMainSkill());
    }

    @Test
    public void getMainSkill2() {
        System.out.println("Get Main Skill after level up skill");
        e.skillLevelUp(Skill.C_SHARP);
        e.skillLevelUp(Skill.C_SHARP);
        assertEquals(Skill.C_SHARP, e.getMainSkill());
    }
    
    @Test
    public void getMagetLowestSkillLevelinSkill() {
        System.out.println("Get Lowest Skill level");
        e.skillLevelUp(Skill.C);
        assertEquals(1, e.getLowestSkillLevel());
    }
    
    @Test
    public void getMagetLowestSkillLevelinSkill2() {
        System.out.println("Get Lowest Skill level with special skill");
        list.put(Skill.HASKELL, 3);
        assertEquals(3, e.getLowestSkillLevel());
    }
}
