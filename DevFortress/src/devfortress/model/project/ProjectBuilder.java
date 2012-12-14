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
public abstract class ProjectBuilder {
    protected Project project;
    
    public void createNewProject(){
        project = new Project();
    }

    public Project getProject() {
        return project;
    }

    public abstract void addName(String name);
    
    public abstract void addTotalPoint(int totalPoint);
    
    public abstract void addPayment(float payment);
    
    public abstract void addProjectLvl(int projectLvl);
    
    public abstract void addProjectTime (DateTime projectTime);
    
    public abstract void addSkillRequirementMap(Map<Skill, Integer> skillRequirementMap);
}
