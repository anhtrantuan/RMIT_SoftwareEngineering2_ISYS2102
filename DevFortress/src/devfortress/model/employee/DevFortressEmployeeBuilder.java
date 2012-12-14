/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model.employee;

import devfortress.utilities.Skill;
import java.util.Map;

/**
 *
 * @author Sherlock
 */
public class DevFortressEmployeeBuilder extends EmployeeBuilder{

    @Override
    public void addName(String name) {
        employee.setName(name);
    }

    @Override
    public void addSkillList(Map <Skill, Integer>skills) {
        employee.setSkillList(skills);
    }
    
}
