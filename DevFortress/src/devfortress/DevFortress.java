/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress;

import devfortress.controller.Controller;
import devfortress.model.Beer;
import devfortress.model.Computer;
import devfortress.model.DateTime;
import devfortress.model.Employee;
import devfortress.model.Food;
import devfortress.model.Project;
import devfortress.model.dificulity.EasyLevel;
import devfortress.model.exception.MoneyRunOutException;
import devfortress.model.exception.OvercrowdedException;
import devfortress.model.facade.Engine;
import devfortress.utilities.Constant;
import devfortress.utilities.Skills;
import devfortress.utilities.Utilities;
import devfortress.view.DevFortressView;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
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
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info :
                    javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException |
                IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(
                    DevFortressView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                model.buyItem(new Beer(5), 1);
                model.buyItem(new Computer(), 20);
                model.buyItem(new Food(300, "Pizza"), 1);



                HashMap<Skills, Integer> skillList = new HashMap<>();
                skillList.put(Skills.C, 5);
                skillList.put(Skills.LISP, 4);
                skillList.put(Skills.DESIGN, 8);
                skillList.put(Skills.ALGORITHMS, 6);
                skillList.put(Skills.CONFIG_MANAGEMENT, 5);
                List<Project> projectsList = Utilities.generateProjectList(new EasyLevel(), Constant.PROJECT_MAX);
                for (Project project : projectsList) {
                    model.takeProject(project);
                }
//                model.takeProject(new Project("P" + new Random().nextLong(), 100, 100, 1, new DateTime(0, 6, 0), skillList));

                try {
                    //model.hireEmployee(new Employee("Joe", 100, skillList));
                    List<Employee> employeeList = Utilities.generateEmployeeList(new EasyLevel(), Constant.EMPLOYEE_MAX);
                    for (Employee object : employeeList) {
                        model.hireEmployee(object);
                    }
                    //                    model.hireEmployee(new Employee("Doe", 200, skillList));
//                    model.hireEmployee(new Employee("Foo",500,skillList));
                } catch (OvercrowdedException ex) {
                    Logger.getLogger(DevFortress.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
