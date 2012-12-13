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
import devfortress.model.exception.OvercrowdedException;
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

    /**
     * DevFortress's driver function.
     *
     * @param args
     */
    public static void main(String[] args) {
        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                /*
                 * Create MVC modules.
                 */
                Engine model = new Engine();
                DevFortressView view = new DevFortressView(model);
                model.addObserver(view);
                Controller controller = new Controller(model, view);

                /*
                 * Display DevFortressView.
                 */
                view.setVisible(true);
                model.buyItem(new Beer(50), 1);
                model.buyItem(new Computer(), 1);
                model.buyItem(new Food(300, "Pizza"), 1);
                model.buyItem(new Food(300, "Coffee"), 1);

                EasyLevel level = new EasyLevel();
                List<Project> projects = Utilities.getInstance().generateProjectList(level, 1, model);
                model.takeProject(projects.get(0));
                List<Employee> employees = Utilities.getInstance().generateEmployeeList(level, 1, model);

                try {
                    model.hireEmployee(employees.get(0));
                } catch (OvercrowdedException ex) {
                    Logger.getLogger(DevFortress.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    model.assignEmployeeToProject(employees.get(0), projects.get(0), projects.get(0).getMainSkill());
                } catch (EmployeeIsBusyException ex) {
                    Logger.getLogger(DevFortress.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
