/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.view;

import java.awt.event.ActionListener;

/**
 *
 * @author tommy
 */
public interface View {

    void addDevelopersTableButtonListener(ActionListener developersTableButtonListener);

    void setUpDisplay();

    void addButtonListener(ActionListener buttonListener);
}
