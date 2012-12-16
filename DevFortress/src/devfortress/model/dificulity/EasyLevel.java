/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model.dificulity;

import devfortress.model.Company;
import devfortress.model.DateTime;
import devfortress.model.employee.Employee;


import devfortress.model.event.InvidiualEvent;
import devfortress.model.event.ProjectEvent;
import devfortress.model.project.DevFortressProjectBuilder;
import devfortress.model.project.Project;
import devfortress.model.project.ProjectBuilder;

import devfortress.utilities.Constant;
import devfortress.utilities.Event;
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
    public Event generateEvent(Employee e, Company company) {
        Double r = new Random().nextDouble();
        if (r < 0.1) {
            return InvidiualEvent.sickDeveloper(e);
        } else if (r < 0.15) {
            return InvidiualEvent.requirementChange(e);
        } else if (r < 0.2) {
            return InvidiualEvent.newTechnology(e);
        } else if (r < 0.25) {
            return InvidiualEvent.solutionScale(e);
        } else if (r < 0.26) {
            return InvidiualEvent.hacked(e);
        } else if (r < 0.31) {
            return InvidiualEvent.featureCut(e);
        } else if (r < 0.36) {
            return InvidiualEvent.backupFailed(e);
        } else if (r < 0.41) {
            return InvidiualEvent.holiday(e);
        } else if (r < 0.46) {
            return InvidiualEvent.redundancies(e);
        } else if (r < 0.47) {
            return InvidiualEvent.bonus(e);
        } else if (r < 0.52) {
            return ProjectEvent.teamBuilding(e);
        }
        return Event.NO_EVENT;
    }
}
