/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model.project;

import devfortress.model.DateTime;
import devfortress.model.employee.Employee;
import devfortress.model.exception.ProjectFailsException;
import devfortress.utilities.Skill;
import java.util.EnumMap;
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
    private Map<Skill, Integer> skillRequirementMap;
    private Map<Skill, Employee> skill_employeeMap;
    private Map<Skill, Integer> originalSkillRequirementMap;
    private Skill mainSkill;
    private String name;
    private int totalPoints, remainingPoints, totalFunctionPointsDelivered;

    public Project(String name, int totalPoints, float payment, int projectLevel,
            DateTime projectTime, Map<Skill, Integer> skillRequirementMap) {
        this.name = name;
        this.totalPoints = totalPoints;
        remainingPoints = totalPoints;
        this.payment = payment;
        this.projectLevel = projectLevel;
        this.projectTime = projectTime;
        remainingTime = projectTime;
        this.skillRequirementMap = skillRequirementMap;
        originalSkillRequirementMap = skillRequirementMap;
        skill_employeeMap = new EnumMap<Skill, Employee>(Skill.class);
        calculateMainSkill();
    }

    public Project() {
        skill_employeeMap = new EnumMap<Skill, Employee>(Skill.class);
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

    public Map<Skill, Integer> getSkillRequirementMap() {
        return skillRequirementMap;
    }

    public void setSkillRequirementMap(Map<Skill, Integer> skillRequirementMap) {
        this.skillRequirementMap = skillRequirementMap;
    }

    public Map<Skill, Employee> getSkill_employeeMap() {
        return skill_employeeMap;
    }

    public void setSkill_employeeMap(Map<Skill, Employee> skill_employeeMap) {
        this.skill_employeeMap = skill_employeeMap;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setOriginalSkillRequirementMap(Map<Skill, Integer> originalSkillRequirementMap) {
        this.originalSkillRequirementMap = originalSkillRequirementMap;
    }

    public void setRemainingTime(DateTime remainingTime) {
        this.remainingTime = remainingTime;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public int getRemainingPoints() {
        return remainingPoints;
    }

    public void setMainSkill(Skill mainSkill) {
        this.mainSkill = mainSkill;
    }

    public void setRemainingPoints(int remainingPoints) {
        this.remainingPoints = remainingPoints;
    }

    public void setTotalFunctionPointsDelivered(int totalFunctionPointsDelivered) {
        this.totalFunctionPointsDelivered = totalFunctionPointsDelivered;
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
        for (Skill sk : skill_employeeMap.keySet()) {
            selectedEmployee = skill_employeeMap.get(sk);
            for (int i = 0; i < projectTime.getMonths(); i++) {
                if (random.nextInt(99) < lvlUpPercent) {
                    selectedEmployee.skillLevelUp(mainSkill);
                }
            }
        }
    }

    public Skill calculateMainSkill() {
        Skill main = null;
        int highest = 0;
        for (Skill sk : skillRequirementMap.keySet()) {
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
            level = employee.getLowestSkillLevel();
        }
        return (level + (2 * employee.getDesignSkill()) + (level * employee.getAlgorithmSkill()) + (employee.getTeamPlayerSkill() * skill_employeeMap.size()) / ((10 - employee.getConfigurationSkill()) + 2));
    }

    private int calculateFinalFunctionPoint(int basicPoint, Employee employee) {
        boolean status[] = employee.getStatus();
        int finalPoint = basicPoint;
        if (status[0] == true) {
            finalPoint = finalPoint / 2;
        }
        //TODO sprint 2
        //0 is having beer, 1 is full, 2 is happy, 3 is working,
        //4 is sick, 5 is hacked, 6 is in holiday, 7 team buidling;
        //8 is inspired, 9 is having baby, 10 is talented
        if (status[1] == false || status[6] == true) {
            finalPoint = 1;
        }
        if (status[4] == true) {
            finalPoint = finalPoint / 2;
        }
        if (status[5] == true) {
            finalPoint = 0;
        }
        if (status[7] == true) {
            finalPoint = 5;
        }
        if (status[8] == true || status[9] == true) {
            finalPoint = finalPoint * 2;
        }

        return finalPoint;
    }

    public boolean checkProjectProcess() {
        int finish = 0;
        //totalFunctionPointsDelivered = 0;
        for (Skill sk : skill_employeeMap.keySet()) {
            Employee emp = skill_employeeMap.get(sk);
            int functionPointProduced = calculateFinalFunctionPoint(calculateBasicFunctionPoint(emp), emp);
            remainingPoints -= functionPointProduced;
            totalFunctionPointsDelivered += functionPointProduced;
            int functionPointRequire = skillRequirementMap.get(sk);
            if (functionPointRequire <= functionPointProduced) {
                skillRequirementMap.put(sk, 0);
                finish++;
            } else {
                skillRequirementMap.put(sk, functionPointRequire - functionPointProduced);
            }
        }
        if (skillRequirementMap.size() == finish && remainingTime.getMonths() != 0) {
            return true;
        }
        return false;
    }

    public Skill getMainSkill() {
        return mainSkill;
    }

    public Map<Skill, Integer> getOriginalSkillRequirementMap() {
        return originalSkillRequirementMap;
    }

    /**
     * Check if 2 projects have the same.
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if ((obj instanceof Project) && ((Project) obj).getName().equals(name)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Float.floatToIntBits(this.payment);
        hash = 79 * hash + this.projectLevel;
        hash = 79 * hash + (this.projectTime != null ? this.projectTime.hashCode() : 0);
        hash = 79 * hash + (this.originalSkillRequirementMap != null ? this.originalSkillRequirementMap.hashCode() : 0);
        hash = 79 * hash + (this.mainSkill != null ? this.mainSkill.hashCode() : 0);
        hash = 79 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 79 * hash + this.totalPoints;
        return hash;
    }

    /**
     * assign an employee to specific field
     *
     * @param emp
     * @param field
     */
    public boolean assignEmployeeToProject(Employee emp, Skill field) {
        if (emp.getWorkingProject() == null) {
            if (emp.getMainSkill() == mainSkill) {
                emp.getHappy();
            } else {
                emp.getSad();
            }
            skill_employeeMap.put(field, emp);
            emp.assignToProject(this);
            return true;
        }

        return false;
    }

    public void unassignEmployee(Employee emp) {
        for (Skill sk : skill_employeeMap.keySet()) {
            if (skill_employeeMap.get(sk) == emp) {
                skill_employeeMap.put(sk, null);
                emp.getOutOfWork();
            }
        }
    }

    public void unassignEmployees() {
        for (Employee employee : skill_employeeMap.values()) {
            employee.getOutOfWork();
        }
    }
}
