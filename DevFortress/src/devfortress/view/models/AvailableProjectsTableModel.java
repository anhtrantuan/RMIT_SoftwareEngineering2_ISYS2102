/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.view.models;

import devfortress.utilities.Constant;
import devfortress.utilities.Skill;
import java.util.Iterator;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tommy
 */
public class AvailableProjectsTableModel extends DefaultTableModel {

    /**
     * Constructor for AvailableEmployeeTableModel.
     */
    public AvailableProjectsTableModel() {
        addColumn(Constant.FIELD_LABEL);
        addColumn(Constant.REQUIRED_FUNCTIONPOINT_LABEL);
    }

    /**
     * Set skill records for this table.
     *
     * @param skillList
     */
    public void setSkillList(Map<Skill, Integer> skillList) {
        /* Reset table. */
        setRowCount(0);

        /* Add new records. */
        for (Iterator<Skill> iterator = skillList.keySet().iterator();
                iterator.hasNext();) {
            Skill skill = iterator.next();
            addRow(new Object[]{skill.toString(), skillList.get(skill)});
        }
    }
}
