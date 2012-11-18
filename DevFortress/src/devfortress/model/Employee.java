/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model;

import devfortress.utilities.Skill;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author cathoanghuy
 */
public class Employee {

    private String name;
    private float salary;
    private Map<Skill, Integer> skillList;
    private boolean status[];

    public Employee(String name, float salary, Map<Skill, Integer> skillList) {
        this(name, skillList);
        this.salary = salary;
        status = new boolean[3];
        //0 is having beer, 1 is full, 2 is happy;
        status[0] = false;
        status[1] = false;
        status[2] = true;
    }

    public Employee(String name, Map<Skill, Integer> skillList) {
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

    public Map<Skill, Integer> getSkillList() {
        return skillList;
    }

    public void setSkillList(Map<Skill, Integer> skillList) {
        this.skillList = skillList;
    }

    public void skillLevelUp(Skill sk) {
        if (skillList.containsKey(sk)) {
            int val = ((Integer) skillList.get(sk)).intValue();
            skillList.put(sk, ++val);
        } else {
            skillList.put(sk, 1);
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

    public int getLowestSkillLevel() {
        Map<Skill, Integer> specialSkill = new HashMap<>();
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
}
