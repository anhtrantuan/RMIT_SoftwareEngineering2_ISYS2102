/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.controller;

import devfortress.model.employee.Employee;
import devfortress.model.facade.Model;
import devfortress.utilities.Constant;
import devfortress.view.dialogs.EmployeePanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author tommy
 */
public class EmployeesTableButtonListener implements ActionListener {

    private Model model;

    /**
     * Constructor for EmployeesTableButtonListener.
     *
     * @param model
     */
    public EmployeesTableButtonListener(Model model) {
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = ((JButton) e.getSource()).getText();
        Employee employee = model.getEmployeeByName(e.getActionCommand());

        if (text.equals(Constant.EMPLOYEE_DETAILS)) {
            JDialog newDialog = new JDialog((JFrame) null, text, true);
            newDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

            DialogButtonListener buttonListener =
                    new DialogButtonListener(model, newDialog);

            EmployeePanel panel = new EmployeePanel(employee, buttonListener);

            newDialog.setContentPane(panel);
            newDialog.pack();
            newDialog.setVisible(true);
        } else if (text.equals(Constant.EMPLOYEE_MANAGE)) {
            throw new UnsupportedOperationException("Not supported yet!");
        }
    }
}
