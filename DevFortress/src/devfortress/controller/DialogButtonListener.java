/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.controller;

import devfortress.model.Beer;
import devfortress.model.Computer;
import devfortress.model.Food;
import devfortress.model.employee.Employee;
import devfortress.model.facade.Model;
import devfortress.utilities.Constant;
import devfortress.view.dialogs.AssignEmployeesPanel;
import devfortress.view.dialogs.AvailableEmployeesPanel;
import devfortress.view.dialogs.AvailableProjectsPanel;
import devfortress.view.dialogs.BuyItemPanel;
import devfortress.view.dialogs.CurrentEmpolyees;
import devfortress.view.dialogs.EmployeePanel;
import devfortress.view.dialogs.ManageEmployeePanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author tommy
 */
public class DialogButtonListener implements ActionListener {

    private Model model;
    private JDialog dialog;

    /**
     * Constructor for DialogButtonListener.
     *
     * @param model
     * @param dialog
     */
    public DialogButtonListener(Model model, JDialog dialog) {
        this.model = model;
        this.dialog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = ((JButton) e.getSource()).getText();

        JDialog newDialog = new JDialog(dialog, text, true);
        newDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        DialogButtonListener buttonListener =
                new DialogButtonListener(model, newDialog);

        try {
            if (text.equals(Constant.CANCEL)
                    || text.equals(Constant.CLOSE_BTN)) {
                dialog.setVisible(false);
                dialog.dispose();
            } else if (text.equals(Constant.BUTTON_CONTRACT)) {
                AvailableProjectsPanel panel =
                        new AvailableProjectsPanel(model.getAvailableProjectList(),
                        buttonListener);
                newDialog.setContentPane(panel);
                newDialog.pack();
                newDialog.setLocationRelativeTo(null);
                newDialog.setVisible(true);
            } else if (text.equals(Constant.BUTTON_HIRE)) {
                AvailableEmployeesPanel panel =
                        new AvailableEmployeesPanel(model.getAvailableEmployeeList(),
                        buttonListener);
                newDialog.setContentPane(panel);
                newDialog.pack();
                newDialog.setLocationRelativeTo(null);
                newDialog.setVisible(true);
            } else if (text.equals(Constant.EMPLOYEE_LIST_BTN)) {
                CurrentEmpolyees panel = new CurrentEmpolyees(model);
                panel.setTableButtonListener(new EmployeesTableButtonListener(panel,
                        model));
                newDialog.setContentPane(panel);
                newDialog.pack();
                newDialog.setLocationRelativeTo(null);
                newDialog.setVisible(true);
            } else if (text.equals(Constant.BUY_BTN)) {
                BuyItemPanel panel = new BuyItemPanel(model, buttonListener);
                newDialog.setContentPane(panel);
                newDialog.pack();
                newDialog.setLocationRelativeTo(null);
                newDialog.setVisible(true);
            } else if (text.equals(Constant.BUY)) {
                BuyItemPanel panel = (BuyItemPanel) dialog.getContentPane();
                if (panel.getTotal() > model.getBudget()) {
                    JOptionPane.showMessageDialog(dialog,
                            "Not enough money to buy those items!",
                            "Low Budget Warning",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    int option = JOptionPane.showConfirmDialog(dialog,
                            "Are you sure you want to purchase those items?",
                            "Purchase Confirmation", JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                    if (option == JOptionPane.YES_OPTION) {
                        int foodQuantity = panel.getFoodQuantity(),
                                beerQuantity = panel.getBeerQuantity(),
                                computerQuantity = panel.getComputerQuantity();
                        if (foodQuantity > 0) {
                            model.buyItem(new Food(), foodQuantity);
                        }
                        if (beerQuantity > 0) {
                            model.buyItem(new Beer(), beerQuantity);
                        }
                        if (computerQuantity > 0) {
                            model.buyItem(new Computer(), computerQuantity);
                        }

                        dialog.setVisible(false);
                        dialog.dispose();
                    }
                }
            } else if (text.equals(Constant.HAVE_BEER_BTN)) {
                int option = JOptionPane.showConfirmDialog(dialog,
                        "Are you sure you want to let this employee have beer?",
                        "Drink Confirmation", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (option == JOptionPane.YES_OPTION) {
                    ManageEmployeePanel panel =
                            (ManageEmployeePanel) dialog.getContentPane();
                    panel.haveBeer();

                    JOptionPane.showMessageDialog(dialog,
                            "An employee has just had some beer and is now happy!",
                            "Drink Status", JOptionPane.INFORMATION_MESSAGE);
                }
            } else if (text.equals(Constant.BUTTON_ACCEPT)) {
                int option = JOptionPane.showConfirmDialog(dialog,
                        "Are you sure you want to sign this contract?",
                        "Contract Confirmation", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (option == JOptionPane.YES_OPTION) {
                    AvailableProjectsPanel panel =
                            (AvailableProjectsPanel) dialog.getContentPane();
                    model.takeProject(panel.getSelectedProject());
                    model.getAvailableProjectList().
                            remove(panel.getSelectedProject());

                    dialog.setVisible(false);
                    dialog.dispose();
                }
            } else if (text.equals(Constant.HIRE)) {
                int option = JOptionPane.showConfirmDialog(dialog,
                        "Are you sure you want to hire this employee?",
                        "Hire Confirmation", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (option == JOptionPane.YES_OPTION) {
                    AvailableEmployeesPanel panel =
                            (AvailableEmployeesPanel) dialog.getContentPane();

                    model.hireEmployee(panel.getSelectedEmployee());
                    model.getAvailableEmployeeList().
                            remove(panel.getSelectedEmployee());

                    dialog.setVisible(false);
                    dialog.dispose();
                }
            } else if (text.equals(Constant.BUTTON_FIRE)) {
                int option = JOptionPane.showConfirmDialog(dialog,
                        "Are you sure you want to fire this employee?",
                        "Fire Confirmation", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (option == JOptionPane.YES_OPTION) {
                    Employee employee =
                            model.getEmployeeByName(e.getActionCommand());
                    model.fireEmployee(employee);
                    EmployeePanel panel = (EmployeePanel) dialog.getContentPane();
                    panel.updateEmployeeList();

                    dialog.setVisible(false);
                    dialog.dispose();
                }
            } else if (text.equals(Constant.ASSIGN)) {
                int option = JOptionPane.showConfirmDialog(dialog,
                        "Are you sure you want to assign this employee to the project?",
                        "Assign Confirmation", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (option == JOptionPane.YES_OPTION) {
                    AssignEmployeesPanel panel =
                            (AssignEmployeesPanel) dialog.getContentPane();
                    panel.assign();
                    
                    dialog.setVisible(false);
                    dialog.dispose();
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(DialogButtonListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
