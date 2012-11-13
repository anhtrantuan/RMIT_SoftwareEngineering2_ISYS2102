/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.view;

import devfortress.view.renderers.ExpensesTreeCellRenderer;
import devfortress.view.renderers.ProjectsTreeCellRenderer;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author tommy
 */
public class View extends javax.swing.JFrame implements Observer, Runnable {

    /**
     * Creates new form View
     */
    public View() {
        initComponents();

        /* Fix background problem of developers scroll pane. */
        scpDevelopers.getViewport().setBackground(Color.white);

        /* Setup icons for components. */
        setUpIcons();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlStatusBar = new javax.swing.JPanel();
        lblStatus = new javax.swing.JLabel();
        scpManagement = new javax.swing.JScrollPane();
        pnlManagement = new javax.swing.JPanel();
        pnlSystemButtonHolder = new javax.swing.JPanel();
        btnSystem = new javax.swing.JButton();
        rigidArea1 = new javax.swing.Box.Filler(new java.awt.Dimension(100, 10), new java.awt.Dimension(100, 10), new java.awt.Dimension(100, 10));
        pnlStatusAndProjects = new javax.swing.JPanel();
        pnlStatus = new javax.swing.JPanel();
        pnlDuration = new javax.swing.JPanel();
        lblDuration = new javax.swing.JLabel();
        pnlBudget = new javax.swing.JPanel();
        lblBudget = new javax.swing.JLabel();
        scpExpenses = new javax.swing.JScrollPane();
        treExpenses = new javax.swing.JTree();
        pnlEmployees = new javax.swing.JPanel();
        lblEmployees = new javax.swing.JLabel();
        rigidArea2 = new javax.swing.Box.Filler(new java.awt.Dimension(100, 10), new java.awt.Dimension(100, 10), new java.awt.Dimension(100, 10));
        pnlProjects = new javax.swing.JPanel();
        scpProjects = new javax.swing.JScrollPane();
        treProjects = new javax.swing.JTree();
        pnlBlank = new javax.swing.JPanel();
        scpDevelopers = new javax.swing.JScrollPane();
        tblDevelopers = new javax.swing.JTable();
        pnlLogAndControl = new javax.swing.JPanel();
        scpLogPane = new javax.swing.JScrollPane();
        txaLog = new javax.swing.JTextArea();
        sppControl = new javax.swing.JSplitPane();
        pnlSystemControl = new javax.swing.JPanel();
        btnInformation = new javax.swing.JButton();
        btnCurrentProjects = new javax.swing.JButton();
        pnlTurnControl = new javax.swing.JPanel();
        btnNextTurn = new javax.swing.JButton();
        menu = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuFile_Exit = new javax.swing.JMenuItem();
        menuEdit = new javax.swing.JMenu();
        menuEdit_Preferences = new javax.swing.JMenuItem();
        menuView = new javax.swing.JMenu();
        menuView_Summary = new javax.swing.JMenuItem();
        menuHelp = new javax.swing.JMenu();
        menuHelp_About = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DevFortress");
        setPreferredSize(new java.awt.Dimension(1024, 600));
        setResizable(false);

        pnlStatusBar.setBackground(new java.awt.Color(255, 255, 255));
        pnlStatusBar.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        pnlStatusBar.setPreferredSize(new java.awt.Dimension(1024, 23));

        lblStatus.setText("Status");

        javax.swing.GroupLayout pnlStatusBarLayout = new javax.swing.GroupLayout(pnlStatusBar);
        pnlStatusBar.setLayout(pnlStatusBarLayout);
        pnlStatusBarLayout.setHorizontalGroup(
            pnlStatusBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlStatusBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlStatusBarLayout.setVerticalGroup(
            pnlStatusBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblStatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
        );

        scpManagement.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        pnlManagement.setBackground(new java.awt.Color(255, 255, 255));
        pnlManagement.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pnlManagement.setPreferredSize(new java.awt.Dimension(0, 0));
        pnlManagement.setLayout(new javax.swing.BoxLayout(pnlManagement, javax.swing.BoxLayout.Y_AXIS));

        pnlSystemButtonHolder.setBackground(new java.awt.Color(255, 255, 255));

        btnSystem.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        btnSystem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/devfortress/view/resources/icSystem.png"))); // NOI18N
        btnSystem.setText("System");

        javax.swing.GroupLayout pnlSystemButtonHolderLayout = new javax.swing.GroupLayout(pnlSystemButtonHolder);
        pnlSystemButtonHolder.setLayout(pnlSystemButtonHolderLayout);
        pnlSystemButtonHolderLayout.setHorizontalGroup(
            pnlSystemButtonHolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSystem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
        );
        pnlSystemButtonHolderLayout.setVerticalGroup(
            pnlSystemButtonHolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSystemButtonHolderLayout.createSequentialGroup()
                .addComponent(btnSystem, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlManagement.add(pnlSystemButtonHolder);
        pnlManagement.add(rigidArea1);

        pnlStatusAndProjects.setBackground(new java.awt.Color(255, 255, 255));
        pnlStatusAndProjects.setLayout(new javax.swing.BoxLayout(pnlStatusAndProjects, javax.swing.BoxLayout.Y_AXIS));

        pnlStatus.setBackground(new java.awt.Color(255, 255, 255));
        pnlStatus.setBorder(javax.swing.BorderFactory.createTitledBorder("Status"));
        pnlStatus.setPreferredSize(new java.awt.Dimension(180, 340));
        pnlStatus.setLayout(new javax.swing.BoxLayout(pnlStatus, javax.swing.BoxLayout.Y_AXIS));

        pnlDuration.setBackground(new java.awt.Color(255, 255, 255));
        pnlDuration.setPreferredSize(new java.awt.Dimension(0, 50));

        lblDuration.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        lblDuration.setIcon(new javax.swing.ImageIcon(getClass().getResource("/devfortress/view/resources/icDuration.png"))); // NOI18N
        lblDuration.setText("Duration");

        javax.swing.GroupLayout pnlDurationLayout = new javax.swing.GroupLayout(pnlDuration);
        pnlDuration.setLayout(pnlDurationLayout);
        pnlDurationLayout.setHorizontalGroup(
            pnlDurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDurationLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblDuration, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
        pnlDurationLayout.setVerticalGroup(
            pnlDurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDurationLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblDuration, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );

        pnlStatus.add(pnlDuration);

        pnlBudget.setBackground(new java.awt.Color(255, 255, 255));
        pnlBudget.setPreferredSize(new java.awt.Dimension(0, 50));

        lblBudget.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        lblBudget.setIcon(new javax.swing.ImageIcon(getClass().getResource("/devfortress/view/resources/icBudget.png"))); // NOI18N
        lblBudget.setText("Budget");

        javax.swing.GroupLayout pnlBudgetLayout = new javax.swing.GroupLayout(pnlBudget);
        pnlBudget.setLayout(pnlBudgetLayout);
        pnlBudgetLayout.setHorizontalGroup(
            pnlBudgetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBudgetLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblBudget, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
        pnlBudgetLayout.setVerticalGroup(
            pnlBudgetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBudgetLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblBudget)
                .addGap(6, 6, 6))
        );

        pnlStatus.add(pnlBudget);

        scpExpenses.setBorder(javax.swing.BorderFactory.createEmptyBorder(6, 6, 6, 6));
        scpExpenses.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        treExpenses.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Expenses");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Salaries");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Developer 1");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Developer 2");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Foods and Drinks");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Coffee");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Red Bull");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Pizza");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Beer");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treExpenses.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        treExpenses.setMaximumSize(new java.awt.Dimension(166, 80));
        treExpenses.setPreferredSize(new java.awt.Dimension(166, 0));
        treExpenses.setRowHeight(30);
        treExpenses.addTreeExpansionListener(new javax.swing.event.TreeExpansionListener() {
            public void treeCollapsed(javax.swing.event.TreeExpansionEvent evt) {
                treeExpansion(evt);
            }
            public void treeExpanded(javax.swing.event.TreeExpansionEvent evt) {
                treeExpansion(evt);
            }
        });
        scpExpenses.setViewportView(treExpenses);

