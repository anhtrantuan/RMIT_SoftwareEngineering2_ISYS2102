/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.controller;

import devfortress.model.facade.Model;
import devfortress.utilities.Constant;
import devfortress.view.View;
import devfortress.view.dialogs.CurrentProjectsPanel;
import devfortress.view.dialogs.LogPanel;
import devfortress.view.dialogs.SystemPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author tommy
 */
public class MainScreenButtonListener implements ActionListener {

    private Model model;
    private View view;

    /**
     * Constructor for MainScreenButtonListener.
     *
     * @param model
     */
    public MainScreenButtonListener(Model model, View view) {
        this.model = model;
        this.view = view;
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
            try {
                model.nextTurn();
            } catch (Exception ex) {
                Logger.getLogger(MainScreenButtonListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (text.equals(Constant.LOG)) {
            LogPanel panel = new LogPanel(view.getLog());
            dialog.setContentPane(panel);
            dialog.pack();
            dialog.setVisible(true);
        } else if (text.equals(Constant.BUTTTON_CURRENT_PROJECTS)) {
            CurrentProjectsPanel panel =
                    new CurrentProjectsPanel(model.getProjectList(),
                    buttonListener);
            ProjectsTableButtonListener tableButtonListener =
                    new ProjectsTableButtonListener(model, dialog);
            panel.setTableButtonListener(tableButtonListener);
            dialog.setContentPane(panel);
            dialog.pack();
            dialog.setVisible(true);
        }
    }
}
