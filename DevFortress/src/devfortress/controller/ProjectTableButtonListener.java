/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.controller;

import devfortress.model.employee.Employee;
import devfortress.model.facade.Model;
import devfortress.model.project.Project;
import devfortress.utilities.Constant;
import devfortress.utilities.Skill;
import devfortress.view.dialogs.ProjectPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JDialog;

/**
 *
 * @author tommy
 */
public class ProjectTableButtonListener implements ActionListener {
    
    private Model model;
    private JDialog dialog;

    /**
     * Constructor for ProjectTableButtonListener.
     *
     * @param model
     */
    public ProjectTableButtonListener(Model model, JDialog dialog) {
        this.model = model;
        this.dialog = dialog;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String text = ((JButton) e.getSource()).getText();
        
        ProjectPanel panel = (ProjectPanel) dialog.getContentPane();
        
        Project project = panel.getProject();
        Map<Skill, Employee> skillEmployeeMap = project.getSkill_employeeMap();
        
        if (text.equals(Constant.ASSIGN)) {
            throw new UnsupportedOperationException("Not supported yet!");
        } else if (text.equals(Constant.UNASSIGN)) {
            Employee employee = model.getEmployeeByName(e.getActionCommand());
            Skill skill = null;
            
            Skill skills[] = new Skill[skillEmployeeMap.size()];
            skillEmployeeMap.keySet().toArray(skills);
            
            for (int i = 0; i < skills.length; i++) {
                if (skillEmployeeMap.get(skills[i]).equals(employee)) {
                    skill = skills[i];
                    i = skills.length;
                }
            }
            model.unassignEmployee(project, employee);
            panel.setProject(model.getProjectByName(project.getName()));
        }
    }
}
