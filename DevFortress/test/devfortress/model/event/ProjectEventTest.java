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

/**
 *
 * @author Cat Hoang Huy
 */
public class ProjectEventTest {

    private static ProjectEvent event;
    private static Model model;
    private static Employee e1;
    private static Employee e2;
    private static Project p;
    private static Skill[] sks;

    public ProjectEventTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        //p.assignEmployeeToProject(e2, p.getMainSkill());
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws EmployeeNotExist, EmployeeIsBusyException {
        event = new ProjectEvent();
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
    public void teamBuilding() {
        System.out.println("Test team building event");
        event.teamBuilding(e1);
        assertTrue(e1.getStatus()[7] == true);
    }

    @Test
    public void gotSued() {
        System.out.println("Test got sued by another company event");
        float money = model.getBudget();
        event.gotSued(e1, model.getCompany());
        assertEquals(money - (money / 4), model.getBudget(), 0);
    }

    @Test
    public void killDeveloper() {
        System.out.println("Test kill developer event");
//        int numEm = model.getEmployeeList().size();
        event.killDeveloper(e1, model.getCompany());
        assertEquals(0, model.getEmployeeList().size());
    }

    @Test
    public void warErrupt() throws EmployeeNotExist {
        System.out.println("Test war errupt event");
        int numEm = model.getEmployeeList().size();
        event.warErrupt(e1, model.getCompany());
        assertEquals(numEm * 2 / 3, model.getEmployeeList().size());
    }

    @Test
    public void companyBurnt() throws EmployeeNotExist {
        System.out.println("Test company burnt down");
        float money = model.getBudget();
        event.companyBurnt(e1, model.getCompany());
        assertTrue(model.getEmployeeList().size() == 0);
    }

    @Test
    public void zombie() {
        System.out.println("Test zombie event");
        event.zombie(e1, model.getCompany());
        assertTrue(model.getBudget() == 0);
    }
}
