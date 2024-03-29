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
public class ProjectTableButtonCellEditor extends DefaultCellEditor {

    private ActionListener buttonListener;
    private String buttonText;
    private Icon icon;

    /**
     * Constructor for ProjectTableButtonCellEditor.
     *
     * @param checkBox
     */
    public ProjectTableButtonCellEditor(ActionListener buttonListener) {
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
            boolean isSelected, int row, int column) {
        /* Get button component and set action listener. */
        JButton button = (JButton) value;
        button.addActionListener(buttonListener);
        buttonText = button.getText();
        icon = button.getIcon();

        /* Set button's action command. */
        String name = (String) table.getValueAt(row, 0),
                skill = (String) table.getValueAt(row, 1);
        button.setActionCommand(String.format("%s:%s", skill, name));

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
