/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.controller;

import devfortress.model.Project;
import devfortress.model.facade.Model;
import devfortress.utilities.Constant;
import devfortress.view.dialogs.CurrentProjectsPanel;
import devfortress.view.dialogs.ProjectPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;

/**
 *
 * @author tommy
 */
public class ProjectsTableButtonListener implements ActionListener {

    private Model model;
    private JDialog dialog;

    /**
     * Constructor for ProjectsTableButtonListener.
     *
     * @param model
     */
    public ProjectsTableButtonListener(Model model, JDialog dialog) {
        this.model = model;
        this.dialog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = ((JButton) e.getSource()).getText();
        Project project = model.getProjectByName(e.getActionCommand());

        if (text.equals(Constant.BUTTON_INFORMATION)) {
            JDialog newDialog = new JDialog(dialog, text, true);
            newDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

            DialogButtonListener buttonListener =
                    new DialogButtonListener(model, newDialog);

            ProjectPanel panel = new ProjectPanel(project, buttonListener);

            ProjectTableButtonListener tableButtonListener =
                    new ProjectTableButtonListener(model, newDialog);
            panel.setTableButtonListener(tableButtonListener);
            newDialog.setContentPane(panel);
            newDialog.pack();
            newDialog.setVisible(true);
        } else if (text.equals(Constant.CANCEL)) {
            model.cancelProject(project);
            CurrentProjectsPanel panel =
                    (CurrentProjectsPanel) dialog.getContentPane();
            panel.setProjectList(model.getProjectList());
        }
    }
}
