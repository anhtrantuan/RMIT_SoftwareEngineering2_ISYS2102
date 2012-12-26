
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model.dificulity;

import devfortress.model.Company;
import devfortress.model.DateTime;
import devfortress.model.employee.Employee;
import devfortress.model.event.IndividualEvent;
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



        Skill[] sk = new Skill[numOfField];
        
        int remainingMonthPoint;
        int[]cumulativePoint = new int[numOfField];
        for (int i = 0; i < sk.length; i++) {
            sk[i] = Skill.randomSkill();
        }
        for (int i = 0; i < projectTime.getMonths(); i++) {
            remainingMonthPoint = Constant.MAX_FUCNTION_POINT_MEDIUM;
            for (int j = 0; j< sk.length;j++) {
                if (remainingMonthPoint >= 0) {
                    int requireFuntionPoint = (random.nextInt(Constant.MAX_FUCNTION_POINT_MEDIUM/numOfField) + 1);
                    cumulativePoint[j]+=requireFuntionPoint;
                    map.put(sk[j], cumulativePoint[j]);
                    remainingMonthPoint -= requireFuntionPoint;
                    maxFuntionPoints -= requireFuntionPoint;
                }
                if (maxFuntionPoints <= 0) {
                    continue;
                }
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
            return IndividualEvent.sickDeveloper(e);
        } else if (r < 0.15) {
            return IndividualEvent.requirementChange(e);
        } else if (r < 0.2) {
            return IndividualEvent.newTechnology(e);
        } else if (r < 0.25) {
            return IndividualEvent.solutionScale(e);
        } else if (r < 0.26) {
            return IndividualEvent.hacked(e);
        } else if (r < 0.31) {
            return IndividualEvent.featureCut(e);
        } else if (r < 0.36) {
            return IndividualEvent.backupFailed(e);
        } else if (r < 0.41) {
            return IndividualEvent.holiday(e);
        } else if (r < 0.46) {
            return IndividualEvent.redundancies(e);
        } else if (r < 0.47) {
            return IndividualEvent.bonus(e);
        } else if (r < 0.52) {
            return ProjectEvent.teamBuilding(e);
        } else if (r < 0.57) {
            return IndividualEvent.exploreTalent(e);
        } else if (r < 0.62) {
            return IndividualEvent.getSponsor(e);
        } else if (r < 0.63) {
            return IndividualEvent.projectStolen(e);
        } else if (r < 0.64) {
            return IndividualEvent.employeeLeave(e);
        } else if (r < 0.645) {
            return IndividualEvent.inspiration(e);
        } else if (r < 0.695) {
            return IndividualEvent.developerHasBaby(e);
        } else if (r < 0.705) {
            return ProjectEvent.trainingSponsor(e);
        } else if (r < 0.755) {
            return ProjectEvent.gotSued(e);
        }
        return Event.NO_EVENT;
    }
}
