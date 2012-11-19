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
public class ProjectInformationTableModel extends DefaultTableModel {

    /**
     * Constructor for ProjectInformationTableModel.
     */
    public ProjectInformationTableModel() {
        addColumn(Constant.EMPLOYEE_NAME);
        addColumn(Constant.FIELD_LABEL);
        addColumn(Constant.PRODUCED_FUNCTION_POINT);
        addColumn(Constant.REQUIRED_FUNCTION_POINT_LABEL);
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
        Map<Skill, Employee> skillEmployeeMap = project.getSkill_employeeMap();
        Map<Skill, Integer> skillPointMap = project.getSkillRequirementMap();
        Map<Skill, Integer> originalSkillPointMap =
                project.getOriginalSkillRequirementMap();
        /*
         * Reset table.
         */
        setRowCount(0);

        /*
         * Add new records.
         */
        for (Iterator<Skill> iterator = originalSkillPointMap.keySet().iterator();
                iterator.hasNext();) {
            Skill skill = iterator.next();
            Employee employee = skillEmployeeMap.get(skill);
            if (employee == null) {
                addRow(new Object[]{"N/A", skill.toString(),
                            skillPointMap.get(skill).intValue(),
                            originalSkillPointMap.get(skill),
                            new JButton(Constant.ASSIGN)});
            } else {
                addRow(new Object[]{skillEmployeeMap.get(skill).getName(),
                            skill.toString(),
                            skillPointMap.get(skill).intValue(),
                            originalSkillPointMap.get(skill),
                            new JButton(Constant.ASSIGN)});
            }
        }

    }
}
