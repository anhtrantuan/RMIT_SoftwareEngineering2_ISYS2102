/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model.project;

import devfortress.model.DateTime;
import devfortress.utilities.Skill;
import java.util.Map;

/**
 *
 * @author Sherlock
 */
public class DevFortressProjectBuilder extends ProjectBuilder{

    @Override
    public void addName(String name) {
        project.setName(name);
    }

    @Override
    public void addTotalPoint(int totalPoint) {
        project.setTotalPoints(totalPoint);
        project.setRemainingPoints(totalPoint);
    }

    @Override
    public void addPayment(float payment) {
        project.setPayment(payment);
    }

    @Override
    public void addProjectLvl(int projectLvl) {
        project.setProjectLevel(projectLvl);
    }

    @Override
    public void addProjectTime(DateTime projectTime) {
        project.setProjectTime(projectTime);
        project.setRemainingTime(projectTime);
    }

    @Override
    public void addSkillRequirementMap(Map<Skill, Integer> skillRequirementMap) {
        project.setOriginalSkillRequirementMap(skillRequirementMap);
        project.setSkillRequirementMap(skillRequirementMap);
    }
    
}
