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
public class DialogButtonListener implements ActionListener {

    private Model model;

    /**
     * Constructor for DialogButtonListener.
     *
     * @param model
     */
    public DialogButtonListener(Model model) {
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = ((JButton) e.getSource()).getText();
        if (text.equals(Constant.HIRE)) {
        } else if (text.equals(Constant.BUTTON_FIRE)) {
        } else if (text.equals(Constant.BUTTON_ACCEPT)) {
        } else if (text.equals(Constant.BUTTON_FIRE)) {
        } else if (text.equals(Constant.BUTTON_CONTRACT)) {
        } else if (text.equals(Constant.BUTTON_HIRE)) {
        } else if (text.equals(Constant.CANCEL)
                || text.equals(Constant.CLOSE_BTN)) {
        }
    }
}
