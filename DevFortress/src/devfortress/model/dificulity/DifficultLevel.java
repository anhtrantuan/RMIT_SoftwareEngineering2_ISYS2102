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
public class DifficultLevel implements GameLevel {

    ProjectBuilder projectBuilder = new DevFortressProjectBuilder();

    @Override
    public Map<Skill, Integer> generateSkillList() {
        Map<Skill, Integer> map = new EnumMap<Skill, Integer>(Skill.class);
        Random random = new Random();
        int numOfField = random.nextInt(4) + 10;
        for (int i = 0; i < numOfField; i++) {
            map.put(Skill.randomSkill(), random.nextInt(5) + 6);
        }
        return map;
    }

    @Override
    public int generateProjectLevel() {
        Random random = new Random();
        return random.nextInt(2) + 4;
    }

    @Override
    public int generateProjectPayment() {
        Random random = new Random();
        return (random.nextInt(201) + 300) * 10000;
    }

    @Override
    public DateTime generateProjectTime() {
        Random random = new Random();
        int months = random.nextInt(13) + 12;
        return new DateTime(0, months % 12, months / 12);
    }

    @Override
    public Project generateProject(String projectName) {
        Random random = new Random();
        Map<Skill, Integer> map = new EnumMap<Skill, Integer>(Skill.class);

        DateTime projectTime = this.generateProjectTime();
        int maxFuntionPoints = projectTime.getMonths()
                * Constant.MAX_FUNCTION_POINT_DIFFICULT;
        int totalPoints = maxFuntionPoints;

        int numOfField = random.nextInt(6) + 10;


        for (int i = 0; i < numOfField; i++) {
            int requireFuntionPoint = (random.nextInt(maxFuntionPoints / 2) + 1);
            map.put(Skill.randomSkill(), requireFuntionPoint);
            maxFuntionPoints -= requireFuntionPoint;
            if (maxFuntionPoints <= 10) {
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
        } else if (r < 0.57) {
            return InvidiualEvent.exploreTalent(e);
        } else if (r < 0.62) {
            return InvidiualEvent.getSponsor(e);
        } else if (r < 0.63) {
            return InvidiualEvent.projectStolen(e);
        } else if (r < 0.64) {
            return InvidiualEvent.employeeLeave(e);
        } else if (r < 0.645) {
            return InvidiualEvent.inspiration(e);
        } else if (r < 0.695) {
            return InvidiualEvent.developerHasBaby(e);
        } else if (r < 0.705) {
            return ProjectEvent.trainingSponsor(e);
        } else if (r < 0.755) {
            return ProjectEvent.gotSued(e);
        } else if (r < 0.765) {
            return InvidiualEvent.accident(e);
        } else if (r < 0.77) {
            return ProjectEvent.killDeveloper(e);
        } else if (r < 0.771) {
            return ProjectEvent.GoldenEmployee(e);
        } else if (r < 0.776) {
            return ProjectEvent.companyBurnt(e);
        } else if (r < 0.781) {
            return ProjectEvent.warErrupt(e);
        } else if (r < 0.782) {
            return ProjectEvent.zombie(e);
        }
        return Event.NO_EVENT;
    }
}
