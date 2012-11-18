/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model;

import devfortress.utilities.Skills;
import java.util.HashMap;
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
    private boolean status[];

    public Employee(String name, Map skillList) {
        this.name = name;
        this.skillList = skillList;
        status = new boolean[3];
        //0 is having beer, 1 is full, 2 is happy;
        status[0] = false;
        status[1] = false;
        status[2] = true;
        mainSkill = getMainSkill();
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
        for (Skills sk : skillList.keySet()) {
            if (skillList.get(sk) >= highest) {
                if (skillList.get(sk) == highest) {
                    main = (sk.toString().compareToIgnoreCase(main.toString()) < 0) ? sk : main;
                } else {
                    main = sk;
                }
                highest = skillList.get(sk);
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
        if (lowest == 1) {
            return lowest;
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

    public int getLowestSkillLvl() {
        Map<Skills, Integer> specialSkill = new HashMap<>();
        if (skillList.containsKey(Skills.HASKELL)) {
            specialSkill.put(Skills.HASKELL, skillList.get(Skills.HASKELL));
        }
        if (skillList.containsKey(Skills.FORTH)) {
            specialSkill.put(Skills.FORTH, skillList.get(Skills.FORTH));
        }
        if (skillList.containsKey(Skills.LISP)) {
            specialSkill.put(Skills.LISP, skillList.get(Skills.LISP));
        }
        if (specialSkill.isEmpty()) {
            return getLowestLevel();
        } else {
            int level = 0;
            for (Skills skill : specialSkill.keySet()) {
                if (specialSkill.get(skill) >= level) {
                    level = specialSkill.get(skill);
                }
            }
            return level;
        }
    }

    private float calculateSalary() {
        //TODO calculate salary for employee
        return 1;
    }
}
