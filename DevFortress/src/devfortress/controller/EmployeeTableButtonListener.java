/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.controller;

import devfortress.model.facade.Model;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author tommy
 */
public class EmployeeTableButtonListener implements ActionListener {
    
    private Model model;

    /**
     * Constructor for EmployeeTableButtonListener.
     *
     * @param model
     */
    public EmployeeTableButtonListener(Model model) {
        this.model = model;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
