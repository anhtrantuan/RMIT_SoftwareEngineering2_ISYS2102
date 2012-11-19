/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.controller;

import devfortress.model.facade.Model;
import devfortress.utilities.Constant;
import devfortress.view.dialogs.CurrentProjectsPanel;
import devfortress.view.dialogs.SystemPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author tommy
 */
public class MainScreenButtonListener implements ActionListener {

    private Model model;

    /**
     * Constructor for MainScreenButtonListener.
     *
     * @param model
     */
    public MainScreenButtonListener(Model model) {
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = ((JButton) e.getSource()).getText();

        JDialog dialog = new JDialog((JFrame) null, text, true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        DialogButtonListener buttonListener =
                new DialogButtonListener(model, dialog);

        if (text.equals(Constant.BUTTON_SYSTEM)) {
            SystemPanel panel = new SystemPanel(buttonListener);
            dialog.setContentPane(panel);
            dialog.pack();
            dialog.setVisible(true);
        } else if (text.equals(Constant.BUTTON_NEXT_TURN)) {
            throw new UnsupportedOperationException("Not supported yet!");
        } else if (text.equals(Constant.BUTTON_INFORMATION)) {
            throw new UnsupportedOperationException("Not supported yet!");
        } else if (text.equals(Constant.BUTTTON_CURRENT_PROJECTS)) {
            CurrentProjectsPanel panel =
                    new CurrentProjectsPanel(model.getProjectList(),
                    buttonListener);
            ProjectsTableButtonListener tableButtonListener =
                    new ProjectsTableButtonListener(model);
            panel.setTableButtonListener(tableButtonListener);
            dialog.setContentPane(panel);
            dialog.pack();
            dialog.setVisible(true);
        }
    }
}
