/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.view.editors;

import devfortress.utilities.Constant;
import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 *
 * @author tommy
 */
public class TableButtonCellEditor extends DefaultCellEditor {

    private ActionListener buttonListener;
    private String buttonText;
    private Icon icon;

    /**
     * Constructor for TableButtonCellEditor.
     *
     * @param checkBox
     */
    public TableButtonCellEditor(ActionListener buttonListener) {
        super(new JCheckBox());
        this.buttonListener = buttonListener;
    }

    /**
     * Get table cell editor component rendered to button type.
     *
     * @param table
     * @param value
     * @param isSelected
     * @param row
     * @param column
     * @return
     */
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected,
            int row, int column) {
        /* Get button component and set action listener. */
        JButton button = (JButton) value;
        button.addActionListener(buttonListener);
        buttonText = button.getText();
        icon = button.getIcon();

        /* Set employee's name or row index as button's action command. */
        String name = (String) table.getValueAt(row, 0);
        if (name.equals(Constant.NA)) {
            button.setActionCommand(String.format("%d",
                    table.convertRowIndexToModel(row)));
        } else {
            button.setActionCommand(name);
        }

        /* Return button component. */
        return button;
    }

    /**
     * Get cell editor value: button with specified text.
     *
     * @return
     */
    @Override
    public Object getCellEditorValue() {
        return new JButton(buttonText, icon);
    }
}
