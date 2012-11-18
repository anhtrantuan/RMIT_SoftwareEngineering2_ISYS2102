/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.utilities;

import devfortress.model.dificulity.GameLevel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sherlock
 */
public class UtilitiesTest {
    
    public UtilitiesTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of calculateSalaryOfSkill method, of class Utilities.
     * Calculate skill point with C Skill
     */
    @Test
    public void testCalculateSalaryPoint() {
        System.out.println("calculateSalaryPoint with C");
        Skill skill = Skill.C;
        int skillLevel = 5;
        int expResult = 9;
        int result = Utilities.calculateSalaryPoint(skill, skillLevel);
        assertEquals(expResult, result);
        
    }
    
        /**
     * Test of calculateSalaryOfSkill method, of class Utilities.
     * Calculate skill point with Lisp Skill
     */
    @Test
    public void testCalculateSalaryPoint1() {
        System.out.println("calculateSalaryPoint with Lisp");
        Skill skill = Skill.LISP;
        int skillLevel = 4;
        int expResult = 14;
        int result = Utilities.calculateSalaryPoint(skill, skillLevel);
        assertEquals(expResult, result);
        
    }
    
      /**
     * Test of calculateSalaryOfSkill method, of class Utilities.
     * Calculate skill point with Design Skill
     */
    @Test
    public void testCalculateSalaryPoint2() {
        System.out.println("calculateSalaryPoint with Design");
        Skill skill = Skill.DESIGN;
        int skillLevel = 8;
        int expResult = 256;
        int result = Utilities.calculateSalaryPoint(skill, skillLevel);
        assertEquals(expResult, result);
        
    }
    
     /**
     * Test of calculateSalaryOfSkill method, of class Utilities.
     * Calculate skill point with Algorithm Skill
     */
    @Test
    public void testCalculateSalaryPoint3() {
        System.out.println("calculateSalaryPoint with Algorithm");
        Skill skill = Skill.ALGORITHMS;
        int skillLevel = 6;
        int expResult = 96;
        int result = Utilities.calculateSalaryPoint(skill, skillLevel);
        assertEquals(expResult, result);
        
    }
    
         /**
     * Test of calculateSalaryOfSkill method, of class Utilities.
     * Calculate skill point with Config-Management Skill
     */
    @Test
    public void testCalculateSalaryPoint4() {
        System.out.println("calculateSalaryPoint with ConfigManagement");
        Skill skill = Skill.CONFIG_MANAGEMENT;
        int skillLevel = 5;
        int expResult = 13;
        int result = Utilities.calculateSalaryPoint(skill, skillLevel);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of generateProjectList method, of class Utilities.
     */
    @Test
    public void testGenerateProjectList() {
        System.out.println("generateProjectList");
        GameLevel level = null;
        int numberOfProject = 0;
        List expResult = null;
        List result = Utilities.generateProjectList(level, numberOfProject);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
        assertEquals(expResult, result);
        
    }

    /**
     * Test of genterateEmployeeList method, of class Utilities.
     */
    @Test
    public void testGenterateEmployeeList() {
        System.out.println("genterateEmployeeList");
        GameLevel level = null;
        int numberofEmployee = 0;
        List expResult = null;
        List result = Utilities.generateEmployeeList(level, numberofEmployee);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateSalary method, of class Utilities.
     */
    @Test
    public void testCalculateSalary() {
        System.out.println("calculateSalary");
        Map<Skill, Integer> skillList = new HashMap<Skill,Integer>();
        skillList.put(Skill.C, 5);
        skillList.put(Skill.LISP, 4);
        skillList.put(Skill.DESIGN, 8);
        skillList.put(Skill.ALGORITHMS, 6);
        skillList.put(Skill.CONFIG_MANAGEMENT, 5);
        int expResult = 1860;
        int result = Utilities.calculateSalary(skillList);
        assertEquals(expResult, result);
        
    }
}
