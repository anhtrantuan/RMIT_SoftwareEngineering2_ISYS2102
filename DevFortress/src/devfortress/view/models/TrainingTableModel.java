/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.view.models;

import devfortress.model.employee.Employee;
import devfortress.utilities.Constant;
import devfortress.utilities.Skill;
import java.awt.Component;
import java.util.Iterator;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sherlock
 */
public class TrainingTableModel extends DefaultTableModel {

    public TrainingTableModel() {
        addColumn(Constant.SKILL_LABEL);
        addColumn(Constant.SKILL_LVL_LABEL);
        addColumn(Constant.TRAINING_FEE);
        addColumn(Constant.TRAIN_BTN);
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
     * Set employee for this table.
     *
     * @param e
     */
    public void setEmployee(Employee e) {
        /* Reset table. */
        setRowCount(0);

        ImageIcon icTrain = new ImageIcon(getClass().
                getResource("/devfortress/view/resources/icTrain.png"));

        /* Add new records. */
        if (e.getSkillList() != null) {
            for (Iterator<Skill> iterator = e.getSkillList().keySet().iterator();
                    iterator.hasNext();) {
                Skill skill = iterator.next();
                JButton button = new JButton(Constant.TRAIN_BTN, icTrain);
                addRow(new Object[]{skill.toString(), e.getSkillList().get(skill),
                            e.getTrainingFee(skill), button});
            }
        }
    }
}
