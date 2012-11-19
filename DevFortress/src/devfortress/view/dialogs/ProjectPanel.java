/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.view.dialogs;

import devfortress.model.Project;
import devfortress.utilities.Constant;
import devfortress.view.editors.TableButtonCellEditor;
import devfortress.view.models.ProjectInformationTableModel;
import devfortress.view.renderers.TableButtonCellRenderer;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Sherlock
 */
public class ProjectPanel extends javax.swing.JPanel {

    private ProjectInformationTableModel tableModel;
    private Project project;

    /**
     * Creates new form ProjectPanel.
     *
     * @param project
     */
    public ProjectPanel(Project project, ActionListener buttonListener) {
        initComponents();
        scpFields.getViewport().setBackground(Color.white);
        tableModel = (ProjectInformationTableModel) tblFields.getModel();
        this.project = project;
        tblFields.setDefaultRenderer(JButton.class,
                new TableButtonCellRenderer());
        btnClose.addActionListener(buttonListener);
        populateData();
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
        pnlProjectNameAndLevel = new javax.swing.JPanel();
        lblProjectName = new javax.swing.JLabel();
        lblProjectLevel = new javax.swing.JLabel();
        pnlMainSkill = new javax.swing.JPanel();
        lblMainSkill = new javax.swing.JLabel();
        scpFields = new javax.swing.JScrollPane();
        tblFields = new javax.swing.JTable();
        pnlTotalRequiredPoints = new javax.swing.JPanel();
        lblTotalRequiredPoints = new javax.swing.JLabel();
        pnlTotalProducedPoints = new javax.swing.JPanel();
        lblTotalProducedPoints = new javax.swing.JLabel();
        pnlRemainingPoints = new javax.swing.JPanel();
        lblRemainingPoints = new javax.swing.JLabel();
        pnlCloseButton = new javax.swing.JPanel();
        btnClose = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        pnlTitle.setBackground(new java.awt.Color(255, 255, 255));

        lblTitle.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText(Constant.PROJECT_INFORMATION);

        javax.swing.GroupLayout pnlTitleLayout = new javax.swing.GroupLayout(pnlTitle);
        pnlTitle.setLayout(pnlTitleLayout);
        pnlTitleLayout.setHorizontalGroup(
            pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
        );
        pnlTitleLayout.setVerticalGroup(
            pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTitleLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblTitle)
                .addGap(10, 10, 10))
        );

        add(pnlTitle);

        pnlProjectNameAndLevel.setBackground(new java.awt.Color(255, 255, 255));

        lblProjectName.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        lblProjectName.setText(Constant.PROJECT_NAME);

        lblProjectLevel.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        lblProjectLevel.setText(Constant.PROJECT_LEVEL);

        javax.swing.GroupLayout pnlProjectNameAndLevelLayout = new javax.swing.GroupLayout(pnlProjectNameAndLevel);
        pnlProjectNameAndLevel.setLayout(pnlProjectNameAndLevelLayout);
        pnlProjectNameAndLevelLayout.setHorizontalGroup(
            pnlProjectNameAndLevelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProjectNameAndLevelLayout.createSequentialGroup()
                .addComponent(lblProjectName, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                .addComponent(lblProjectLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlProjectNameAndLevelLayout.setVerticalGroup(
            pnlProjectNameAndLevelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProjectNameAndLevelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlProjectNameAndLevelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProjectName)
                    .addComponent(lblProjectLevel))
                .addGap(10, 10, 10))
        );

        add(pnlProjectNameAndLevel);

        pnlMainSkill.setBackground(new java.awt.Color(255, 255, 255));

        lblMainSkill.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        lblMainSkill.setText(Constant.MAIN_SKILL_LABEL);

        javax.swing.GroupLayout pnlMainSkillLayout = new javax.swing.GroupLayout(pnlMainSkill);
        pnlMainSkill.setLayout(pnlMainSkillLayout);
        pnlMainSkillLayout.setHorizontalGroup(
            pnlMainSkillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMainSkill, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
        );
        pnlMainSkillLayout.setVerticalGroup(
            pnlMainSkillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainSkillLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblMainSkill)
                .addGap(10, 10, 10))
        );

        add(pnlMainSkill);

        scpFields.setBackground(new java.awt.Color(255, 255, 255));

        tblFields.setAutoCreateRowSorter(true);
        tblFields.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        tblFields.setModel(new ProjectInformationTableModel());
        tblFields.setRowHeight(36);
        tblFields.setRowSelectionAllowed(false);
        scpFields.setViewportView(tblFields);

        add(scpFields);

        pnlTotalRequiredPoints.setBackground(new java.awt.Color(255, 255, 255));

        lblTotalRequiredPoints.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        lblTotalRequiredPoints.setText(Constant.TOTAL_REQUIRED_FUNCTIONPOINT_LABEL);

        javax.swing.GroupLayout pnlTotalRequiredPointsLayout = new javax.swing.GroupLayout(pnlTotalRequiredPoints);
        pnlTotalRequiredPoints.setLayout(pnlTotalRequiredPointsLayout);
        pnlTotalRequiredPointsLayout.setHorizontalGroup(
            pnlTotalRequiredPointsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTotalRequiredPoints, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
        );
        pnlTotalRequiredPointsLayout.setVerticalGroup(
            pnlTotalRequiredPointsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTotalRequiredPointsLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblTotalRequiredPoints)
                .addGap(10, 10, 10))
        );

        add(pnlTotalRequiredPoints);

        pnlTotalProducedPoints.setBackground(new java.awt.Color(255, 255, 255));

        lblTotalProducedPoints.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        lblTotalProducedPoints.setText(Constant.TOTAL_PRODUCED_FUNCTION_POINT);

        javax.swing.GroupLayout pnlTotalProducedPointsLayout = new javax.swing.GroupLayout(pnlTotalProducedPoints);
        pnlTotalProducedPoints.setLayout(pnlTotalProducedPointsLayout);
        pnlTotalProducedPointsLayout.setHorizontalGroup(
            pnlTotalProducedPointsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTotalProducedPoints, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
        );
        pnlTotalProducedPointsLayout.setVerticalGroup(
            pnlTotalProducedPointsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTotalProducedPointsLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblTotalProducedPoints)
                .addGap(10, 10, 10))
        );

        add(pnlTotalProducedPoints);

        pnlRemainingPoints.setBackground(new java.awt.Color(255, 255, 255));

        lblRemainingPoints.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        lblRemainingPoints.setText(Constant.PROJECT_REMAINING_POINTS);

        javax.swing.GroupLayout pnlRemainingPointsLayout = new javax.swing.GroupLayout(pnlRemainingPoints);
        pnlRemainingPoints.setLayout(pnlRemainingPointsLayout);
        pnlRemainingPointsLayout.setHorizontalGroup(
            pnlRemainingPointsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblRemainingPoints, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
        );
        pnlRemainingPointsLayout.setVerticalGroup(
            pnlRemainingPointsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRemainingPointsLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblRemainingPoints)
                .addGap(10, 10, 10))
        );

        add(pnlRemainingPoints);

        pnlCloseButton.setBackground(new java.awt.Color(255, 255, 255));
        pnlCloseButton.setMaximumSize(new java.awt.Dimension(120, 60));
        pnlCloseButton.setMinimumSize(new java.awt.Dimension(120, 60));
        pnlCloseButton.setPreferredSize(new java.awt.Dimension(120, 60));

        btnClose.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/devfortress/view/resources/icCancel.png"))); // NOI18N
        btnClose.setText(Constant.CLOSE_BTN);
        btnClose.setMaximumSize(new java.awt.Dimension(120, 40));
        btnClose.setMinimumSize(new java.awt.Dimension(120, 40));
        btnClose.setPreferredSize(new java.awt.Dimension(120, 40));

        javax.swing.GroupLayout pnlCloseButtonLayout = new javax.swing.GroupLayout(pnlCloseButton);
        pnlCloseButton.setLayout(pnlCloseButtonLayout);
        pnlCloseButtonLayout.setHorizontalGroup(
            pnlCloseButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlCloseButtonLayout.setVerticalGroup(
            pnlCloseButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCloseButtonLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        add(pnlCloseButton);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JLabel lblMainSkill;
    private javax.swing.JLabel lblProjectLevel;
    private javax.swing.JLabel lblProjectName;
    private javax.swing.JLabel lblRemainingPoints;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTotalProducedPoints;
    private javax.swing.JLabel lblTotalRequiredPoints;
    private javax.swing.JPanel pnlCloseButton;
    private javax.swing.JPanel pnlMainSkill;
    private javax.swing.JPanel pnlProjectNameAndLevel;
    private javax.swing.JPanel pnlRemainingPoints;
    private javax.swing.JPanel pnlTitle;
    private javax.swing.JPanel pnlTotalProducedPoints;
    private javax.swing.JPanel pnlTotalRequiredPoints;
    private javax.swing.JScrollPane scpFields;
    private javax.swing.JTable tblFields;
    // End of variables declaration//GEN-END:variables

    /**
     * Populate data to view.
     */
    private void populateData() {
        lblProjectName.setText(String.format("%s: %s", Constant.PROJECT_NAME,
                project.getName()));
        lblMainSkill.setText(String.format("%s: %s", Constant.MAIN_SKILL_LABEL,
                project.getMainSkill().toString()));
        lblProjectLevel.setText(String.format("%s: %d", Constant.PROJECT_LEVEL,
                project.getProjectLevel()));
        lblTotalRequiredPoints.setText(String.format("%s: %d",
                Constant.TOTAL_REQUIRED_FUNCTIONPOINT_LABEL,
                project.getTotalPoints()));
        lblTotalProducedPoints.setText(String.format("%s: %d",
                Constant.TOTAL_PRODUCED_FUNCTION_POINT,
                project.getTotalFunctionPointsDelivered()));
        lblRemainingPoints.setText(String.format("%s: %d",
                Constant.PROJECT_REMAINING_POINTS,
                project.getRemainingPoints()));
        tableModel.setProject(project);
    }

    /**
     * Set button listener for Field table.
     *
     * @param tableButtonListener
     */
    public void setTableButtonListener(ActionListener tableButtonListener) {
        tblFields.setDefaultEditor(JButton.class,
                new TableButtonCellEditor(tableButtonListener));
    }

    /**
     * Get current project.
     *
     * @return
     */
    public Project getProject() {
        return project;
    }
}
