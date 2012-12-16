
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model.event;

import devfortress.model.employee.Employee;
import devfortress.utilities.Event;

/**
 *
 * @author Cat Hoang Huy
 */
public class ProjectEvent implements EventInterface {

    public static Event teamBuilding(Employee e) {

        return Event.TEAM_BUILDING_EXERCISE;
    }

    public static Event trainingSponsor(Employee e) {

        return Event.TRAINING_SPONSOR;
    }

    public static Event gotSued(Employee e) {

        return Event.GOT_SUED_BY_ANOTHER_COMPANY;
    }

    public static Event killDeveloper(Employee e) {

        return Event.DEVELOPER_KILLS_ANOTHER_DEVELOPER;
    }

    public static Event GoldenEmployee(Employee e) {

        return Event.GOLDEN_EMPLOYEE;
    }

    public static Event warErrupt(Employee e) {

        return Event.WAR_ERUPTS;
    }

    public static Event companyBurnt(Employee e) {

        return Event.COMPANY_IS_BURNT_DOWN_BY_ANONYMOUS;
    }

    public static Event zombie(Employee e) {

        return Event.ZOMBIE_APOCALYPSE;
    }
}
