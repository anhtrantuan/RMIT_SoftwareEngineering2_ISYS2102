/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.view.dialogs;

import devfortress.model.employee.Employee;
import devfortress.utilities.Constant;
import devfortress.view.models.EmployeeTableModel;
import devfortress.view.models.TrainingTableModel;
import java.awt.Color;
import java.awt.event.ActionListener;

/**
 *
 * @author Sherlock
 */
public class TrainingPanel extends javax.swing.JPanel {

    private Employee employee;
    private TrainingTableModel tableModel;

    /**
     * Creates new form TrainingPanel
     */
    public TrainingPanel(Employee employee, ActionListener buttonListener) {
        initComponents();
        scpSkills.getViewport().setBackground(Color.white);
        this.employee = employee;
        tableModel = (TrainingTableModel) skillTable.getModel();
        populateData();
        closeBtn.addActionListener(buttonListener);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameLbl = new javax.swing.JLabel();
        scpSkills = new javax.swing.JScrollPane();
        skillTable = new javax.swing.JTable();
        closeBtn = new javax.swing.JButton();

        nameLbl.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        nameLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLbl.setText("jLabel1");

        skillTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scpSkills.setViewportView(skillTable);

        closeBtn.setText(Constant.CLOSE_BTN);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scpSkills, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(nameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(172, 172, 172))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scpSkills, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(closeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeBtn;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JScrollPane scpSkills;
    private javax.swing.JTable skillTable;
    // End of variables declaration//GEN-END:variables

    private void populateData() {
        nameLbl.setText(String.format("%s: %s", Constant.EMPLOYEE_NAME,
                employee.getName()));
        tableModel.setSkillList(employee,employee.getSkillList());
    }
}
