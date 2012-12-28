/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress;

import devfortress.controller.Controller;
import devfortress.model.exception.EmployeeNotExist;
import devfortress.model.exception.MoneyRunOutException;
import devfortress.model.facade.Engine;
import devfortress.view.DevFortressView;

/**
 *
 * @author tommy
 */
public class DevFortress {

    private static DevFortressView view;

    /**
     * DevFortress's driver function.
     *
     * @param args
     */
    public static void main(String[] args) throws MoneyRunOutException, EmployeeNotExist {
        /*
         * Create MVC modules.
         */
        Engine model = new Engine();
        view = new DevFortressView(model);
        model.addObserver(view);
        Controller controller = new Controller(model, view);
        view.start();
    }
}
