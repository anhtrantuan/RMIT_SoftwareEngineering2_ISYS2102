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
import devfortress.view.dialogs.AssignEmployeesPanel;
import devfortress.view.dialogs.ProjectPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        JButton button = (JButton) e.getSource();
        String text = button.getText(),
                action = button.getActionCommand(),
                actions[] = action.split(":");

        ProjectPanel panel = (ProjectPanel) dialog.getContentPane();
        Project project = panel.getProject();

        if (text.equals(Constant.ASSIGN)) {
            JDialog newDialog = new JDialog(dialog, text, true);
            newDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

            DialogButtonListener buttonListener =
                    new DialogButtonListener(model, newDialog);

            Skill skill = Skill.valueOf(actions[0]);
            AssignEmployeesPanel assignPanel = new AssignEmployeesPanel(panel,
                    model, project, skill, buttonListener);

            newDialog.setContentPane(assignPanel);
            newDialog.pack();
            newDialog.setVisible(true);
        } else if (text.equals(Constant.UNASSIGN)) {
            Employee employee = model.getEmployeeByName(actions[1]);
            model.unassignEmployee(project, employee);
            panel.setProject(model.getProjectByName(project.getName()));
        }
    }
}
