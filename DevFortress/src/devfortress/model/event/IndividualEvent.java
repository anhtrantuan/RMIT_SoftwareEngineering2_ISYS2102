
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model.event;

import devfortress.model.employee.Employee;
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

    public static Event requirementChange(Employee e) {
        Project p = e.getWorkingProject();
        if (p != null) {
            Map<Skill, Employee> skill = e.getWorkingProject().getSkill_employeeMap();
            Map<Skill, Integer> require = e.getWorkingProject().getSkillRequirementMap();
            for (Skill sk : skill.keySet()) {
                if (skill.get(sk).equals(e)) {
                    require.put(sk, require.get(sk) + 20);
                    e.getWorkingProject().increaeRemainingPoint(20);
                }
            }
            return Event.REQUIREMENT_CHANGE;
        }
        return Event.NO_EVENT;
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

    public static Event solutionScale(Employee e) {
        Project p = e.getWorkingProject();
        if (p != null) {
            Map<Skill, Employee> skill = e.getWorkingProject().getSkill_employeeMap();
            Map<Skill, Integer> require = e.getWorkingProject().getSkillRequirementMap();
            for (Skill sk : skill.keySet()) {
                if (skill.get(sk).equals(e)) {
                    require.put(sk, require.get(sk) + 10);
                    e.getWorkingProject().increaeRemainingPoint(10);
                }
            }
            return Event.SOLUSTIONDOEST_NOT_SCALE;
        }
        return Event.NO_EVENT;
    }

    public static Event hacked(Employee e) {
        e.getHacked();
        return Event.HACKED;
    }

    public static Event featureCut(Employee e) {
        System.out.println("feature cut");
        return Event.FEATURE_CUT;
    }

    public static Event backupFailed(Employee e) {
        System.out.println("backup fail");
        return Event.BACKUP_FAIL;
    }

    public static Event holiday(Employee e) {
        System.out.println("holiday");
        return Event.HOLIDAY;
    }

    public static Event redundancies(Employee e) {
        System.out.println("redundancies");
        return Event.REDUNDANCIES;
    }

    public static Event bonus(Employee e) {
        System.out.println("bonus");
        return Event.BONUS;
    }

    public static Event exploreTalent(Employee e) {
        System.out.println("expore talent");
        return Event.EXPLORE_THE_EMPLOYEE_HAVING_TALENT;
    }

    public static Event getSponsor(Employee e) {

        return Event.GET_SPONSOR_FOR_CURRENT_PROJECT;
    }

    public static Event projectStolen(Employee e) {

        return Event.PROJECT_IS_STOLEN_BY_EMPLOYEE;
    }

    public static Event employeeLeave(Employee e) {

        return Event.EMPLOYEES_LEAVE_FOR_ANOTHER_COMPANY;
    }

    public static Event inspiration(Employee e) {

        return Event.INSPIRATION;
    }

    public static Event developerHasBaby(Employee e) {

        return Event.DEVELOPER_HAS_BABY;
    }

    public static Event accident(Employee e) {

        return Event.ACCIDENT_OCCURS_TO_EMPLOYEE;
    }
}
