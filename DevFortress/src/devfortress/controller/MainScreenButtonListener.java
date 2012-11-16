/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.controller;

import devfortress.model.facade.Model;
import devfortress.utilities.Constant;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author tommy
 */
public class MainScreenButtonListener implements ActionListener {

    private Model model;

    /**
     * Constructor for MainScreenButtonListener.
     *
     * @param model
     */
    public MainScreenButtonListener(Model model) {
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals(Constant.BUTTON_SYSTEM)) {
        } else if (command.equals(Constant.BUTTON_NEXT_TURN)) {
        } else if (command.equals(Constant.BUTTON_INFORMATION)) {
        } else if (command.equals(Constant.BUTTTON_CURRENT_PROJECTS)) {
        }
    }
}
