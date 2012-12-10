/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress;

import devfortress.controller.Controller;
import devfortress.model.Beer;
import devfortress.model.Computer;
import devfortress.model.Food;
import devfortress.model.project.Project;
import devfortress.model.dificulity.EasyLevel;
import devfortress.model.employee.Employee;
import devfortress.model.exception.EmployeeIsBusyException;
import devfortress.model.exception.OvercrowdedException;
import devfortress.model.facade.Engine;
import devfortress.utilities.Utilities;
import devfortress.view.DevFortressView;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;

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
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            if (javax.swing.UIManager.getSystemLookAndFeelClassName().equals(javax.swing.UIManager.getCrossPlatformLookAndFeelClassName())) {
                for (javax.swing.UIManager.LookAndFeelInfo info :
                        javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } else {
                javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DevFortress.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(DevFortress.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DevFortress.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(DevFortress.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

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
