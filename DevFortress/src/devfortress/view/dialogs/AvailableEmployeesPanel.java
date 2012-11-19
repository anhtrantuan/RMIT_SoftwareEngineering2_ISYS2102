/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.view.dialogs;

import devfortress.model.Employee;
import devfortress.utilities.Constant;
import devfortress.view.models.EmployeeTableModel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;

/**
 *
 * @author cathoanghuy
 */
public class AvailableEmployeesPanel extends javax.swing.JPanel {

    private int index;
    private List<Employee> employeeList;
    private Employee currentEmployee;
    private EmployeeTableModel tableModel;

    /**
     * Creates new form AvaiableEmployee,
     *
     * @param employees
     * @param buttonListener
     */
    public AvailableEmployeesPanel(List<Employee> employees,
            ActionListener buttonListener) {
        initComponents();
        scpEmployees.getViewport().setBackground(Color.white);
        tableModel = (EmployeeTableModel) tblEmployees.getModel();
        index = 0;
        employeeList = employees;
        populateData();
        btnHire.addActionListener(buttonListener);
        btnCancel.addActionListener(buttonListener);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTitle = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        pnlNameAndMainSkill = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        lblMainSkill = new javax.swing.JLabel();
        scpEmployees = new javax.swing.JScrollPane();
        tblEmployees = new javax.swing.JTable();
        pnlSalary = new javax.swing.JPanel();
        lblSalary = new javax.swing.JLabel();
        pnlPreviousNext = new javax.swing.JPanel();
        btnPrevious = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        pnlAcceptCancel = new javax.swing.JPanel();
        btnCancel = new javax.swing.JButton();
        btnHire = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        setMaximumSize(new java.awt.Dimension(520, 520));
        setMinimumSize(new java.awt.Dimension(520, 520));
        setPreferredSize(new java.awt.Dimension(520, 520));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        pnlTitle.setBackground(new java.awt.Color(255, 255, 255));

        lblTitle.setBackground(new java.awt.Color(255, 255, 255));
        lblTitle.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText(Constant.AVAILABLE_EMPLOYEES);

        javax.swing.GroupLayout pnlTitleLayout = new javax.swing.GroupLayout(pnlTitle);
        pnlTitle.setLayout(pnlTitleLayout);
        pnlTitleLayout.setHorizontalGroup(
            pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        );
        pnlTitleLayout.setVerticalGroup(
            pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTitleLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        lblTitle.getAccessibleContext().setAccessibleName("availableEmployee");

        add(pnlTitle);

        pnlNameAndMainSkill.setBackground(new java.awt.Color(255, 255, 255));

        lblName.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        lblName.setText(Constant.EMPLOYEE_NAME);

        lblMainSkill.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        lblMainSkill.setText(Constant.MAIN_SKILL_LABEL);

        javax.swing.GroupLayout pnlNameAndMainSkillLayout = new javax.swing.GroupLayout(pnlNameAndMainSkill);
        pnlNameAndMainSkill.setLayout(pnlNameAndMainSkillLayout);
        pnlNameAndMainSkillLayout.setHorizontalGroup(
            pnlNameAndMainSkillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNameAndMainSkillLayout.createSequentialGroup()
                .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(lblMainSkill, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlNameAndMainSkillLayout.setVerticalGroup(
            pnlNameAndMainSkillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNameAndMainSkillLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlNameAndMainSkillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(lblMainSkill))
                .addGap(10, 10, 10))
        );

        add(pnlNameAndMainSkill);

        scpEmployees.setBackground(new java.awt.Color(255, 255, 255));
        scpEmployees.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        tblEmployees.setAutoCreateRowSorter(true);
        tblEmployees.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        tblEmployees.setModel(new devfortress.view.models.EmployeeTableModel());
        tblEmployees.setRowHeight(30);
        tblEmployees.setRowSelectionAllowed(false);
        scpEmployees.setViewportView(tblEmployees);

        add(scpEmployees);

        pnlSalary.setBackground(new java.awt.Color(255, 255, 255));

        lblSalary.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        lblSalary.setText(Constant.SALARY_LABEL);

        javax.swing.GroupLayout pnlSalaryLayout = new javax.swing.GroupLayout(pnlSalary);
        pnlSalary.setLayout(pnlSalaryLayout);
        pnlSalaryLayout.setHorizontalGroup(
            pnlSalaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblSalary, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        );
        pnlSalaryLayout.setVerticalGroup(
            pnlSalaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSalaryLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblSalary)
                .addGap(10, 10, 10))
        );

