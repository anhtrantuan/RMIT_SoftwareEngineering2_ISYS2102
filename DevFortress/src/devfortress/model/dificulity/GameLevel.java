/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model.dificulity;

import devfortress.model.DateTime;
import devfortress.model.employee.Employee;
import devfortress.model.project.Project;
import devfortress.model.event.Event;
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

    void generateEvent(Employee e);

    DateTime generateProjectTime();
}
