/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.view.dialogs;

import devfortress.model.Project;
import devfortress.utilities.Constant;
import devfortress.view.editors.TableButtonCellEditor;
import devfortress.view.models.CurrentProjectsTableModel;
import devfortress.view.renderers.TableButtonCellRenderer;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;

/**
 *
 * @author Sherlock
 */
public class CurrentProjectsPanel extends javax.swing.JPanel {

    private CurrentProjectsTableModel tableModel;

    /**
     * Creates new form CurrentProjectsPanel.
     *
     * @param projectList
     * @param buttonListener
     */
    public CurrentProjectsPanel(List<Project> projectList,
            ActionListener buttonListener) {
        initComponents();
        scpProject.getViewport().setBackground(Color.white);
        tableModel = (CurrentProjectsTableModel) tblProjects.getModel();
        tableModel.setProjectList(projectList);
        btnClose.addActionListener(buttonListener);
        tblProjects.setDefaultRenderer(JButton.class,
                new TableButtonCellRenderer());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        scpProject = new javax.swing.JScrollPane();
        tblProjects = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnClose = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setMaximumSize(new java.awt.Dimension(520, 520));
        setMinimumSize(new java.awt.Dimension(520, 520));
        setPreferredSize(new java.awt.Dimension(520, 520));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblTitle.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText(Constant.CURRENT_PROJECT_LABEL);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblTitle)
                .addGap(10, 10, 10))
        );

        add(jPanel1);

        scpProject.setBackground(new java.awt.Color(255, 255, 255));

        tblProjects.setAutoCreateRowSorter(true);
        tblProjects.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        tblProjects.setModel(new devfortress.view.models.CurrentProjectsTableModel());
        tblProjects.setRowHeight(36);
        tblProjects.setRowSelectionAllowed(false);
        scpProject.setViewportView(tblProjects);

        add(scpProject);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(120, 60));
        jPanel2.setMinimumSize(new java.awt.Dimension(120, 60));
        jPanel2.setPreferredSize(new java.awt.Dimension(120, 60));

        btnClose.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/devfortress/view/resources/icCancel.png"))); // NOI18N
        btnClose.setText(Constant.CLOSE_BTN);
        btnClose.setMaximumSize(new java.awt.Dimension(120, 40));
        btnClose.setMinimumSize(new java.awt.Dimension(120, 40));
        btnClose.setPreferredSize(new java.awt.Dimension(120, 40));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        add(jPanel2);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JScrollPane scpProject;
    private javax.swing.JTable tblProjects;
    // End of variables declaration//GEN-END:variables

    /**
     * Set button cell listener for Project table.
     *
     * @param tableButtonListener
     */
    public void setTableButtonListener(ActionListener tableButtonListener) {
        tblProjects.setDefaultEditor(JButton.class,
                new TableButtonCellEditor(tableButtonListener));
    }

    /**
     * Set project list.
     *
     * @param projectList
     */
    public void setProjectList(List<Project> projectList) {
        tableModel.setProjectList(projectList);
    }
}
