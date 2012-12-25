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

        /* Run and display View. */
        Thread viewThread = new Thread(view);
        viewThread.start();
        
        /*Thread for event animation*/
        Thread eventThread = new Thread(view);
        eventThread.start();

        /* Wait until View is active. */
        while (!view.isActive()) {
        }
        try {
            /* Dummy Data
             * Start:
             */
            model.buyItem(new Beer(50), 1);
            model.buyItem(new Computer(), 1);
            model.buyItem(new Food(10, "Pizza"), 4);
            model.buyItem(new Food(10, "Coffee"), 4);
        } catch (UnaffordableException ex) {
            Logger.getLogger(DevFortress.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        EasyLevel level = new EasyLevel();
        List<Project> projects = Utilities.getInstance().generateProjectList(level, 1, model);
        model.takeProject(projects.get(0));
        List<Employee> employees = Utilities.getInstance().generateEmployeeList(level, 1, model);

        try {

            model.hireEmployee(employees.get(0));

        } catch (OvercrowdedException ex) {
            Logger.getLogger(DevFortress.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnaffordableException ex) {
            Logger.getLogger(DevFortress.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            model.assignEmployeeToProject(employees.get(0), projects.get(0), projects.get(0).getMainSkill());
        } catch (EmployeeIsBusyException ex) {
            Logger.getLogger(DevFortress.class.getName()).log(Level.SEVERE, null, ex);
        }
        /* Dummy Data
         * :End
         */
    }
}
