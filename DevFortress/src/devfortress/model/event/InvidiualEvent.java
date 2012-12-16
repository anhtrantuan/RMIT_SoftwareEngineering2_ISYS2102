
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model.event;

import devfortress.model.employee.Employee;
import devfortress.utilities.Event;

/**
 *
 * @author satthuvdh
 */
public class InvidiualEvent implements EventInterface {

    public static Event sickDeveloper(Employee e) {

        return Event.DEVELOPER_IS_SICK;
    }

    public static Event requirementChange(Employee e) {

        return Event.REQUIREMENT_CHANGE;
    }

    public static Event newTechnology(Employee e) {

        return Event.NEW_TECHNOLOGY;
    }

    public static Event solutionScale(Employee e) {

        return Event.SOLUSTIONDOEST_NOT_SCALE;
    }

    public static Event hacked(Employee e) {

        return Event.HACKED;
    }

    public static Event featureCut(Employee e) {

        return Event.FEATURE_CUT;
    }

    public static Event backupFailed(Employee e) {

        return Event.BACKUP_FAIL;
    }

    public static Event holiday(Employee e) {

        return Event.HOLIDAY;
    }

    public static Event redundancies(Employee e) {

        return Event.REDUNDANCIES;
    }

    public static Event bonus(Employee e) {

        return Event.BONUS;
    }

    public static Event exploreTalent(Employee e) {

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
