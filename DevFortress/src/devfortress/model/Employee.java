/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model;

import devfortress.components.constant.Skills;
import java.util.Map;

/**
 *
 * @author cathoanghuy
 */
public class Employee {

    private String name;
    private float salary;
    private Map<Skills, Integer> skillList;

    public Employee(String name, float salary, Map skillList) {
        this.name = name;
        this.salary = salary;
        this.skillList = skillList;
    }

    public Employee(String name, Map skillList) {
        this.name = name;
        this.skillList = skillList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Map getSkillList() {
        return skillList;
    }

    public void setSkillList(Map skillList) {
        this.skillList = skillList;
    }

    public void skillLevelUp(Skills sk) {
        if (skillList.containsKey(sk)) {
            int val = ((Integer) skillList.get(sk)).intValue();
            skillList.put(sk, val++);
        } else {
            skillList.put(sk, 1);
        }
    }

    public Skills getMainSkill() {
        Skills main = null;
        int highest = 0;
        for (Skills object : skillList.keySet()) {
            if (skillList.get(object) > highest) {
                main = object;
                highest = skillList.get(object);
            }
        }
        return main;
    }
}
