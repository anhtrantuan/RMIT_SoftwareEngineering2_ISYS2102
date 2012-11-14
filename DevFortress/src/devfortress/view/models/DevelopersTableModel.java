/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.view.models;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tommy
 */
public class DevelopersTableModel extends DefaultTableModel {

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
}
