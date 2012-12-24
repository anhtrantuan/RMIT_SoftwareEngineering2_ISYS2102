/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model.employee;

import devfortress.utilities.Skill;
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
public class EmployeeBuilderTest {

    private static DevFortressEmployeeBuilder builder;

    public EmployeeBuilderTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        builder = new DevFortressEmployeeBuilder();
        builder.createNewEmployee();
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
    public void addName() {
        System.out.println("Test employee builder: add name");
        builder.addName("employee1");
        assertEquals("employee1", builder.getEmployee().getName());
    }

    @Test
    public void addSkillList() {
        System.out.println("Test employee builder: add skill list");
        Map<Skill, Integer> skills = new HashMap<Skill, Integer>();
        builder.addSkillList(skills);
        assertEquals(skills, builder.getEmployee().getSkillList());
    }
}
