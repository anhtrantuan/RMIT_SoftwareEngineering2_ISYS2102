/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model;

import devfortress.utilities.Skills;
import java.util.Map;
import java.util.Random;
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
    private Skills mainSkill;

    public Project(int payment, int projectLevel, int projectTime, Map<Skills, Integer> skillRequirementMap) {
        this.payment = payment;
        this.projectLevel = projectLevel;
        this.projectTime = projectTime;
        this.skillRequirementMap = skillRequirementMap;
        getMainSkill();
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

    public void levelUp() {
        Random random = new Random();
        int lvlUpPercent = (projectLevel * 5) - 1;
        Employee selectedEmployee;
        for (Skills sk : skill_employeeMap.keySet()) {
            selectedEmployee = skill_employeeMap.get(sk);
            for (int i = 0; i < projectTime; i++) {
                if (random.nextInt(99) < lvlUpPercent) {
                    selectedEmployee.skillLevelUp(mainSkill);
                }
            }
        }
    }

    private Skills getMainSkill() {
        Skills main = null;
        int highest = 0;
        for (Skills sk : skillRequirementMap.keySet()) {
            if (skillRequirementMap.get(sk) >= highest) {
                if (skillRequirementMap.get(sk) == highest) {
                    main = (sk.toString().compareToIgnoreCase(main.toString()) < 0) ? sk : main;
                } else {
                    main = sk;
                }
                highest = skillRequirementMap.get(sk);
            }
        }
        mainSkill = main;
        return main;
    }

    private int calculateBasicFunctionPoint(int level, int designLevel, int algorithmsLevel, int teamPlayer, int configurationLevel) {
        return (level + (2 * designLevel) + (level * algorithmsLevel) + (teamPlayer * skill_employeeMap.size())) / ((10 - configurationLevel) + 2);
    }
}
