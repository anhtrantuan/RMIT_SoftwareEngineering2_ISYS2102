/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model.employee;

import devfortress.utilities.Skill;
import java.util.ArrayList;
import java.util.EnumMap;
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

    private static Map<Skill, Integer> list;
    private static Employee e;

    public EmployeeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        e = new Employee("employee1", new EnumMap<Skill, Integer>(Skill.class));

        list = new EnumMap<Skill, Integer>(Skill.class);
        list.put(Skill.C, 1);
        list.put(Skill.COMMUNICATION, 2);
        list.put(Skill.C_SHARP, 3);
        list.put(Skill.C_PLUSS_PLUSS, 4);
        list.put(Skill.DESIGN, 2);
        list.put(Skill.ALGORITHMS, 2);
        list.put(Skill.TEAM_PLAYER, 2);
        list.put(Skill.CONFIG_MANAGEMENT, 2);
        e.setSkillList(list);
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
        assertEquals(2, e.getSkillList().get(Skill.C).intValue());
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

    @Test
    public void getDesignSkill() {
        System.out.println("Test get design skill: employee has");
        assertEquals(2, e.getDesignSkill());
        
    }

    @Test
    public void getDesignSkill2() {
        System.out.println("Test get design skill: employee does not have");
        Employee e = new Employee("em", new HashMap<Skill, Integer>());
        assertEquals(0, e.getDesignSkill());
    }

    @Test
    public void getAlgorithm() {
        System.out.println("Test get algorithm skill: employee has");
        assertEquals(2, e.getAlgorithmSkill());
    }

    @Test
    public void getAlgorithm2() {
        System.out.println("Test get algorithm skill: employee does not have");
        Employee e = new Employee("em", new HashMap<Skill, Integer>());
        assertEquals(0, e.getAlgorithmSkill());
    }

    @Test
    public void getTeamPlayer() {
        System.out.println("Test get team skill: employee has");
        assertEquals(2, e.getTeamPlayerSkill());
    }

    @Test
    public void getTeamPlayer2() {
        System.out.println("Test get team skill: employee does not have");
        Employee e = new Employee("em", new HashMap<Skill, Integer>());
        assertEquals(0, e.getAlgorithmSkill());
    }

    @Test
    public void getConfigurationSkill() {
        System.out.println("Test get configuration Skill: employee has");
        assertEquals(2, e.getTeamPlayerSkill());
    }

    @Test
    public void getConfigurationSkill2() {
        System.out.println("Test get configuration Skill: employee does not have");
        Employee e = new Employee("em", new HashMap<Skill, Integer>());
        assertEquals(0, e.getConfigurationSkill());
    }
}
