
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model.event;

import devfortress.model.Company;
import devfortress.model.employee.Employee;
import devfortress.model.exception.EmployeeNotExist;
import devfortress.model.project.Project;
import devfortress.utilities.Event;
import devfortress.utilities.Skill;
import java.util.Map;

/**
 *
 * @author satthuvdh
 */
public class IndividualEvent implements EventInterface {

    public static Event sickDeveloper(Employee e) {
        e.sick();
        return Event.DEVELOPER_IS_SICK;
    }

    public static Event newTechnology(Employee e) {
        Project p = e.getWorkingProject();
        if (p != null) {
            Map<Skill, Employee> skill = e.getWorkingProject().getSkill_employeeMap();
            Map<Skill, Integer> require = e.getWorkingProject().getSkillRequirementMap();
            for (Skill sk : skill.keySet()) {
                if (skill.get(sk).equals(e)) {
                    require.put(sk, require.get(sk) - 50);
                    e.getWorkingProject().decreaseRemainingPoint(50);
                }
            }
            return Event.NEW_TECHNOLOGY;
        }
        return Event.NO_EVENT;
    }

    public static Event hacked(Employee e) {
        e.getHacked();
        return Event.HACKED;
    }

    public static Event featureCut(Employee e) {
        Project p = e.getWorkingProject();
        if (p != null) {
            Map<Skill, Employee> skill = e.getWorkingProject().getSkill_employeeMap();
            Map<Skill, Integer> require = e.getWorkingProject().getSkillRequirementMap();
            for (Skill sk : skill.keySet()) {
                if (skill.get(sk).equals(e)) {
                    int remainPoint = require.get(sk);
                    require.put(sk, 0);
                    e.getWorkingProject().decreaseRemainingPoint(remainPoint);
                }
            }
            return Event.FEATURE_CUT;

        }
        return Event.NO_EVENT;
    }

    public static Event holiday(Employee e) {
        e.goHoliday();
        return Event.HOLIDAY;
    }

    public static Event redundancies(Employee e) {
        Project p = e.getWorkingProject();
        if (p != null) {
            Map<Skill, Employee> skill = e.getWorkingProject().getSkill_employeeMap();
            for (Skill sk : skill.keySet()) {
                if (skill.get(sk).equals(e)) {
                    skill.put(sk, null);
                } else if (skill.get(sk) != null) {
                    skill.get(sk).sad();
                }
            }
            e.getOutOfWork();
            return Event.REDUNDANCIES;
        }
        return Event.NO_EVENT;
    }

    public static Event bonus(Employee e, Company c) {
        c.increaseMoney(5000);
        return Event.BONUS;
    }

    public static Event exploreTalent(Employee e) {
        e.getTalented();
        return Event.EXPLORE_THE_EMPLOYEE_HAVING_TALENT;
    }

    public static Event projectStolen(Employee e, Company c) {
        try {
            Project p = e.getWorkingProject();
            if (p != null) {
                c.cancelProject(p);
                c.removeEmployee(e);
                return Event.PROJECT_IS_STOLEN_BY_EMPLOYEE;
            } else {
                return Event.NO_EVENT;
            }
        } catch (EmployeeNotExist ex) {
        } finally {
            return Event.NO_EVENT;
        }

    }

    public static Event developerHasBaby(Employee e) {
        e.hasBaby();
        return Event.DEVELOPER_HAS_BABY;
    }
}
