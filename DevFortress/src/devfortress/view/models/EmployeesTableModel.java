/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.view.models;

import devfortress.model.Employee;
import devfortress.utilities.Constant;
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
        return getValueAt(0, columnIndex).getClass();
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

        /* Add new records. */
        for (ListIterator<Employee> iterator = employeeList.listIterator();
                iterator.hasNext();) {
            JButton detailsButton = new JButton(Constant.EMPLOYEE_DETAILS,
                    new ImageIcon(getClass().
                    getResource("/devfortress/view/resources/icInformation.png"))),
                    manageButton = new JButton(Constant.EMPLOYEE_MANAGE,
                    new ImageIcon(getClass().
                    getResource("/devfortress/view/resources/icManage.png")));
            Employee employee = iterator.next();
            ImageIcon icon;
            if (employee.getStatus()[2]) {
                icon = new ImageIcon(getClass().
                        getResource("/devfortress/view/resources/icHappy.png"));
            } else {
                icon = new ImageIcon(getClass().
                        getResource("/devfortress/view/resources/icUnhappy.png"));
            }
            addRow(new Object[]{employee.getName(), icon, "Project 1",
                        detailsButton, manageButton});
        }
    }
}
