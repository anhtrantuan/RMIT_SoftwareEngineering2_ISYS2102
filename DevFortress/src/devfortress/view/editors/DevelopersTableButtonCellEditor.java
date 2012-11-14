/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.view.editors;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 *
 * @author tommy
 */
public class DevelopersTableButtonCellEditor extends DefaultCellEditor {

    /* Declare button text. */
    private String buttonText;

    /**
     * Constructor for DevelopersTableButtonCellEditor.
     *
     * @param checkBox
     */
    public DevelopersTableButtonCellEditor(JCheckBox checkBox) {
        super(checkBox);
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
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        buttonText = button.getText();

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
        return new JButton(buttonText);
    }
}
