
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model.dificulity;

import devfortress.model.DateTime;
import devfortress.model.project.Project;
import devfortress.model.event.Event;
import devfortress.model.project.DevFortressProjectBuilder;
import devfortress.model.project.ProjectBuilder;
import devfortress.utilities.Constant;
import devfortress.utilities.Skill;
import java.util.EnumMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author cathoanghuy
 */
public class MediumLevel implements GameLevel {
    ProjectBuilder projectBuilder = new DevFortressProjectBuilder();
    @Override
    public Map<Skill, Integer> generateSkillList() {
        Map<Skill, Integer> map = new EnumMap<Skill, Integer>(Skill.class);
        Random random = new Random();
        int numOfField = random.nextInt(4) + 6;
        for (int i = 0; i < numOfField; i++) {
            map.put(Skill.randomSkill(), random.nextInt(5) + 3);
        }
        return map;
    }

    @Override
    public int generateProjectLevel() {
        Random random = new Random();
        return random.nextInt(2) + 3;
    }

    @Override
    public int generateProjectPayment() {
        Random random = new Random();
        return (random.nextInt(81) + 100) * 10000;
    }

    @Override
    public DateTime generateProjectTime() {
        Random random = new Random();
        return new DateTime(0, random.nextInt(8) + 5, 0);
    }

    @Override
    public Project generateProject(String projectName) {
        Random random = new Random();
        Map<Skill, Integer> map = new EnumMap<Skill, Integer>(Skill.class);

        DateTime projectTime = this.generateProjectTime();
        int maxFuntionPoints = projectTime.getMonths()
                * Constant.MAX_FUCNTION_POINT_MEDIUM;
        int totalPoints = maxFuntionPoints;

        int numOfField = random.nextInt(6) + 6;



        for (int i = 0; i < numOfField; i++) {
            int requireFuntionPoint = (random.nextInt(maxFuntionPoints / 2) + 1);
            map.put(Skill.randomSkill(), requireFuntionPoint);
            maxFuntionPoints -= requireFuntionPoint;

            if (maxFuntionPoints <= 5) {

                continue;
            }
        }

        projectBuilder.createNewProject();
        projectBuilder.addName(projectName);
        projectBuilder.addTotalPoint(totalPoints);
        projectBuilder.addPayment(this.generateProjectPayment());
        projectBuilder.addProjectLvl(this.generateProjectLevel());
        projectBuilder.addProjectTime(projectTime);
        projectBuilder.addSkillRequirementMap(map);
        return projectBuilder.getProject();
    }

    @Override
    public Event generateEvent() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
