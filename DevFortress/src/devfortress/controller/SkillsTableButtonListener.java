/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.controller;

import devfortress.model.employee.Employee;
import devfortress.model.exception.UnaffordableException;
import devfortress.model.facade.Model;
import devfortress.utilities.Skill;
import devfortress.view.dialogs.TrainingPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author tommy
 */
public class SkillsTableButtonListener implements ActionListener {

    private TrainingPanel parent;
    private Model model;
    private Employee employee;

    /**
     * Constructor for SkillsTableButtonListener.
     *
     * @param model
     * @param dialog
     */
    public SkillsTableButtonListener(JPanel parent, Model model) {
        this.parent = (TrainingPanel) parent;
        this.model = model;
        this.employee = this.parent.getEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Skill skill = Skill.valueOf(e.getActionCommand());
        try {
            model.train(employee, skill);
            parent.update();
        } catch (UnaffordableException ex) {
            JOptionPane.showMessageDialog(parent, "Not enough money to train!",
                    "Train Fee Too High", JOptionPane.WARNING_MESSAGE);
        }
    }
}
