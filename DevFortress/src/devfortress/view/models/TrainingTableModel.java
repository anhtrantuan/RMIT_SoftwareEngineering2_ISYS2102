/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.view.models;

import devfortress.model.employee.Employee;
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
public class TrainingTableModel extends DefaultTableModel{
    public TrainingTableModel() {
        addColumn(Constant.SKILL_LABEL);
        addColumn(Constant.SKILL_LVL_LABEL);
        addColumn(Constant.TRAINING_FEE);
        addColumn(Constant.TRAIN_BTN);
        addColumn(Constant.UNTRAIN_BTN);
    }

    /**
     * Set skill records for this table.
     *
     * @param skillList
     */
    public void setSkillList(Employee e,Map<Skill, Integer> skillList) {
        /* Reset table. */
        setRowCount(0);

        /* Add new records. */
        if (skillList != null) {
            for (Iterator<Skill> iterator = skillList.keySet().iterator();
                    iterator.hasNext();) {
                JButton trainBtn = new JButton(Constant.TRAIN_BTN),
                        untrainBtn = new JButton(Constant.UNTRAIN_BTN);
                Skill skill = iterator.next();
                addRow(new Object[]{skill.toString(), skillList.get(skill),e.getTrainingFee(skill),trainBtn,untrainBtn});
            }
        }
    }
}
