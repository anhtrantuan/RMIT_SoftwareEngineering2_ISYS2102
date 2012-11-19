/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.controller;

import devfortress.model.facade.Model;
import devfortress.utilities.Constant;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

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

        if (text.equals(Constant.EMPLOYEE_DETAILS)) {
        } else if (text.equals(Constant.EMPLOYEE_MANAGE)) {
        }
    }
}
