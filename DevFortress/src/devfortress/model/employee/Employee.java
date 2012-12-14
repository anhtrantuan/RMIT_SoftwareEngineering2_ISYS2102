/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model.employee;

import devfortress.model.project.Project;
import devfortress.utilities.Skill;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author cathoanghuy
 */
public class Employee {

    private String name;
    private Map<Skill, Integer> skillList;
    private boolean status[];
    private Project workingProject;
    private boolean isRoyal;
    private int royalCountdown;
    private boolean isTalented;

    public Employee(String name, Map<Skill, Integer> skillList) {
        this.name = name;
        this.skillList = skillList;
        status = new boolean[4];
        workingProject = null;
        //0 is having beer, 1 is full, 2 is happy, 3 is working;
        status[0] = false;
        status[1] = true;
        status[2] = true;
        status[3] = false;
        isRoyal = false;
        royalCountdown = 36;
        isTalented = false;
    }

    public Employee() {
        status = new boolean[4];
        workingProject = null;
        //0 is having beer, 1 is full, 2 is happy, 3 is working;
        status[0] = false;
        status[1] = true;
        status[2] = true;
        status[3] = false;
        isRoyal = false;
        royalCountdown = 36;
        isTalented = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSalary() {
        return calculateSalary();
    }

    public Map<Skill, Integer> getSkillList() {
        return skillList;
    }

    public void setSkillList(Map<Skill, Integer> skillList) {
        this.skillList = skillList;
    }

    public void skillLevelUp(Skill sk) {
        if (isTalented) {
            if (skillList.containsKey(sk)) {
                int val = ((Integer) skillList.get(sk)).intValue();
                val = val + 3;
                skillList.put(sk, val);
            } else {
                skillList.put(sk, 3);
            }
            isTalented = false;
        } else {
            if (skillList.containsKey(sk)) {
                int val = ((Integer) skillList.get(sk)).intValue();
                skillList.put(sk, ++val);
            } else {
                skillList.put(sk, 1);
            }
        }
        getMainSkill();
    }

    public Skill getMainSkill() {
        Skill main = null;
        int highest = 0;
        for (Iterator<Skill> iterator = skillList.keySet().iterator();
                iterator.hasNext();) {
            Skill skill = iterator.next();
            if (skillList.get(skill) >= highest) {
                if (skillList.get(skill) != highest
                        || (skill.toString().compareToIgnoreCase(main.toString()) < 0)) {
                    main = skill;
                }
                highest = skillList.get(skill);
            }
        }

        return main;
    }

    public int getSkillLevel(Skill field) {
        if (skillList.containsKey(field)) {
            return skillList.get(field);
        } else {
            return getLowestLevel();
        }
    }

    private int getLowestLevel() {
        int lowest = 10;
        for (Skill object : skillList.keySet()) {
            if (skillList.get(object) <= lowest) {
                lowest = skillList.get(object);
            }
        }
        if (lowest == 1) {
            return lowest;
        }
        return lowest / 2;
    }

    public int getDesignSkill() {
        if (skillList.containsKey(Skill.DESIGN)) {
            return skillList.get(Skill.DESIGN);
        } else {
            return 0;
        }
    }

    public int getAlgorithmSkill() {
        if (skillList.containsKey(Skill.ALGORITHMS)) {
            return skillList.get(Skill.ALGORITHMS);
        }
        return 0;
    }

    public int getTeamPlayerSkill() {
        if (skillList.containsKey(Skill.TEAM_PLAYER)) {
            return skillList.get(Skill.TEAM_PLAYER);
        }
        return 0;
    }

    public int getConfigurationSkill() {
        if (skillList.containsKey(Skill.CONFIG_MANAGEMENT)) {
            return skillList.get(Skill.CONFIG_MANAGEMENT);
        }
        return 0;
    }

    public boolean[] getStatus() {
        return status;
    }

    public void haveBeer() {
        status[0] = true;
        status[2] = true;
    }

    public void soberUp() {
        status[0] = false;
    }

    public void eat() {
        status[1] = true;
    }

    public void getHungry() {
        status[1] = false;
    }

    public void getSad() {
        status[2] = false;
    }

    public void getHappy() {
        status[2] = true;
    }

    public void assignToWork() {
        status[3] = true;
    }

    public void getOutOfWork() {
        workingProject = null;
        status[3] = false;
    }

    public int getLowestSkillLevel() {
        Map<Skill, Integer> specialSkill = new EnumMap<Skill, Integer>(Skill.class);
        if (skillList.containsKey(Skill.HASKELL)) {
            specialSkill.put(Skill.HASKELL, skillList.get(Skill.HASKELL));
        }
        if (skillList.containsKey(Skill.FORTH)) {
            specialSkill.put(Skill.FORTH, skillList.get(Skill.FORTH));
        }
        if (skillList.containsKey(Skill.LISP)) {
            specialSkill.put(Skill.LISP, skillList.get(Skill.LISP));
        }
        if (specialSkill.isEmpty()) {
            return getLowestLevel();
        } else {
            int level = 0;
            for (Skill skill : specialSkill.keySet()) {
                if (specialSkill.get(skill) >= level) {
                    level = specialSkill.get(skill);
                }
            }
            return level;
        }
    }

    public float calculateSalary() {
        int salary = 0;
        for (Skill sk : skillList.keySet()) {
            if (sk.ordinal() <= 24) {
                salary += calculateSalaryPoint(sk, skillList.get(sk)) * 2;
            } else if (sk.ordinal() >= 25 && sk.ordinal() <= 27) {
                salary += calculateSalaryPoint(sk, skillList.get(sk)) * 4;
            } else {
                salary += calculateSalaryPoint(sk, skillList.get(sk)) * 5;
            }
        }
        return salary * 10;
    }

    private int calculateSalaryPoint(Skill skill, int skillLevel) {

        if (skill.ordinal() <= 24) {
            if (skillLevel == 1) {
                if (skill.ordinal() == 24) {
                    return 5;
                } else {
                    return 1;
                }
            } else {
                return (calculateSalaryPoint(skill, skillLevel - 1) + 2);
            }
        } else if (skill.ordinal() >= 25 && skill.ordinal() <= 27) {
            if (skillLevel == 1) {
                return 2;
            } else {
                return (calculateSalaryPoint(skill, skillLevel - 1) + 4);
            }
        } else {
            if (skillLevel == 1) {
                if (skill.ordinal() == 29) {
                    return 3;
                } else {
                    return 2;
                }
            } else {
                return (calculateSalaryPoint(skill, skillLevel - 1) * 2);
            }
        }
    }

    /**
     * Check if 2 employees have the same name.
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if ((obj instanceof Employee) && (((Employee) obj).getName().equals(name))) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }

    public Project getWorkingProject() {
        return workingProject;
    }

    public void assignToProject(Project project) {
        workingProject = project;
    }

    public void checkRoyal() {
        if (royalCountdown == 0) {
            isRoyal = true;
        } else {
            royalCountdown--;
        }
    }
    
    public void talentFound(){
        isTalented = true;
    }
    
    public boolean getIsTalent(){
        return isTalented;
    }
    
    public void becomeRoyal(){
        isRoyal = true;
    }
    
    public boolean getIsRoyal(){
        return isRoyal;
    }
}
