/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.view.renderers;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author tommy
 */
public class TableButtonCellRenderer implements TableCellRenderer {

    /**
     * Get table cell renderer component and render to its specific type.
     *
     * @param table
     * @param value
     * @param isSelected
     * @param hasFocus
     * @param row
     * @param column
     * @return
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        /* Return button component. */
        return (JButton) value;
    }
}
