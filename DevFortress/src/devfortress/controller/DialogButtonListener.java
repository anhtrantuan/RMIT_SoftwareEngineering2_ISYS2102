/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.controller;

import devfortress.model.Employee;
import devfortress.model.Project;
import devfortress.model.exception.OvercrowdedException;
import devfortress.model.facade.Model;
import devfortress.utilities.Constant;
import devfortress.view.dialogs.AvailableEmployeesPanel;
import devfortress.view.dialogs.AvailableProjectsPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;

/**
 *
 * @author tommy
 */
public class DialogButtonListener implements ActionListener {
    
    private Model model;
    private JDialog dialog;

    /**
     * Constructor for DialogButtonListener.
     *
     * @param model
     */
    public DialogButtonListener(Model model, JDialog dialog) {
        this.model = model;
        this.dialog = dialog;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String text = ((JButton) e.getSource()).getText();
        
        if (text.equals(Constant.CANCEL)
                || text.equals(Constant.CLOSE_BTN)) {
            dialog.setVisible(false);
            dialog.dispose();
        } else if (text.equals(Constant.BUTTON_CONTRACT)) {
        } else if (text.equals(Constant.BUTTON_HIRE)) {
        } else {
            int index = Integer.parseInt(e.getActionCommand());
            
            if (text.equals(Constant.HIRE)) {
                AvailableEmployeesPanel panel =
                        (AvailableEmployeesPanel) dialog.getContentPane();
                try {
                    model.hireEmployee(panel.getSelectedEmployee());
                } catch (OvercrowdedException ex) {
                    Logger.getLogger(DialogButtonListener.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (text.equals(Constant.BUTTON_FIRE)) {
                Employee employee = model.getEmployeeList().get(index);
            } else if (text.equals(Constant.BUTTON_ACCEPT)) {
                AvailableProjectsPanel panel =
                        (AvailableProjectsPanel) dialog.getContentPane();
                model.takeProject(panel.getSelectedProject());
            }
        }
    }
}