        pnlStatus.add(scpExpenses);

        pnlEmployees.setBackground(new java.awt.Color(255, 255, 255));
        pnlEmployees.setPreferredSize(new java.awt.Dimension(0, 50));

        lblEmployees.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        lblEmployees.setIcon(new javax.swing.ImageIcon(getClass().getResource("/devfortress/view/resources/icEmployees.png"))); // NOI18N
        lblEmployees.setText("Employees");

        javax.swing.GroupLayout pnlEmployeesLayout = new javax.swing.GroupLayout(pnlEmployees);
        pnlEmployees.setLayout(pnlEmployeesLayout);
        pnlEmployeesLayout.setHorizontalGroup(
            pnlEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEmployeesLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblEmployees, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
        pnlEmployeesLayout.setVerticalGroup(
            pnlEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEmployeesLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblEmployees)
                .addGap(6, 6, 6))
        );

        pnlStatus.add(pnlEmployees);

        pnlStatusAndProjects.add(pnlStatus);
        pnlStatusAndProjects.add(rigidArea2);

        pnlProjects.setBackground(new java.awt.Color(255, 255, 255));
        pnlProjects.setBorder(javax.swing.BorderFactory.createTitledBorder("Projects"));
        pnlProjects.setPreferredSize(new java.awt.Dimension(104, 378));
        pnlProjects.setLayout(new javax.swing.BoxLayout(pnlProjects, javax.swing.BoxLayout.Y_AXIS));

        scpProjects.setBorder(javax.swing.BorderFactory.createEmptyBorder(6, 6, 6, 6));
        scpProjects.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        treProjects.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Projects");
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Project 1");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Points");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Remaining");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Pay");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Due");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Project 2");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Points");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Remaining");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Pay");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Due");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treProjects.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        treProjects.setPreferredSize(new java.awt.Dimension(90, 60));
        treProjects.setRootVisible(false);
        treProjects.setRowHeight(30);
        treProjects.addTreeExpansionListener(new javax.swing.event.TreeExpansionListener() {
            public void treeCollapsed(javax.swing.event.TreeExpansionEvent evt) {
                treeExpansion(evt);
            }
            public void treeExpanded(javax.swing.event.TreeExpansionEvent evt) {
                treeExpansion(evt);
            }
        });
        scpProjects.setViewportView(treProjects);

        pnlProjects.add(scpProjects);

        pnlStatusAndProjects.add(pnlProjects);

        pnlManagement.add(pnlStatusAndProjects);

        pnlBlank.setBackground(new java.awt.Color(255, 255, 255));
        pnlBlank.setMinimumSize(new java.awt.Dimension(0, 0));

        javax.swing.GroupLayout pnlBlankLayout = new javax.swing.GroupLayout(pnlBlank);
        pnlBlank.setLayout(pnlBlankLayout);
        pnlBlankLayout.setHorizontalGroup(
            pnlBlankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 344, Short.MAX_VALUE)
        );
        pnlBlankLayout.setVerticalGroup(
            pnlBlankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlManagement.add(pnlBlank);

        scpManagement.setViewportView(pnlManagement);

        scpDevelopers.setBackground(new java.awt.Color(255, 255, 255));
        scpDevelopers.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        scpDevelopers.setPreferredSize(new java.awt.Dimension(0, 0));

        tblDevelopers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"a", "a", "a", "a"},
                {"b", "b", "b", "b"},
                {"c", "c", "c", "c"},
                {"d", "d", "d", "d"}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scpDevelopers.setViewportView(tblDevelopers);

        pnlLogAndControl.setPreferredSize(new java.awt.Dimension(0, 120));

        scpLogPane.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        txaLog.setEditable(false);
        txaLog.setColumns(20);
        txaLog.setRows(5);
        txaLog.setText("Log message");
        txaLog.setToolTipText("Log messages");
        scpLogPane.setViewportView(txaLog);

        sppControl.setBackground(new java.awt.Color(255, 255, 255));
        sppControl.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        sppControl.setDividerLocation(180);
        sppControl.setEnabled(false);
        sppControl.setPreferredSize(new java.awt.Dimension(0, 0));

        pnlSystemControl.setBackground(new java.awt.Color(255, 255, 255));

        btnInformation.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        btnInformation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/devfortress/view/resources/icInformation.png"))); // NOI18N
        btnInformation.setText("Information");

        btnCurrentProjects.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        btnCurrentProjects.setIcon(new javax.swing.ImageIcon(getClass().getResource("/devfortress/view/resources/icProjects.png"))); // NOI18N
        btnCurrentProjects.setText("Current Projects");

        javax.swing.GroupLayout pnlSystemControlLayout = new javax.swing.GroupLayout(pnlSystemControl);
        pnlSystemControl.setLayout(pnlSystemControlLayout);
        pnlSystemControlLayout.setHorizontalGroup(
            pnlSystemControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSystemControlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSystemControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnInformation, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                    .addComponent(btnCurrentProjects, javax.swing.GroupLayout.PREFERRED_SIZE, 154, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlSystemControlLayout.setVerticalGroup(
            pnlSystemControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSystemControlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCurrentProjects, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        sppControl.setLeftComponent(pnlSystemControl);

        pnlTurnControl.setBackground(new java.awt.Color(255, 255, 255));

        btnNextTurn.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        btnNextTurn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/devfortress/view/resources/icNextTurn.png"))); // NOI18N
        btnNextTurn.setText("Next Turn");

        javax.swing.GroupLayout pnlTurnControlLayout = new javax.swing.GroupLayout(pnlTurnControl);
        pnlTurnControl.setLayout(pnlTurnControlLayout);
        pnlTurnControlLayout.setHorizontalGroup(
            pnlTurnControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTurnControlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNextTurn, javax.swing.GroupLayout.PREFERRED_SIZE, 122, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlTurnControlLayout.setVerticalGroup(
            pnlTurnControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTurnControlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNextTurn, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                .addContainerGap())
        );

        sppControl.setRightComponent(pnlTurnControl);

        javax.swing.GroupLayout pnlLogAndControlLayout = new javax.swing.GroupLayout(pnlLogAndControl);
        pnlLogAndControl.setLayout(pnlLogAndControlLayout);
        pnlLogAndControlLayout.setHorizontalGroup(
            pnlLogAndControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLogAndControlLayout.createSequentialGroup()
                .addComponent(scpLogPane, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(sppControl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlLogAndControlLayout.setVerticalGroup(
            pnlLogAndControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scpLogPane)
            .addComponent(sppControl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        menu.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        menuFile.setText("File");

        menuFile_Exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        menuFile_Exit.setText("Exit");
        menuFile.add(menuFile_Exit);

        menu.add(menuFile);

        menuEdit.setText("Edit");

        menuEdit_Preferences.setText("Preferences");
        menuEdit.add(menuEdit_Preferences);

        menu.add(menuEdit);

        menuView.setText("View");

        menuView_Summary.setText("Summary");
        menuView.add(menuView_Summary);

        menu.add(menuView);

        menuHelp.setText("Help");

        menuHelp_About.setText("About");
        menuHelp.add(menuHelp_About);

        menu.add(menuHelp);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scpManagement)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scpDevelopers, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlLogAndControl, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)))
            .addComponent(pnlStatusBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scpDevelopers, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(pnlLogAndControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scpManagement))
                .addGap(0, 0, 0)
                .addComponent(pnlStatusBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Setup icons for components.
     */
    private void setUpIcons() {
        treExpenses.setCellRenderer(new ExpensesTreeCellRenderer());
        treProjects.setCellRenderer(new ProjectsTreeCellRenderer());
    }

    /**
     * Resize container panels of the trees to fit their contents.
     */
    private void treeExpansion(javax.swing.event.TreeExpansionEvent evt) {//GEN-FIRST:event_treeExpansion
        /* Get required components' sizes. */
        Dimension pnlManagementSize = pnlManagement.getSize(),
                pnlStatusSize = pnlStatus.getSize(),
                pnlProjectsSize = pnlProjects.getSize(),
                scpExpensesViewportSize = scpExpenses.getViewport().getSize(),
                scpProjectsViewportSize = scpProjects.getViewport().getSize(),
                scpManagementViewportSize = scpManagement.getViewport().getSize(),
                pnlBlankSize = pnlBlank.getSize();

        /* Declare and define size increment for each panel including a tree. */
        int pnlStatusSizeIncrement, pnlProjectsSizeIncrement, pnlManagementSizeIncrement;
        pnlStatusSizeIncrement = (int) ((treExpenses.getRowCount() + 0.5)
                * treExpenses.getRowHeight()) - scpExpensesViewportSize.height;
        pnlProjectsSizeIncrement = treProjects.getRowCount()
                * treProjects.getRowHeight() - scpProjectsViewportSize.height;
        pnlManagementSizeIncrement = pnlStatusSizeIncrement + pnlProjectsSizeIncrement;

        /* Adjust size increments based on total size increment. */
        if (pnlManagementSizeIncrement > 0) {
            /* If size is to be accumulated, recalculate pnlBlank's size and
             * total size increment.
             */
            if (pnlBlankSize.height > pnlManagementSizeIncrement) {
                pnlBlankSize.height -= pnlManagementSizeIncrement;
                pnlManagementSizeIncrement = 0;
            } else {
                pnlManagementSizeIncrement -= pnlBlankSize.height;
                pnlBlankSize.height = 0;
            }
        } else {
            /* Else, check current size of scrollable content. */
            if (pnlManagementSize.height > scpManagementViewportSize.height) {
                /* If content is oversized, recalculate pnlBlank's size. */
                if (pnlManagementSize.height + pnlManagementSizeIncrement
                        < scpManagementViewportSize.height) {
                    pnlBlankSize.height = scpManagementViewportSize.height
                            - pnlManagementSize.height - pnlManagementSizeIncrement;
                }
            } else {
                pnlBlankSize.height -= pnlManagementSizeIncrement;
            }
        }

        /* Update panel's sizes. */
        pnlManagementSize.height += pnlManagementSizeIncrement;
        pnlStatusSize.height += pnlStatusSizeIncrement;
        pnlProjectsSize.height += pnlProjectsSizeIncrement;

        /* Adjust panels' sizes according to scrolling condition. */
        if (pnlManagementSize.height > scpManagementViewportSize.height) {
            /* If scroll is enabled, update any panel that has change. */
            pnlBlankSize.height = 0;
            if (pnlStatusSizeIncrement != 0) {
                pnlStatus.setSize(pnlStatusSize);
                pnlStatus.setPreferredSize(pnlStatusSize);
            }
            if (pnlProjectsSizeIncrement != 0) {
                pnlProjects.setSize(pnlProjectsSize);
                pnlProjects.setPreferredSize(pnlProjectsSize);
            }
        } else {
            /* If scroll is disabled, decide which panel to update first. */
            if (pnlStatusSizeIncrement < pnlProjectsSizeIncrement) {
                pnlStatus.setSize(pnlStatusSize);
                pnlStatus.setPreferredSize(pnlStatusSize);
                if (pnlProjectsSizeIncrement != 0) {
                    pnlProjects.setSize(pnlProjectsSize);
                    pnlProjects.setPreferredSize(pnlProjectsSize);
                }
            } else {
                pnlProjects.setSize(pnlProjectsSize);
                pnlProjects.setPreferredSize(pnlProjectsSize);
                if (pnlStatusSizeIncrement != 0) {
                    pnlStatus.setSize(pnlStatusSize);
                    pnlStatus.setPreferredSize(pnlStatusSize);
                }
            }
        }

        /* Update root panel and its filler panel. */
        pnlBlank.setSize(pnlBlankSize);
        pnlBlank.setPreferredSize(pnlBlankSize);
        pnlManagement.setSize(pnlManagementSize);
        pnlManagement.setPreferredSize(pnlManagementSize);

        /* Revalidate the frame layout. */
        this.revalidate();
    }//GEN-LAST:event_treeExpansion

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new View().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCurrentProjects;
    private javax.swing.JButton btnInformation;
    private javax.swing.JButton btnNextTurn;
    private javax.swing.JButton btnSystem;
    private javax.swing.JLabel lblBudget;
    private javax.swing.JLabel lblDuration;
    private javax.swing.JLabel lblEmployees;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu menuEdit;
    private javax.swing.JMenuItem menuEdit_Preferences;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenuItem menuFile_Exit;
    private javax.swing.JMenu menuHelp;
    private javax.swing.JMenuItem menuHelp_About;
    private javax.swing.JMenu menuView;
    private javax.swing.JMenuItem menuView_Summary;
    private javax.swing.JPanel pnlBlank;
    private javax.swing.JPanel pnlBudget;
    private javax.swing.JPanel pnlDuration;
    private javax.swing.JPanel pnlEmployees;
    private javax.swing.JPanel pnlLogAndControl;
    private javax.swing.JPanel pnlManagement;
    private javax.swing.JPanel pnlProjects;
    private javax.swing.JPanel pnlStatus;
    private javax.swing.JPanel pnlStatusAndProjects;
    private javax.swing.JPanel pnlStatusBar;
    private javax.swing.JPanel pnlSystemButtonHolder;
    private javax.swing.JPanel pnlSystemControl;
    private javax.swing.JPanel pnlTurnControl;
    private javax.swing.Box.Filler rigidArea1;
    private javax.swing.Box.Filler rigidArea2;
    private javax.swing.JScrollPane scpDevelopers;
    private javax.swing.JScrollPane scpExpenses;
    private javax.swing.JScrollPane scpLogPane;
    private javax.swing.JScrollPane scpManagement;
    private javax.swing.JScrollPane scpProjects;
    private javax.swing.JSplitPane sppControl;
    private javax.swing.JTable tblDevelopers;
    private javax.swing.JTree treExpenses;
    private javax.swing.JTree treProjects;
    private javax.swing.JTextArea txaLog;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
