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
public class DevelopersTableButtonListener implements ActionListener {
    
    private Model model;

    /**
     * Constructor for DevelopersTableButtonListener.
     *
     * @param model
     */
    public DevelopersTableButtonListener(Model model) {
        this.model = model;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
