/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress;

import devfortress.controller.Controller;
import devfortress.model.Beer;
import devfortress.model.Computer;
import devfortress.model.Food;
import devfortress.model.dificulity.EasyLevel;
import devfortress.model.employee.Employee;
import devfortress.model.exception.EmployeeIsBusyException;
import devfortress.model.exception.EmployeeNotExist;
import devfortress.model.exception.MoneyRunOutException;
import devfortress.model.exception.OvercrowdedException;
import devfortress.model.exception.UnaffordableException;
import devfortress.model.facade.Engine;
import devfortress.model.project.Project;
import devfortress.utilities.Utilities;
import devfortress.view.DevFortressView;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

        /* 
         * Dummy Data
         * :End
         */
    }
}
