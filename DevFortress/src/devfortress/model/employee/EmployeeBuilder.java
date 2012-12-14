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
public abstract class EmployeeBuilder {

    protected Employee employee;
    
    public void createNewEmployee(){
        employee = new Employee();
    }

    public Employee getEmployee() {
        return employee;
    }
    
    public abstract void addName(String name);

    public abstract void addSkillList(Map<Skill, Integer> skills);
}
