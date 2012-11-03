/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model;

import devfortress.utilities.Skills;
import java.util.Map;
import java.util.SortedMap;

/**
 *
 * @author cathoanghuy
 */
public class Project {
    //how much monmey can earn from this project

    private int payment;
    private int projectLevel;
    //how long a project lasts
    private int projectTime;
    private Map<Skills, Integer> skillRequirementMap;
    private Map<Skills, Employee> skill_employeeMap;

    public Project(int payment, int projectLevel, int projectTime, Map<Skills, Integer> skillRequirementMap) {
        this.payment = payment;
        this.projectLevel = projectLevel;
        this.projectTime = projectTime;
        this.skillRequirementMap = skillRequirementMap;
        
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public int getProjectLevel() {
        return projectLevel;
    }

    public void setProjectLevel(int projectLevel) {
        this.projectLevel = projectLevel;
    }

    public int getProjectTime() {
        return projectTime;
    }

    public void setProjectTime(int projectTime) {
        this.projectTime = projectTime;
    }

    public Map<Skills, Integer> getSkillRequirementMap() {
        return skillRequirementMap;
    }

    public void setSkillRequirementMap(Map<Skills, Integer> skillRequirementMap) {
        this.skillRequirementMap = skillRequirementMap;
    }

    public Map<Skills, Employee> getSkill_employeeMap() {
        return skill_employeeMap;
    }

    public void setSkill_employeeMap(Map<Skills, Employee> skill_employeeMap) {
        this.skill_employeeMap = skill_employeeMap;
    }
    
    

    @Override
    public String toString() {
        for (Skills object : skillRequirementMap.keySet()) {
            System.out.println(object.name() + ":" + skillRequirementMap.get(object));
        }
        return this.payment + "\n"
                + this.projectLevel + "\n"
                + this.projectTime + "\n";
    }
}
