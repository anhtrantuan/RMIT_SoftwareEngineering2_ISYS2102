/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.view.dialogs;

import devfortress.utilities.Constant;
import java.awt.event.ActionListener;

/**
 *
 * @author Sherlock
 */
public class SystemPanel extends javax.swing.JPanel {

    /**
     * Creates new form SystemPanel
     */
    public SystemPanel(ActionListener buttonListener) {
        initComponents();
        btnContract.addActionListener(buttonListener);
        btnHire.addActionListener(buttonListener);
        btnClose.addActionListener(buttonListener);
        btnEmployeeList.addActionListener(buttonListener);
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
        pnlContract = new javax.swing.JPanel();
        btnContract = new javax.swing.JButton();
        pnlHire = new javax.swing.JPanel();
        btnHire = new javax.swing.JButton();
        allEmployeePnl = new javax.swing.JPanel();
        btnEmployeeList = new javax.swing.JButton();
        pnlCloseButton = new javax.swing.JPanel();
        btnClose = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setMaximumSize(new java.awt.Dimension(300, 450));
        setMinimumSize(new java.awt.Dimension(300, 450));
        setPreferredSize(new java.awt.Dimension(300, 450));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        pnlTitle.setBackground(new java.awt.Color(255, 255, 255));

        lblTitle.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText(Constant.BUTTON_SYSTEM);

        javax.swing.GroupLayout pnlTitleLayout = new javax.swing.GroupLayout(pnlTitle);
        pnlTitle.setLayout(pnlTitleLayout);
        pnlTitleLayout.setHorizontalGroup(
            pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
        );
        pnlTitleLayout.setVerticalGroup(
            pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTitleLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblTitle)
                .addGap(10, 10, 10))
        );

        add(pnlTitle);

        pnlContract.setBackground(new java.awt.Color(255, 255, 255));
        pnlContract.setMaximumSize(new java.awt.Dimension(240, 80));
        pnlContract.setMinimumSize(new java.awt.Dimension(240, 80));
        pnlContract.setPreferredSize(new java.awt.Dimension(240, 80));

        btnContract.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        btnContract.setIcon(new javax.swing.ImageIcon(getClass().getResource("/devfortress/view/resources/icContract.png"))); // NOI18N
        btnContract.setText(Constant.BUTTON_CONTRACT);
        btnContract.setMaximumSize(new java.awt.Dimension(240, 60));
        btnContract.setMinimumSize(new java.awt.Dimension(240, 60));
        btnContract.setPreferredSize(new java.awt.Dimension(240, 60));

        javax.swing.GroupLayout pnlContractLayout = new javax.swing.GroupLayout(pnlContract);
        pnlContract.setLayout(pnlContractLayout);
        pnlContractLayout.setHorizontalGroup(
            pnlContractLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContractLayout.createSequentialGroup()
                .addComponent(btnContract, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlContractLayout.setVerticalGroup(
            pnlContractLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContractLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnContract, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        add(pnlContract);

        pnlHire.setBackground(new java.awt.Color(255, 255, 255));
        pnlHire.setMaximumSize(new java.awt.Dimension(240, 80));
        pnlHire.setMinimumSize(new java.awt.Dimension(240, 80));
        pnlHire.setPreferredSize(new java.awt.Dimension(240, 80));

        btnHire.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        btnHire.setIcon(new javax.swing.ImageIcon(getClass().getResource("/devfortress/view/resources/icHire.png"))); // NOI18N
        btnHire.setText(Constant.BUTTON_HIRE);
        btnHire.setMaximumSize(new java.awt.Dimension(240, 60));
        btnHire.setMinimumSize(new java.awt.Dimension(240, 60));
        btnHire.setPreferredSize(new java.awt.Dimension(240, 60));
        btnHire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHireActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlHireLayout = new javax.swing.GroupLayout(pnlHire);
        pnlHire.setLayout(pnlHireLayout);
        pnlHireLayout.setHorizontalGroup(
            pnlHireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHireLayout.createSequentialGroup()
                .addComponent(btnHire, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlHireLayout.setVerticalGroup(
            pnlHireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHireLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(btnHire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        add(pnlHire);
        allEmployeePnl.setBackground(new java.awt.Color(255, 255, 255));
        allEmployeePnl.setMaximumSize(new java.awt.Dimension(240, 80));
        allEmployeePnl.setMinimumSize(new java.awt.Dimension(240, 80));
        allEmployeePnl.setPreferredSize(new java.awt.Dimension(240, 80));
        btnEmployeeList.setText(Constant.EMPLOYEE_LIST_BTN);

        javax.swing.GroupLayout allEmployeePnlLayout = new javax.swing.GroupLayout(allEmployeePnl);
        allEmployeePnl.setLayout(allEmployeePnlLayout);
        allEmployeePnlLayout.setHorizontalGroup(
            allEmployeePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEmployeeList, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
        );
        allEmployeePnlLayout.setVerticalGroup(
            allEmployeePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(allEmployeePnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEmployeeList, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(allEmployeePnl);

        pnlCloseButton.setBackground(new java.awt.Color(255, 255, 255));
        pnlCloseButton.setMaximumSize(new java.awt.Dimension(120, 60));
        pnlCloseButton.setMinimumSize(new java.awt.Dimension(120, 60));
        pnlCloseButton.setPreferredSize(new java.awt.Dimension(120, 60));

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/devfortress/view/resources/icCancel.png"))); // NOI18N
        btnClose.setText(Constant.CLOSE_BTN );
        btnClose.setActionCommand(Constant.CLOSE_BTN);
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCloseButtonLayout = new javax.swing.GroupLayout(pnlCloseButton);
        pnlCloseButton.setLayout(pnlCloseButtonLayout);
        pnlCloseButtonLayout.setHorizontalGroup(
            pnlCloseButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlCloseButtonLayout.setVerticalGroup(
            pnlCloseButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCloseButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
        );

        add(pnlCloseButton);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHireActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHireActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCloseActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel allEmployeePnl;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnContract;
    private javax.swing.JButton btnEmployeeList;
    private javax.swing.JButton btnHire;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlCloseButton;
    private javax.swing.JPanel pnlContract;
    private javax.swing.JPanel pnlHire;
    private javax.swing.JPanel pnlTitle;
    // End of variables declaration//GEN-END:variables
}
