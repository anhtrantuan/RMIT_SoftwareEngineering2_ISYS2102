/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model;

import devfortress.model.exception.ProjectFailsException;
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
    private String name;
    private int totalFunctionPointDelivered;

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

    public int getTotalFunctionPointDelivered() {
        return totalFunctionPointDelivered;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    private int calculateBasicFunctionPoint(Employee employee) {
        int level;
        if (employee.getMainSkill() == mainSkill) {
            level = employee.getSkillLevel(employee.getMainSkill());
        } else {
            level = employee.getLowestSkillLvl();
        }
        return (level + (2 * employee.getDesignSkill()) + (level * employee.getAlgorithmSkill()) + (employee.getTeamPlayerSkill() * skill_employeeMap.size())) / ((10 - employee.getConfigurationSkill()) + 2);


    }

    private int calculateFinalFunctionPoint(int basicPoint, Employee employee) {
        boolean status[] = employee.getStatus();
        int finalPoint = basicPoint;
        if (status[0] == true) {
            finalPoint = finalPoint / 2;
        }
        if (status[1] == false) {
            finalPoint = 1;
        }
        return finalPoint;
    }

    public boolean checkProjectProcess() throws ProjectFailsException {
        int finish = 0;
        totalFunctionPointDelivered = 0;
        for (Skills sk : skill_employeeMap.keySet()) {
            Employee emp = skill_employeeMap.get(sk);
            int functionPointProduced = calculateFinalFunctionPoint(calculateBasicFunctionPoint(emp), emp);
            totalFunctionPointDelivered += functionPointProduced;
            int functionPointRequire = skillRequirementMap.get(emp);
            if (functionPointRequire <= functionPointProduced) {
                skillRequirementMap.put(sk, 0);
                finish++;
            } else {
                skillRequirementMap.put(sk, functionPointRequire - functionPointProduced);
            }
        }
        if (skillRequirementMap.size() == finish && projectTime != 0) {
            return true;
        } else {
            projectTime--;
            if (projectTime == 0) {
                throw new ProjectFailsException("Project Fails");
            }
        }
        return false;
    }
}
