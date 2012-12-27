/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model.event;

import devfortress.model.employee.Employee;
import devfortress.model.exception.EmployeeIsBusyException;
import devfortress.model.exception.EmployeeNotExist;
import devfortress.model.facade.Engine;
import devfortress.model.facade.Model;
import devfortress.model.project.Project;
import devfortress.utilities.Skill;
import java.util.EnumMap;
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

    private static IndividualEvent event;
    private static Model model;
    private static Employee e1;
    private static Employee e2;
    private static Project p;
    private static Skill[] sks;

    public IndividualEventTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws EmployeeNotExist, EmployeeIsBusyException {
        event = new IndividualEvent();
        model = new Engine();
        p = model.getAvailableProjectList().get(0);
        sks = p.getSkillRequirementMap().keySet().toArray(new Skill[p.getSkillRequirementMap().size()]);
        e1 = new Employee("employee1", new EnumMap<Skill, Integer>(Skill.class));
        e2 = new Employee("employee2", new EnumMap<Skill, Integer>(Skill.class));
        model.assignEmployeeToProject(e1, p, sks[0]);
        model.assignEmployeeToProject(e2, p, sks[1]);
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
    public void developerSick() {
        System.out.println("test developer is sick event");
        event.sickDeveloper(e1);
        assertTrue(e1.isSick());
    }

    @Test
    public void newTech() {
        System.out.println("Test new technology invent event");
        int re = p.getRemainingPoints();
        event.newTechnology(e1);
        assertEquals(re - 50, p.getRemainingPoints());
    }

    @Test
    public void hacked() {
        System.out.println("Test hack event");
        event.hacked(e1);
        assertTrue(e1.isHack());
    }

    @Test
    public void holiday() {
        System.out.println("Test holiday event");
    }

    @Test
    public void redundancies() {
        System.out.println("Test redundancies event");
    }

    @Test
    public void bonus() {
        System.out.println("Test bonus");
    }
}
