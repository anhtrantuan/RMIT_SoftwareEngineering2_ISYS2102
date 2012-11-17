/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.utilities;

import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author cathoanghuy
 */
public class MyTableModel extends AbstractTableModel {

    private Map content;
    private int columnNumber;
    private String[] columnName;

    public MyTableModel(Map content, int columnNumber, String[] columnName) {
        this.content = content;
        this.columnNumber = columnNumber;
        this.columnName = columnName;

    }

    public int getColumnCount() {
        return columnNumber;
    }

    public int getRowCount() {
        return content.size();
    }

    public String getColumnName(int column) {
        return columnName[column];
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return getKey(rowIndex);
        } else {
            return content.get(getKey(rowIndex));
        } // if-else

    }

    private String getKey(int a_index) {
        String retval = "";
        Enumeration<String> e = Collections.enumeration(content.entrySet());
        for (int i = 0; i < a_index + 1; i++) {
            retval = e.nextElement();
        } // for

        return retval;
    }
}
