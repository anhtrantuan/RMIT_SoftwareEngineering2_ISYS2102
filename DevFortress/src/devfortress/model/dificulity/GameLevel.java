/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model.dificulity;

import devfortress.model.DateTime;
import devfortress.model.Project;
import devfortress.utilities.Skill;
import java.util.Map;

/**
 *
 * @author cathoanghuy
 */
public interface GameLevel {

    Map<Skill, Integer> generateSkillList();

    Project generateProject(String projectNames);

    int generateProjectLevel();

    int generateProjectPayment();

    DateTime generateProjectTime();
}
