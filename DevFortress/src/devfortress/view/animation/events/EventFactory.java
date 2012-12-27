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

        return new TeamBuildingExcercise(dimension);
    }
}
