/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.controller;

import devfortress.model.employee.Employee;
import devfortress.model.facade.Model;
import devfortress.utilities.Constant;
import devfortress.view.dialogs.AvailableProjectsPanel;
import devfortress.view.dialogs.TrainingPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author anhtran
 */
public class TrainButtonListener implements ActionListener {

    private Model model;
    private JPanel parent;
    private Employee employee;

    /**
     * Constructor for TrainButtonListener.
     *
     * @param model
     * @param dialog
     */
    public TrainButtonListener(Model model, JPanel parent, Employee employee) {
        this.model = model;
        this.parent = parent;
        this.employee = employee;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
