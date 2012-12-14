/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model.dificulity;

import devfortress.model.DateTime;


import devfortress.model.event.Event;
import devfortress.model.project.DevFortressProjectBuilder;
import devfortress.model.project.Project;
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
public class EasyLevel implements GameLevel {
    
    ProjectBuilder projectBuilder = new DevFortressProjectBuilder();
    @Override
    public Map<Skill, Integer> generateSkillList() {
        Map<Skill, Integer> map = new EnumMap<Skill, Integer>(Skill.class);
        Random random = new Random();
        int numOfField = random.nextInt(3) + 4;
        for (int i = 0; i < numOfField; i++) {
            map.put(Skill.randomSkill(), random.nextInt(3) + 1);
        }
        return map;
    }

    @Override
    public int generateProjectLevel() {
        return new Random().nextInt(2) + 1;
    }

    @Override
    public int generateProjectPayment() {
        return ((new Random().nextInt(51) + 30) * 10000) / 2;
    }

    @Override
    public DateTime generateProjectTime() {
        return new DateTime(0, new Random().nextInt(7) + 2, 0);
    }

    @Override
    public Project generateProject(String projectName) {
        Random random = new Random();
        Map<Skill, Integer> map = new EnumMap<Skill, Integer>(Skill.class);

        DateTime projectTime = this.generateProjectTime();
        int maxFuntionPoints = projectTime.getMonths()
                * Constant.MAX_FUCNTION_POINT_EASY;
        int totalPoints = maxFuntionPoints;

        int numOfField = random.nextInt(6) + 2;


        for (int i = 0; i < numOfField; i++) {
            int requireFuntionPoint = (random.nextInt(maxFuntionPoints / 2) + 1);
            map.put(Skill.randomSkill(), requireFuntionPoint);
            maxFuntionPoints -= requireFuntionPoint;

            if (maxFuntionPoints <= 0) {
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
        Random r = new Random();

        if (r.nextBoolean()) {
            return generateInvidiualEvent();
        } else {
            return generateTeamEvent();
        }
        
    }

    private Event generateInvidiualEvent() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private Event generateTeamEvent() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

//    @Override
//    public Event generateEvent() {
//        Random r = new Random();
//        if (r.nextBoolean()) {
//            return new 
//        }
//    }
    
    
}
