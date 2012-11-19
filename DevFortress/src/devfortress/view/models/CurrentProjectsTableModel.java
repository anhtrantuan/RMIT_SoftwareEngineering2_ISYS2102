/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.view.models;

import devfortress.model.Project;
import devfortress.utilities.Constant;
import java.util.List;
import java.util.ListIterator;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sherlock
 */
public class CurrentProjectsTableModel extends DefaultTableModel {

    public CurrentProjectsTableModel() {
        addColumn(Constant.CURRENT_PROJECT_LABEL);
        addColumn(Constant.BUTTON_INFORMATION);
        addColumn(Constant.CANCEL);
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
        /*
         * If it is button cell, it is editable.
         */
        if (getValueAt(rowIndex, columnIndex) instanceof JButton) {
            return true;
        }

        /*
         * Else, non-editable.
         */
        return false;
    }

    /**
     * Set employee records for this table.
     *
     * @param employeeList
     */
    public void setProjectList(List<Project> projectList) {

        /*
         * Reset table.
         */
        setRowCount(0);

        /*
         * Add new records.
         */
        for (ListIterator<Project> iterator = projectList.listIterator();
                iterator.hasNext();) {
            Project project = iterator.next();
            JButton informationButton = new JButton(Constant.BUTTON_INFORMATION,
                    new ImageIcon(getClass().
                    getResource("/devfortress/view/resources/icInformation.png"))),
                    cancelButton = new JButton(Constant.CANCEL,
                    new ImageIcon(getClass().
                    getResource("/devfortress/view/resources/icCancelProject.png")));
            addRow(new Object[]{project.getName(),
                        informationButton,
                        cancelButton});
        }

    }
}
