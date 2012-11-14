/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model;

import devfortress.model.exception.ProjectFailsException;
import devfortress.utilities.Skills;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author cathoanghuy
 */
public class Project {

    //how much monmey can earn from this project
    private float payment;
    private int projectLevel;
    //how long a project lasts
    private DateTime projectTime;
    //remaining time for project
    private DateTime remainingTime;
    private Map<Skills, Integer> skillRequirementMap;
    private Map<Skills, Employee> skill_employeeMap;
    private Skills mainSkill;
    private String name;
    private int totalPoints, remainingPoints, totalFunctionPointsDelivered;

    public Project(int totalPoints, float payment, int projectLevel, DateTime projectTime, Map<Skills, Integer> skillRequirementMap) {
        this.totalPoints = totalPoints;
        remainingPoints = totalPoints;
        this.payment = payment;
        this.projectLevel = projectLevel;
        this.projectTime = projectTime;
        remainingTime = projectTime;
        this.skillRequirementMap = skillRequirementMap;
        getMainSkill();
    }

    public float getPayment() {
        return payment;
    }

    public void setPayment(float payment) {
        this.payment = payment;
    }

    public int getProjectLevel() {
        return projectLevel;
    }

    public void setProjectLevel(int projectLevel) {
        this.projectLevel = projectLevel;
    }

    public DateTime getProjectTime() {
        return projectTime;
    }

    public void setProjectTime(DateTime projectTime) {
        this.projectTime = projectTime;
    }

    public DateTime getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingtime(DateTime remainingtime) {
        this.remainingTime = remainingtime;
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

    public int getTotalPoints() {
        return totalPoints;
    }

    public int getRemainingPoints() {
        return remainingPoints;
    }

    public int getTotalFunctionPointsDelivered() {
        return totalFunctionPointsDelivered;
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
            for (int i = 0; i < projectTime.getMonths(); i++) {
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
        totalFunctionPointsDelivered = 0;
        for (Skills sk : skill_employeeMap.keySet()) {
            Employee emp = skill_employeeMap.get(sk);
            int functionPointProduced = calculateFinalFunctionPoint(calculateBasicFunctionPoint(emp), emp);
            remainingPoints -= functionPointProduced;
            totalFunctionPointsDelivered += functionPointProduced;
            int functionPointRequire = skillRequirementMap.get(emp);
            if (functionPointRequire <= functionPointProduced) {
                skillRequirementMap.put(sk, 0);
                finish++;
            } else {
                skillRequirementMap.put(sk, functionPointRequire - functionPointProduced);
            }
        }
        if (skillRequirementMap.size() == finish && remainingTime.getMonths() != 0) {
            return true;
        } else {
            remainingTime.nextTurn();
            if (remainingTime.getMonths() == 0) {
                throw new ProjectFailsException("Project Fails");
            }
        }
        return false;
    }
}
