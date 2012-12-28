/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.view.models;

import devfortress.model.employee.Employee;
import devfortress.model.project.Project;
import devfortress.utilities.Constant;
import java.awt.Component;
import java.util.List;
import java.util.ListIterator;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tommy
 */
public class EmployeesTableModel extends DefaultTableModel {

    /**
     * Constructor for EmployeesTableModel.
     */
    public EmployeesTableModel() {
        addColumn(Constant.EMPLOYEE_NAME);
        addColumn(Constant.EMPLOYEE_STATUS);
        addColumn(Constant.EMPLOYEE_HUNGRY);
        addColumn(Constant.EMPLOYEE_CURRENT_PROJECT);
        addColumn(Constant.EMPLOYEE_DETAILS);
        addColumn(Constant.EMPLOYEE_MANAGE);
    }

    /**
     * Get column class.
     *
     * @param columnIndex
     * @return
     */
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (getRowCount() > 0) {
            return getValueAt(0, columnIndex).getClass();
        } else {
            return Component.class;
        }
    }

    /**
     * Check if a cell is editable.
     *
     * @param rowIndex
     * @param columnIndex
     * @return
     */
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        /* If it is button cell, it is editable. */
        if (getValueAt(rowIndex, columnIndex) instanceof JButton) {
            return true;
        }

        /* Else, non-editable. */
        return false;
    }

    /**
     * Set employee records for this table.
     *
     * @param employeeList
     */
    public void setEmployeeList(List<Employee> employeeList) {
        /* Reset table. */
        setRowCount(0);

        ImageIcon icInformation = new ImageIcon(getClass().
                getResource("/devfortress/view/resources/icInformation.png")),
                icManage = new ImageIcon(getClass().
                getResource("/devfortress/view/resources/icManage.png")),
                icHappy = new ImageIcon(getClass().
                getResource("/devfortress/view/resources/icHappy.png")),
                icUnhappy = new ImageIcon(getClass().
                getResource("/devfortress/view/resources/icUnhappy.png"));
        /* Add new records. */
        for (ListIterator<Employee> iterator = employeeList.listIterator();
                iterator.hasNext();) {
            JButton detailsButton = new JButton(Constant.EMPLOYEE_DETAILS,
                    icInformation),
                    manageButton = new JButton(Constant.EMPLOYEE_MANAGE,
                    icManage);
            Employee employee = iterator.next();
            ImageIcon icon;
            if (employee.getStatus()[2]) {
                icon = icHappy;
            } else {
                icon = icUnhappy;
            }
            Project project = employee.getWorkingProject();
            if (project == null) {
                addRow(new Object[]{employee.getName(), icon,
                            employee.isHungry() ? Constant.YES : Constant.NO,
                            Constant.NA, detailsButton, manageButton});
            } else {
                addRow(new Object[]{employee.getName(), icon,
                            employee.isHungry() ? Constant.YES : Constant.NO,
                            employee.getWorkingProject().getName(),
                            detailsButton, manageButton});
            }
        }
    }
}
