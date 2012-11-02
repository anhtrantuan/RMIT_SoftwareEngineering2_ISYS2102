/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.view;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author tommy
 */
public class View implements Observer, Runnable {

    public View() {
        System.out.println("_View_");
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
