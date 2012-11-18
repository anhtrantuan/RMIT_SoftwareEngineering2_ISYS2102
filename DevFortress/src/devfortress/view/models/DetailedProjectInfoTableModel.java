/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.view.models;

import devfortress.model.Employee;
import devfortress.model.Project;
import devfortress.utilities.Constant;
import devfortress.utilities.Skill;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sherlock
 */
public class DetailedProjectInfoTableModel extends DefaultTableModel {

    public DetailedProjectInfoTableModel() {
        addColumn(Constant.EMPLOYEE_NAME);
        addColumn(Constant.FIELD_LABEL);
        addColumn(Constant.PRODUCED_FUNCTION_POINT);
        addColumn(Constant.REQUIRED_FUNCTIONPOINT_LABEL);
        addColumn(Constant.ASSIGN);
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
    public void setProject(Project project) {
        Map<Skill, Employee> skill_dev_map = project.getSkill_employeeMap();
        Map<Skill, Integer> skill_point_map = project.getSkillRequirementMap();
        Map<Skill, Integer> original_skill_point_map =
                project.getOriginalSkillRequirementMap();
        /*
         * Reset table.
         */
        setRowCount(0);

        /*
         * Add new records.
         */
        for (Iterator<Skill> fieldSetIterator = skill_dev_map.keySet().iterator();
                fieldSetIterator.hasNext();) {
            Skill skill = fieldSetIterator.next();
            String devName = skill_dev_map.get(skill).getName();
            int producedPoint = skill_point_map.get(skill);
            int requiredPoint = original_skill_point_map.get(skill);
            addRow(new Object[]{devName, skill, producedPoint, requiredPoint,
                        new JButton(Constant.ASSIGN)});
        }

    }
}
