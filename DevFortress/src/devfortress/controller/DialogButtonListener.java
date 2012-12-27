/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.controller;

import devfortress.model.employee.Employee;
import devfortress.model.exception.EmployeeNotExist;
import devfortress.model.exception.MoneyRunOutException;
import devfortress.model.exception.OvercrowdedException;
import devfortress.model.exception.UnaffordableException;
import devfortress.model.facade.Model;
import devfortress.utilities.Constant;
import devfortress.view.dialogs.AllCurrentEmpolyees;
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

        JDialog newDialog = new JDialog(dialog, text, true);
        newDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        DialogButtonListener buttonListener =
                new DialogButtonListener(model, newDialog);

        if (text.equals(Constant.CANCEL)
                || text.equals(Constant.CLOSE_BTN)) {
            dialog.setVisible(false);
            dialog.dispose();
        } else if (text.equals(Constant.BUTTON_CONTRACT)) {
            AvailableProjectsPanel panel =
                    new AvailableProjectsPanel(model.getAvailableProjectList(),
                    buttonListener);
            newDialog.setContentPane(panel);
            newDialog.pack();
            newDialog.setVisible(true);
        } else if (text.equals(Constant.BUTTON_HIRE)) {
            AvailableEmployeesPanel panel =
                    new AvailableEmployeesPanel(model.getAvailableEmployeeList(),
                    buttonListener);
            newDialog.setContentPane(panel);
            newDialog.pack();
            newDialog.setVisible(true);
        } else if (text.equals(Constant.EMPLOYEE_LIST_BTN)) {
            AllCurrentEmpolyees panel =
                    new AllCurrentEmpolyees(model.getEmployeeList(),
                    buttonListener);
            panel.setTableButtonListener(new EmployeesTableButtonListener(model));
            newDialog.setContentPane(panel);
            newDialog.pack();
            newDialog.setVisible(true);
        } else if (text.equals(Constant.BUY_BTN)) {
        } else {
            try {
                if (text.equals(Constant.HIRE)) {
                    AvailableEmployeesPanel panel =
                            (AvailableEmployeesPanel) dialog.getContentPane();

                    model.hireEmployee(panel.getSelectedEmployee());
                    model.getAvailableEmployeeList().
                            remove(panel.getSelectedEmployee());
                } else if (text.equals(Constant.BUTTON_FIRE)) {
                    Employee employee =
                            model.getEmployeeByName(e.getActionCommand());
                    model.fireEmployee(employee);
                } else if (text.equals(Constant.BUTTON_ACCEPT)) {
                    AvailableProjectsPanel panel =
                            (AvailableProjectsPanel) dialog.getContentPane();
                    model.takeProject(panel.getSelectedProject());
                    model.getAvailableProjectList().
                            remove(panel.getSelectedProject());
                }

                dialog.setVisible(false);
                dialog.dispose();
            } catch (Exception ex) {
                Logger.getLogger(DialogButtonListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
