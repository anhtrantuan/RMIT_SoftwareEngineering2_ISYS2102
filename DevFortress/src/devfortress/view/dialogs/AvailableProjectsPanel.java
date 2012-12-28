/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.view.dialogs;

import devfortress.model.project.Project;
import devfortress.utilities.Constant;
import devfortress.view.models.ProjectTableModel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.List;

/**
 *
 * @author Sherlock
 */
public class AvailableProjectsPanel extends javax.swing.JPanel {

    private int index;
    private List<Project> projectList;
    private Project currentProject;
    private ProjectTableModel tableModel;
    private DecimalFormat decimalFormatter;

    /**
     * Creates new form AvailableProjectsPanel.
     *
     * @param availableProjectList
     * @param buttonListener
     */
    public AvailableProjectsPanel(List<Project> availableProjectList,
            ActionListener buttonListener) {
        initComponents();
        scpSkills.getViewport().setBackground(Color.white);
        tableModel = (ProjectTableModel) tblSkills.getModel();
        index = 0;
        projectList = availableProjectList;
        decimalFormatter = new DecimalFormat("$#,##0.0#");
        populateData();
        btnAccept.addActionListener(buttonListener);
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
        pnlNameAndLevel = new javax.swing.JPanel();
        lblProjectLevel = new javax.swing.JLabel();
        lblProjectName = new javax.swing.JLabel();
        pnlMainSkill = new javax.swing.JPanel();
        lblMainSkill = new javax.swing.JLabel();
        scpSkills = new javax.swing.JScrollPane();
        tblSkills = new javax.swing.JTable();
        pnlDue = new javax.swing.JPanel();
        lblDue = new javax.swing.JLabel();
        pnlPay = new javax.swing.JPanel();
        lblPay = new javax.swing.JLabel();
        pnlPreviousAndNext = new javax.swing.JPanel();
        btnNext = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        pnlAcceptAndCancel = new javax.swing.JPanel();
        btnAccept = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setMaximumSize(new java.awt.Dimension(520, 560));
        setMinimumSize(new java.awt.Dimension(520, 560));
        setPreferredSize(new java.awt.Dimension(520, 560));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        pnlTitle.setBackground(new java.awt.Color(255, 255, 255));

        lblTitle.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText(Constant.AVAILABLE_PROJECTS_LABEL);

        javax.swing.GroupLayout pnlTitleLayout = new javax.swing.GroupLayout(pnlTitle);
        pnlTitle.setLayout(pnlTitleLayout);
        pnlTitleLayout.setHorizontalGroup(
            pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        );
        pnlTitleLayout.setVerticalGroup(
            pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTitleLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblTitle)
                .addGap(10, 10, 10))
        );

        add(pnlTitle);

        pnlNameAndLevel.setBackground(new java.awt.Color(255, 255, 255));

        lblProjectLevel.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblProjectLevel.setText("Project Level ");

        lblProjectName.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblProjectName.setText("Project Name");

        javax.swing.GroupLayout pnlNameAndLevelLayout = new javax.swing.GroupLayout(pnlNameAndLevel);
        pnlNameAndLevel.setLayout(pnlNameAndLevelLayout);
        pnlNameAndLevelLayout.setHorizontalGroup(
            pnlNameAndLevelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNameAndLevelLayout.createSequentialGroup()
                .addComponent(lblProjectName, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(lblProjectLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlNameAndLevelLayout.setVerticalGroup(
            pnlNameAndLevelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNameAndLevelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlNameAndLevelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProjectName)
                    .addComponent(lblProjectLevel))
                .addGap(10, 10, 10))
        );

        add(pnlNameAndLevel);

        pnlMainSkill.setBackground(new java.awt.Color(255, 255, 255));

        lblMainSkill.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblMainSkill.setText(Constant.MAIN_SKILL_LABEL);

        javax.swing.GroupLayout pnlMainSkillLayout = new javax.swing.GroupLayout(pnlMainSkill);
        pnlMainSkill.setLayout(pnlMainSkillLayout);
        pnlMainSkillLayout.setHorizontalGroup(
            pnlMainSkillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMainSkill, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        );
        pnlMainSkillLayout.setVerticalGroup(
            pnlMainSkillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainSkillLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblMainSkill)
                .addGap(10, 10, 10))
        );

        add(pnlMainSkill);

        tblSkills.setAutoCreateRowSorter(true);
        tblSkills.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tblSkills.setModel(new devfortress.view.models.ProjectTableModel());
        tblSkills.setRowHeight(36);
        tblSkills.setRowSelectionAllowed(false);
        scpSkills.setViewportView(tblSkills);

        add(scpSkills);

        pnlDue.setBackground(new java.awt.Color(255, 255, 255));

        lblDue.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblDue.setText(Constant.PROJECT_DUE);

        javax.swing.GroupLayout pnlDueLayout = new javax.swing.GroupLayout(pnlDue);
        pnlDue.setLayout(pnlDueLayout);
        pnlDueLayout.setHorizontalGroup(
            pnlDueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDue, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        );
        pnlDueLayout.setVerticalGroup(
            pnlDueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDueLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblDue)
                .addGap(10, 10, 10))
        );

        lblDue.getAccessibleContext().setAccessibleName("dueLabel");

        add(pnlDue);

        pnlPay.setBackground(new java.awt.Color(255, 255, 255));

        lblPay.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblPay.setText(Constant.PROJECT_PAY);

        javax.swing.GroupLayout pnlPayLayout = new javax.swing.GroupLayout(pnlPay);
        pnlPay.setLayout(pnlPayLayout);
        pnlPayLayout.setHorizontalGroup(
            pnlPayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblPay, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        );
        pnlPayLayout.setVerticalGroup(
            pnlPayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPayLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblPay)
                .addGap(10, 10, 10))
        );

        add(pnlPay);

        pnlPreviousAndNext.setBackground(new java.awt.Color(255, 255, 255));
        pnlPreviousAndNext.setMaximumSize(new java.awt.Dimension(130, 60));
        pnlPreviousAndNext.setMinimumSize(new java.awt.Dimension(130, 60));
        pnlPreviousAndNext.setName(""); // NOI18N
        pnlPreviousAndNext.setPreferredSize(new java.awt.Dimension(130, 60));

        btnNext.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/devfortress/view/resources/icNext.png"))); // NOI18N
        btnNext.setMaximumSize(new java.awt.Dimension(40, 40));
        btnNext.setMinimumSize(new java.awt.Dimension(40, 40));
        btnNext.setPreferredSize(new java.awt.Dimension(40, 40));
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnPrevious.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        btnPrevious.setIcon(new javax.swing.ImageIcon(getClass().getResource("/devfortress/view/resources/icPrevious.png"))); // NOI18N
        btnPrevious.setMaximumSize(new java.awt.Dimension(40, 40));
        btnPrevious.setMinimumSize(new java.awt.Dimension(40, 40));
        btnPrevious.setPreferredSize(new java.awt.Dimension(40, 40));
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPreviousAndNextLayout = new javax.swing.GroupLayout(pnlPreviousAndNext);
        pnlPreviousAndNext.setLayout(pnlPreviousAndNextLayout);
        pnlPreviousAndNextLayout.setHorizontalGroup(
            pnlPreviousAndNextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPreviousAndNextLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        pnlPreviousAndNextLayout.setVerticalGroup(
            pnlPreviousAndNextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPreviousAndNextLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlPreviousAndNextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPrevious, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        add(pnlPreviousAndNext);

        pnlAcceptAndCancel.setBackground(new java.awt.Color(255, 255, 255));

        btnAccept.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnAccept.setIcon(new javax.swing.ImageIcon(getClass().getResource("/devfortress/view/resources/icContract.png"))); // NOI18N
        btnAccept.setText(Constant.BUTTON_ACCEPT);
        btnAccept.setEnabled(false);
        btnAccept.setMaximumSize(new java.awt.Dimension(120, 40));
        btnAccept.setMinimumSize(new java.awt.Dimension(120, 40));
        btnAccept.setPreferredSize(new java.awt.Dimension(120, 40));

        btnCancel.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/devfortress/view/resources/icCancel.png"))); // NOI18N
        btnCancel.setText(Constant.CANCEL);
        btnCancel.setMaximumSize(new java.awt.Dimension(120, 40));
        btnCancel.setMinimumSize(new java.awt.Dimension(120, 40));
        btnCancel.setPreferredSize(new java.awt.Dimension(120, 40));

        javax.swing.GroupLayout pnlAcceptAndCancelLayout = new javax.swing.GroupLayout(pnlAcceptAndCancel);
        pnlAcceptAndCancel.setLayout(pnlAcceptAndCancelLayout);
        pnlAcceptAndCancelLayout.setHorizontalGroup(
            pnlAcceptAndCancelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAcceptAndCancelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAccept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 216, Short.MAX_VALUE)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlAcceptAndCancelLayout.setVerticalGroup(
            pnlAcceptAndCancelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAcceptAndCancelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlAcceptAndCancelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAccept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        add(pnlAcceptAndCancel);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        if (index > 0) {
            index--;
            populateData();
        }
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        if (index < projectList.size() - 1) {
            index++;
            populateData();
        }
    }//GEN-LAST:event_btnNextActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccept;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JLabel lblDue;
    private javax.swing.JLabel lblMainSkill;
    private javax.swing.JLabel lblPay;
    private javax.swing.JLabel lblProjectLevel;
    private javax.swing.JLabel lblProjectName;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlAcceptAndCancel;
    private javax.swing.JPanel pnlDue;
    private javax.swing.JPanel pnlMainSkill;
    private javax.swing.JPanel pnlNameAndLevel;
    private javax.swing.JPanel pnlPay;
    private javax.swing.JPanel pnlPreviousAndNext;
    private javax.swing.JPanel pnlTitle;
    private javax.swing.JScrollPane scpSkills;
    private javax.swing.JTable tblSkills;
    // End of variables declaration//GEN-END:variables

    /**
     * Populate data to view.
     */
    private void populateData() {
        if (projectList.size() > 0) {
            currentProject = projectList.get(index);
            lblProjectName.setText(String.format("%s: %s", Constant.PROJECT_NAME,
                    projectList.get(index).getName()));
            lblProjectLevel.setText(String.format("%s: %s", Constant.PROJECT_LEVEL,
                    projectList.get(index).getProjectLevel()));
            lblMainSkill.setText(String.format("%s: %s", Constant.MAIN_SKILL_LABEL,
                    projectList.get(index).getMainSkill().toString()));
            lblDue.setText(String.format("%s: %d Month(s)", Constant.PROJECT_DUE,
                    projectList.get(index).getProjectTime().getMonths()));
            lblPay.setText(String.format("%s: %s", Constant.PROJECT_PAY,
                    decimalFormatter.format(projectList.get(index).getPayment())));
            tableModel.setSkillList(currentProject.getOriginalSkillRequirementMap());
            btnAccept.setActionCommand(String.valueOf(index));
            btnAccept.setEnabled(true);
        } else {
            lblProjectName.setText(String.format("%s: %s", Constant.PROJECT_NAME,
                    Constant.NA));
            lblProjectLevel.setText(String.format("%s: %s", Constant.PROJECT_LEVEL,
                    Constant.NA));
            lblMainSkill.setText(String.format("%s: %s", Constant.MAIN_SKILL_LABEL,
                    Constant.NA));
            lblDue.setText(String.format("%s: %s", Constant.PROJECT_DUE,
                    Constant.NA));
            lblPay.setText(String.format("%s: %s", Constant.PROJECT_PAY,
                    Constant.NA));
            tableModel.setSkillList(null);
            btnAccept.setEnabled(false);
        }

        /* Update buttons' availability. */
        if (index > 0) {
            btnPrevious.setEnabled(true);
        } else {
            btnPrevious.setEnabled(false);
        }
        if (projectList.size() < 2 || index == projectList.size() - 1) {
            btnNext.setEnabled(false);
        } else {
            btnNext.setEnabled(true);
        }
    }

    /**
     * Get selected project.
     *
     * @return
     */
    public Project getSelectedProject() {
        return currentProject;
    }
}