        add(pnlSalary);

        pnlPreviousNext.setBackground(new java.awt.Color(255, 255, 255));
        pnlPreviousNext.setMaximumSize(new java.awt.Dimension(225, 50));
        pnlPreviousNext.setMinimumSize(new java.awt.Dimension(225, 50));
        pnlPreviousNext.setPreferredSize(new java.awt.Dimension(225, 50));

        btnPrevious.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        btnPrevious.setText(Constant.PREVIOUS_BTN);
        btnPrevious.setMaximumSize(new java.awt.Dimension(100, 30));
        btnPrevious.setMinimumSize(new java.awt.Dimension(100, 30));
        btnPrevious.setPreferredSize(new java.awt.Dimension(100, 30));
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        btnNext.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        btnNext.setText(Constant.NEXT_BTN);
        btnNext.setMaximumSize(new java.awt.Dimension(100, 30));
        btnNext.setMinimumSize(new java.awt.Dimension(100, 30));
        btnNext.setPreferredSize(new java.awt.Dimension(100, 30));
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPreviousNextLayout = new javax.swing.GroupLayout(pnlPreviousNext);
        pnlPreviousNext.setLayout(pnlPreviousNextLayout);
        pnlPreviousNextLayout.setHorizontalGroup(
            pnlPreviousNextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPreviousNextLayout.createSequentialGroup()
                .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlPreviousNextLayout.setVerticalGroup(
            pnlPreviousNextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPreviousNextLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlPreviousNextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        add(pnlPreviousNext);

        pnlAcceptCancel.setBackground(new java.awt.Color(255, 255, 255));

        btnCancel.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        btnCancel.setText(Constant.CANCEL);
        btnCancel.setMaximumSize(new java.awt.Dimension(120, 40));
        btnCancel.setMinimumSize(new java.awt.Dimension(120, 40));
        btnCancel.setPreferredSize(new java.awt.Dimension(120, 40));

        btnHire.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        btnHire.setText(Constant.HIRE);
        btnHire.setMaximumSize(new java.awt.Dimension(120, 40));
        btnHire.setMinimumSize(new java.awt.Dimension(120, 40));
        btnHire.setPreferredSize(new java.awt.Dimension(120, 40));

        javax.swing.GroupLayout pnlAcceptCancelLayout = new javax.swing.GroupLayout(pnlAcceptCancel);
        pnlAcceptCancel.setLayout(pnlAcceptCancelLayout);
        pnlAcceptCancelLayout.setHorizontalGroup(
            pnlAcceptCancelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAcceptCancelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 216, Short.MAX_VALUE)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlAcceptCancelLayout.setVerticalGroup(
            pnlAcceptCancelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAcceptCancelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAcceptCancelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        add(pnlAcceptCancel);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        if (index > 0) {
            index--;
            populateData();
        }
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        if (index < employeeList.size() - 1) {
            index++;
            populateData();
        }
    }//GEN-LAST:event_btnNextActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnHire;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JLabel lblMainSkill;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblSalary;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlAcceptCancel;
    private javax.swing.JPanel pnlNameAndMainSkill;
    private javax.swing.JPanel pnlPreviousNext;
    private javax.swing.JPanel pnlSalary;
    private javax.swing.JPanel pnlTitle;
    private javax.swing.JScrollPane scpEmployees;
    private javax.swing.JTable tblEmployees;
    // End of variables declaration//GEN-END:variables

    /**
     * Populate data to view.
     */
    private void populateData() {
        currentEmployee = employeeList.get(index);
        lblName.setText(String.format("%s: %s", Constant.EMPLOYEE_NAME,
                currentEmployee.getName()));
        lblMainSkill.setText(String.format("%s: %s", Constant.MAIN_SKILL_LABEL,
                currentEmployee.getMainSkill().toString()));
        lblSalary.setText(String.format("%s: $%.2f", Constant.SALARY_LABEL,
                currentEmployee.getSalary()));
        tableModel.setSkillList(currentEmployee.getSkillList());
        btnHire.setActionCommand(String.valueOf(index));
    }
}
