/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model;

import devfortress.utilities.Skills;
import java.util.Map;

/**
 *
 * @author cathoanghuy
 */
public class Employee {

    private String name;
    private float salary;
    private Map<Skills, Integer> skillList;
    private Skills mainSkill;

    public Employee(String name, float salary, Map skillList) {
        this.name = name;
        this.salary = salary;
        this.skillList = skillList;
        getMainSkill();
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
            skillList.put(sk, ++val);
        } else {
            skillList.put(sk, 1);
        }
        getMainSkill();
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
        mainSkill = main;
        return main;
    }

    public int getSkillLevel(Skills field) {
        if (skillList.containsKey(field)) {
            return skillList.get(field);
        } else {
            return getLowestLevel();
        }
    }

    private int getLowestLevel() {
        int lowest = 10;
        for (Skills object : skillList.keySet()) {
            if (skillList.get(object) <= lowest) {
                lowest = skillList.get(object);
            }
        }
        return lowest / 2;
    }

    public int getDesignSkill() {
        if (skillList.containsKey(Skills.DESIGN)) {
            return skillList.get(Skills.DESIGN);
        } else {
            return 0;
        }
    }

    public int getAlgorithmSkill() {
        if (skillList.containsKey(Skills.ALGORITHMS)) {
            return skillList.get(Skills.ALGORITHMS);
        }
        return 0;
    }

    public int getTeamPlayerSkill() {
        if (skillList.containsKey(Skills.TEAM_PLAYER)) {
            return skillList.get(Skills.TEAM_PLAYER);
        }
        return 0;
    }

    public int getConfigurationSkill() {
        if (skillList.containsKey(Skills.CONFIG_MANAGEMENT)) {
            return skillList.get(Skills.CONFIG_MANAGEMENT);
        }
        return 0;
    }
}
