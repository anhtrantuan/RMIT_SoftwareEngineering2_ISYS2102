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
import javax.swing.JDialog;

/**
 *
 * @author tommy
 */
public class ProjectTableButtonListener implements ActionListener {

    private Model model;
    private JDialog dialog;

    /**
     * Constructor for ProjectTableButtonListener.
     *
     * @param model
     */
    public ProjectTableButtonListener(Model model, JDialog dialog) {
        this.model = model;
        this.dialog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = ((JButton) e.getSource()).getText();

        if (text.equals(Constant.ASSIGN)) {
            throw new UnsupportedOperationException("Not supported yet!");
        } else if (text.equals(Constant.UNASSIGN)) {
            throw new UnsupportedOperationException("Not supported yet!");
        }
    }
}
