/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.view.animation.events;

import com.tabuto.j2dgf.Game2D;
import devfortress.utilities.Event;
import java.awt.Dimension;

/**
 *
 * @author anhtran
 */
public class EventFactory {

    /**
     * Create animation engine by event.
     *
     * @param event
     * @return
     */
    public static Game2D createEvent(Dimension dimension, Event event) {
        // TODO Finish event factory
        if (event == Event.BONUS) {
            return new Bonus(dimension);
        }

        if (event == Event.DEVELOPER_IS_SICK) {
            return new DeveloperIsSickEventAnimation(dimension);
        }

        if (event == Event.FEATURE_CUT) {
            return new FeatureCut(dimension);
        }

        if (event == Event.HOLIDAY) {
            return new Holiday(dimension);
        }

        if (event == Event.NEW_TECHNOLOGY) {
            return new NewTechnologyEventAnimation(dimension);
        }

        if (event == Event.REDUNDANCIES) {
            return new Redundancies(dimension);
        }

        if (event == Event.TEAM_BUILDING_EXERCISE) {
            return new TeamBuildingExcercise(dimension);
        }

        if (event == Event.HACKED) {
            return new WorkIsHacked(dimension);
        }
        
        if (event == Event.GOLDEN_EMPLOYEE) {
            return new GoldenEmployee(dimension);
        }
        
        if (event == Event.EXPLORE_THE_EMPLOYEE_HAVING_TALENT) {
            return new TalentFound(dimension);
        }
        if (event == Event.PROJECT_IS_STOLEN_BY_EMPLOYEE) {
            return new ProjectIsStolen(dimension);
        }
        if (event == Event.DEVELOPER_HAS_BABY) {
            return new HavingBaby(dimension);
        }
        if (event == Event.GOT_SUED_BY_ANOTHER_COMPANY) {
            return new GetSued(dimension);
        }
        if (event == Event.DEVELOPER_KILLS_ANOTHER_DEVELOPER) {
            return new DevKillEachOther(dimension);
        }
        
        if (event == Event.WAR_ERUPTS) {
            return new WarErupts(dimension);
        }
        if (event == Event.COMPANY_IS_BURNT_DOWN_BY_ANONYMOUS) {
            return new CompanyIsBurnt(dimension);
        }
        if (event == Event.ZOMBIE_APOCALYPSE) {
            return new ZombieApocalypse(dimension);
        }

        return new NothingEvent(dimension);
    }
}
