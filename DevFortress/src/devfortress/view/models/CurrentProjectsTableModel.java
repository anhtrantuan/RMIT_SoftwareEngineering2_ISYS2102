/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.view.models;

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

        /* Reset table. */
        setRowCount(0);

        /* Add new records. */
        if (projectList.size() > 0) {
            ImageIcon icInformation = new ImageIcon(getClass().
                    getResource("../resources/icInformation.png")),
                    icCancelProject = new ImageIcon(getClass().
                    getResource("../resources/icCancelProject.png"));
            for (ListIterator<Project> iterator = projectList.listIterator();
                    iterator.hasNext();) {
                Project project = iterator.next();
                JButton informationButton = new JButton(Constant.BUTTON_INFORMATION,
                        icInformation),
                        cancelButton = new JButton(Constant.CANCEL, icCancelProject);
                addRow(new Object[]{project.getName(), informationButton, cancelButton});
            }
        }

    }
}
