/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.controller;

import devfortress.model.employee.Employee;
import devfortress.model.facade.Model;
import devfortress.utilities.Constant;
import devfortress.view.dialogs.EmployeePanel;
import devfortress.view.dialogs.ManageEmployeePanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author tommy
 */
public class EmployeesTableButtonListener implements ActionListener {

    private JPanel parent;
    private Model model;

    /**
     * Constructor for EmployeesTableButtonListener.
     *
     * @param model
     */
    public EmployeesTableButtonListener(JPanel parent, Model model) {
        this.parent = parent;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = ((JButton) e.getSource()).getText();
        Employee employee = model.getEmployeeByName(e.getActionCommand());

        JDialog newDialog = new JDialog((JFrame) null, text, true);
        newDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        DialogButtonListener buttonListener =
                new DialogButtonListener(model, newDialog);

        if (text.equals(Constant.EMPLOYEE_DETAILS)) {
            EmployeePanel panel = new EmployeePanel(parent, employee,
                    buttonListener);
            newDialog.setContentPane(panel);
        } else if (text.equals(Constant.EMPLOYEE_MANAGE)) {
            ManageEmployeePanel panel = new ManageEmployeePanel(parent, employee,
                    buttonListener);
            newDialog.setContentPane(panel);
        }

        newDialog.pack();
        newDialog.setVisible(true);
    }
}
