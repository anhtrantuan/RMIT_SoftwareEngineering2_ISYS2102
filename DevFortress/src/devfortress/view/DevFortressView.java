/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.view;

import com.tabuto.j2dgf.Game2D;
import com.tabuto.j2dgf.gui.J2DCanvasPanel;
import devfortress.DevFortress;
import devfortress.model.DateTime;
import devfortress.model.facade.Model;
import devfortress.utilities.Constant;
import devfortress.view.animation.GameAnimationEngine;
import devfortress.view.animation.events.DeveloperIsSickEventAnimation;
import devfortress.view.models.ExpensesTreeModel;
import devfortress.view.models.ProjectsTreeModel;
import devfortress.view.renderers.ExpensesTreeCellRenderer;
import devfortress.view.renderers.ProjectsTreeCellRenderer;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 *
 * @author tommy
 */
public class DevFortressView extends javax.swing.JFrame implements View, Observer, Runnable {

    private Model model;
    private String logMessages;
    private Dimension dimension, eventDimension;
    private J2DCanvasPanel animationCanvas;
    private GameAnimationEngine animationEngine;
    private ArrayList<J2DCanvasPanel> canvases;
    private ArrayList<Game2D> gameEngines;

    /**
     * Creates new form DevFortressView.
     *
     * @param model
     */
    public DevFortressView(Model model) {
        this.model = model;
        logMessages = "";

        /* Set theme for View. */
        try {
            /* If current platform does not have specialized theme, use Nimbus. */
            if (UIManager.getSystemLookAndFeelClassName().
                    equals(UIManager.getCrossPlatformLookAndFeelClassName())) {
                for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } else {
                /* Else, setup look and feel to match current system. */
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }

        } catch (Exception ex) {
            Logger.getLogger(DevFortress.class.getName()).log(Level.SEVERE, null, ex);
        }

        /* Initialize view. */
        initialize();

        /* Populate data for trees and tables. */
        populateData();
    }

    /**
     * Initialize DevFortress View.
     */
    private void initialize() {
        /* Initialize components. */
        initComponents();

        /* Get animation panel dimension. */
        dimension = pnlGameAnimation.getSize();
        eventDimension = scpEvents.getViewport().getSize();

        /* Create animation engine and placeholder panel for animations. */
        animationEngine = new GameAnimationEngine(dimension);
        animationCanvas = new J2DCanvasPanel(dimension);
        animationCanvas.setSize(dimension);
        animationCanvas.setSleep(1000);
        animationEngine.initGame();
        pnlGameAnimation.add(animationCanvas);

        /* Initialize animation engines and canvases. */
        canvases = new ArrayList<J2DCanvasPanel>();
        gameEngines = new ArrayList<Game2D>();
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
        pnlControls = new javax.swing.JPanel();
        btnSystem = new javax.swing.JButton();
        btnInformation = new javax.swing.JButton();
        btnCurrentProjects = new javax.swing.JButton();
        btnNextTurn = new javax.swing.JButton();
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
        pnlAnimation = new javax.swing.JPanel();
        pnlGameAnimation = new javax.swing.JPanel();
        scpEvents = new javax.swing.JScrollPane();
        pnlEvents = new javax.swing.JPanel();
        menu = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuFile_Exit = new javax.swing.JMenuItem();
        menuEdit = new javax.swing.JMenu();
        menuEdit_Preferences = new javax.swing.JMenuItem();
        menuView = new javax.swing.JMenu();
        menuView_Summary = new javax.swing.JMenuItem();
        menuHelp = new javax.swing.JMenu();
        menuHelp_About = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("DevFortress");
        setBackground(new java.awt.Color(255, 255, 255));
        setName("DevFortress"); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnlStatusBar.setBackground(new java.awt.Color(255, 255, 255));
        pnlStatusBar.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), javax.swing.BorderFactory.createEmptyBorder(0, 6, 0, 6)));
        pnlStatusBar.setPreferredSize(new java.awt.Dimension(1024, 23));

        lblStatus.setBackground(new java.awt.Color(255, 255, 255));
        lblStatus.setText("Status");

        javax.swing.GroupLayout pnlStatusBarLayout = new javax.swing.GroupLayout(pnlStatusBar);
        pnlStatusBar.setLayout(pnlStatusBarLayout);
        pnlStatusBarLayout.setHorizontalGroup(
            pnlStatusBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlStatusBarLayout.setVerticalGroup(
            pnlStatusBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStatusBarLayout.createSequentialGroup()
                .addComponent(lblStatus)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        scpManagement.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        scpManagement.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scpManagement.setMinimumSize(new java.awt.Dimension(0, 0));
        scpManagement.setPreferredSize(new java.awt.Dimension(0, 0));

        pnlManagement.setBackground(new java.awt.Color(255, 255, 255));
        pnlManagement.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pnlManagement.setMinimumSize(new java.awt.Dimension(0, 0));
        pnlManagement.setPreferredSize(new java.awt.Dimension(0, 0));
        pnlManagement.setLayout(new javax.swing.BoxLayout(pnlManagement, javax.swing.BoxLayout.Y_AXIS));

        pnlControls.setBackground(new java.awt.Color(255, 255, 255));
        pnlControls.setMaximumSize(new java.awt.Dimension(32767, 150));
        pnlControls.setMinimumSize(new java.awt.Dimension(0, 150));
        pnlControls.setPreferredSize(new java.awt.Dimension(0, 150));

        btnSystem.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        btnSystem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/devfortress/view/resources/icSystem.png"))); // NOI18N
        btnSystem.setText(Constant.BUTTON_SYSTEM);
        btnSystem.setMaximumSize(new java.awt.Dimension(126, 50));
        btnSystem.setMinimumSize(new java.awt.Dimension(126, 50));
        btnSystem.setPreferredSize(new java.awt.Dimension(126, 50));

        btnInformation.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        btnInformation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/devfortress/view/resources/icInformation.png"))); // NOI18N
        btnInformation.setText(Constant.BUTTON_INFORMATION);
        btnInformation.setMaximumSize(new java.awt.Dimension(227, 40));
        btnInformation.setMinimumSize(new java.awt.Dimension(227, 40));
        btnInformation.setPreferredSize(new java.awt.Dimension(227, 40));

        btnCurrentProjects.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        btnCurrentProjects.setIcon(new javax.swing.ImageIcon(getClass().getResource("/devfortress/view/resources/icProjects.png"))); // NOI18N
        btnCurrentProjects.setText(Constant.BUTTTON_CURRENT_PROJECTS);
        btnCurrentProjects.setMaximumSize(new java.awt.Dimension(227, 40));
        btnCurrentProjects.setMinimumSize(new java.awt.Dimension(227, 40));
        btnCurrentProjects.setPreferredSize(new java.awt.Dimension(227, 40));

        btnNextTurn.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        btnNextTurn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/devfortress/view/resources/icNextTurn.png"))); // NOI18N
        btnNextTurn.setText(Constant.BUTTON_NEXT_TURN);
        btnNextTurn.setMaximumSize(new java.awt.Dimension(128, 90));
        btnNextTurn.setMinimumSize(new java.awt.Dimension(128, 90));
        btnNextTurn.setPreferredSize(new java.awt.Dimension(136, 90));

        javax.swing.GroupLayout pnlControlsLayout = new javax.swing.GroupLayout(pnlControls);
        pnlControls.setLayout(pnlControlsLayout);
        pnlControlsLayout.setHorizontalGroup(
            pnlControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlControlsLayout.createSequentialGroup()
                .addGroup(pnlControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlControlsLayout.createSequentialGroup()
                        .addGroup(pnlControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnInformation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCurrentProjects, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addComponent(btnNextTurn, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSystem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        pnlControlsLayout.setVerticalGroup(
            pnlControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlControlsLayout.createSequentialGroup()
                .addComponent(btnSystem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(pnlControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlControlsLayout.createSequentialGroup()
                        .addComponent(btnInformation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnCurrentProjects, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnNextTurn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlManagement.add(pnlControls);
        pnlManagement.add(rigidArea1);

        pnlStatusAndProjects.setBackground(new java.awt.Color(255, 255, 255));
        pnlStatusAndProjects.setLayout(new javax.swing.BoxLayout(pnlStatusAndProjects, javax.swing.BoxLayout.Y_AXIS));

        pnlStatus.setBackground(new java.awt.Color(255, 255, 255));
        pnlStatus.setBorder(javax.swing.BorderFactory.createTitledBorder("Status"));
        pnlStatus.setMinimumSize(new java.awt.Dimension(0, 0));
        pnlStatus.setPreferredSize(new java.awt.Dimension(0, 210));
        pnlStatus.setLayout(new javax.swing.BoxLayout(pnlStatus, javax.swing.BoxLayout.Y_AXIS));

        pnlDuration.setBackground(new java.awt.Color(255, 255, 255));
        pnlDuration.setBorder(javax.swing.BorderFactory.createEmptyBorder(6, 6, 6, 6));
        pnlDuration.setMaximumSize(new java.awt.Dimension(32767, 36));
        pnlDuration.setMinimumSize(new java.awt.Dimension(0, 36));
        pnlDuration.setPreferredSize(new java.awt.Dimension(0, 36));

        lblDuration.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        lblDuration.setIcon(new javax.swing.ImageIcon(getClass().getResource("/devfortress/view/resources/icDuration.png"))); // NOI18N
        lblDuration.setText("Duration");

        javax.swing.GroupLayout pnlDurationLayout = new javax.swing.GroupLayout(pnlDuration);
        pnlDuration.setLayout(pnlDurationLayout);
        pnlDurationLayout.setHorizontalGroup(
            pnlDurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDuration, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
        );
        pnlDurationLayout.setVerticalGroup(
            pnlDurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDuration, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlStatus.add(pnlDuration);

        pnlBudget.setBackground(new java.awt.Color(255, 255, 255));
        pnlBudget.setBorder(javax.swing.BorderFactory.createEmptyBorder(6, 6, 6, 6));
        pnlBudget.setMaximumSize(new java.awt.Dimension(32767, 36));
        pnlBudget.setMinimumSize(new java.awt.Dimension(0, 36));
        pnlBudget.setPreferredSize(new java.awt.Dimension(0, 36));

        lblBudget.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        lblBudget.setIcon(new javax.swing.ImageIcon(getClass().getResource("/devfortress/view/resources/icBudget.png"))); // NOI18N
        lblBudget.setText("Budget");

        javax.swing.GroupLayout pnlBudgetLayout = new javax.swing.GroupLayout(pnlBudget);
        pnlBudget.setLayout(pnlBudgetLayout);
        pnlBudgetLayout.setHorizontalGroup(
            pnlBudgetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblBudget, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
        );
        pnlBudgetLayout.setVerticalGroup(
            pnlBudgetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblBudget, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlStatus.add(pnlBudget);

        scpExpenses.setBackground(new java.awt.Color(255, 255, 255));
        scpExpenses.setBorder(javax.swing.BorderFactory.createEmptyBorder(6, 6, 6, 6));
        scpExpenses.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scpExpenses.setMinimumSize(new java.awt.Dimension(0, 42));
        scpExpenses.setPreferredSize(new java.awt.Dimension(14, 42));

        treExpenses.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        treExpenses.setModel(new ExpensesTreeModel(null));
        treExpenses.setCellRenderer(new ExpensesTreeCellRenderer());
        treExpenses.setMaximumSize(new java.awt.Dimension(166, 32779));
        treExpenses.setMinimumSize(new java.awt.Dimension(0, 30));
        treExpenses.setPreferredSize(new java.awt.Dimension(0, 30));
        treExpenses.setRowHeight(30);
        treExpenses.setSelectionModel(null);
        treExpenses.addTreeExpansionListener(new javax.swing.event.TreeExpansionListener() {
            public void treeExpanded(javax.swing.event.TreeExpansionEvent evt) {
                treeExpansion(evt);
            }
            public void treeCollapsed(javax.swing.event.TreeExpansionEvent evt) {
                treeExpansion(evt);
            }
        });
        scpExpenses.setViewportView(treExpenses);

        pnlStatus.add(scpExpenses);

        pnlEmployees.setBackground(new java.awt.Color(255, 255, 255));
        pnlEmployees.setBorder(javax.swing.BorderFactory.createEmptyBorder(6, 6, 6, 6));
        pnlEmployees.setMaximumSize(new java.awt.Dimension(32767, 36));
        pnlEmployees.setPreferredSize(new java.awt.Dimension(0, 36));

        lblEmployees.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        lblEmployees.setIcon(new javax.swing.ImageIcon(getClass().getResource("/devfortress/view/resources/icEmployees.png"))); // NOI18N
        lblEmployees.setText("Employees");
        lblEmployees.setPreferredSize(new java.awt.Dimension(0, 24));

        javax.swing.GroupLayout pnlEmployeesLayout = new javax.swing.GroupLayout(pnlEmployees);
        pnlEmployees.setLayout(pnlEmployeesLayout);
        pnlEmployeesLayout.setHorizontalGroup(
            pnlEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblEmployees, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
        );
        pnlEmployeesLayout.setVerticalGroup(
            pnlEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblEmployees, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlStatus.add(pnlEmployees);

        pnlStatusAndProjects.add(pnlStatus);
        pnlStatusAndProjects.add(rigidArea2);

        pnlProjects.setBackground(new java.awt.Color(255, 255, 255));
        pnlProjects.setBorder(javax.swing.BorderFactory.createTitledBorder("Projects"));
        pnlProjects.setMinimumSize(new java.awt.Dimension(0, 42));
        pnlProjects.setPreferredSize(new java.awt.Dimension(0, 42));
        pnlProjects.setLayout(new javax.swing.BoxLayout(pnlProjects, javax.swing.BoxLayout.Y_AXIS));

        scpProjects.setBackground(new java.awt.Color(255, 255, 255));
        scpProjects.setBorder(javax.swing.BorderFactory.createEmptyBorder(6, 6, 6, 6));
        scpProjects.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scpProjects.setMinimumSize(new java.awt.Dimension(6, 42));
        scpProjects.setPreferredSize(new java.awt.Dimension(14, 42));

        treProjects.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        treProjects.setModel(new ProjectsTreeModel(null));
        treProjects.setCellRenderer(new ProjectsTreeCellRenderer());
        treProjects.setMaximumSize(new java.awt.Dimension(90, 32779));
        treProjects.setMinimumSize(new java.awt.Dimension(0, 30));
        treProjects.setPreferredSize(new java.awt.Dimension(0, 30));
        treProjects.setRootVisible(false);
        treProjects.setRowHeight(30);
        treProjects.setSelectionModel(null);
        treProjects.addTreeExpansionListener(new javax.swing.event.TreeExpansionListener() {
            public void treeExpanded(javax.swing.event.TreeExpansionEvent evt) {
                treeExpansion(evt);
            }
            public void treeCollapsed(javax.swing.event.TreeExpansionEvent evt) {
                treeExpansion(evt);
            }
        });
        scpProjects.setViewportView(treProjects);

        pnlProjects.add(scpProjects);

        pnlStatusAndProjects.add(pnlProjects);

        pnlManagement.add(pnlStatusAndProjects);

        pnlBlank.setBackground(new java.awt.Color(255, 255, 255));
        pnlBlank.setMinimumSize(new java.awt.Dimension(0, 0));
        pnlBlank.setOpaque(false);
        pnlBlank.setPreferredSize(new java.awt.Dimension(0, 0));

        javax.swing.GroupLayout pnlBlankLayout = new javax.swing.GroupLayout(pnlBlank);
        pnlBlank.setLayout(pnlBlankLayout);
        pnlBlankLayout.setHorizontalGroup(
            pnlBlankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 361, Short.MAX_VALUE)
        );
        pnlBlankLayout.setVerticalGroup(
            pnlBlankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 68, Short.MAX_VALUE)
        );

        pnlManagement.add(pnlBlank);

        scpManagement.setViewportView(pnlManagement);

        pnlAnimation.setBackground(new java.awt.Color(255, 255, 255));
        pnlAnimation.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        pnlAnimation.setPreferredSize(new java.awt.Dimension(4, 447));

        pnlGameAnimation.setBackground(new java.awt.Color(255, 255, 255));
        pnlGameAnimation.setPreferredSize(new java.awt.Dimension(596, 421));

        javax.swing.GroupLayout pnlGameAnimationLayout = new javax.swing.GroupLayout(pnlGameAnimation);
        pnlGameAnimation.setLayout(pnlGameAnimationLayout);
        pnlGameAnimationLayout.setHorizontalGroup(
            pnlGameAnimationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 596, Short.MAX_VALUE)
        );
        pnlGameAnimationLayout.setVerticalGroup(
            pnlGameAnimationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlAnimationLayout = new javax.swing.GroupLayout(pnlAnimation);
        pnlAnimation.setLayout(pnlAnimationLayout);
        pnlAnimationLayout.setHorizontalGroup(
            pnlAnimationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAnimationLayout.createSequentialGroup()
                .addComponent(pnlGameAnimation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlAnimationLayout.setVerticalGroup(
            pnlAnimationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlGameAnimation, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        scpEvents.setBackground(new java.awt.Color(255, 255, 255));
        scpEvents.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        scpEvents.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scpEvents.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        pnlEvents.setBackground(new java.awt.Color(255, 255, 255));
        pnlEvents.setPreferredSize(new java.awt.Dimension(594, 202));
        pnlEvents.setLayout(new javax.swing.BoxLayout(pnlEvents, javax.swing.BoxLayout.Y_AXIS));
        scpEvents.setViewportView(pnlEvents);

        menu.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        menuFile.setMnemonic('F');
        menuFile.setText("File");

        menuFile_Exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        menuFile_Exit.setText("Exit");
        menuFile_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFile_ExitActionPerformed(evt);
            }
        });
        menuFile.add(menuFile_Exit);

        menu.add(menuFile);

        menuEdit.setMnemonic('E');
        menuEdit.setText("Edit");

        menuEdit_Preferences.setText("Preferences");
        menuEdit.add(menuEdit_Preferences);

        menu.add(menuEdit);

        menuView.setMnemonic('V');
        menuView.setText("View");

        menuView_Summary.setText("Summary");
        menuView.add(menuView_Summary);

        menu.add(menuView);

        menuHelp.setMnemonic('H');
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
                .addComponent(scpManagement, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlAnimation, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                    .addComponent(scpEvents, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
            .addComponent(pnlStatusBar, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scpManagement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlAnimation, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(scpEvents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)))
                .addComponent(pnlStatusBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Populate data for DevFortressView.
     */
    private void populateData() {
        /* Update Status panel. */
        DateTime duration = model.getCurrentTimePlayed();
        lblDuration.setText(String.format("%s: Y%d M%d W%d", Constant.DURATION,
                duration.getYear(), duration.getMonthOfYear(),
                duration.getWeekOfMonth()));
        lblBudget.setText(String.format("%s: $%.2f", Constant.BUDGET,
                model.getBudget()));
        ExpensesTreeModel treExpensesModel =
                (ExpensesTreeModel) treExpenses.getModel();
        treExpensesModel.setTotalExpense(model.getExpenses());
        treExpensesModel.setSalaries(model.getTotalSalary());
        treExpensesModel.setItemExpense(model.getItemExpenses());
        treExpensesModel.setExpenseItems(model.getItems());
        treExpensesModel.reload();
        lblEmployees.setText(String.format("%s: %d", Constant.EMPLOYEES,
                model.getEmployeeList().size()));

        /* Update Projects panel. */
        ProjectsTreeModel treProjectsModel =
                (ProjectsTreeModel) treProjects.getModel();
        treProjectsModel.setProjects(model.getProjectList());
        treProjectsModel.reload();

        /* Fix overstretch problem of Management panel. */
        pnlManagement.setSize(0, pnlManagement.getHeight());

        /* Adjust sizes of Management panel and its child components. */
        treeExpansion(null);

        DeveloperIsSickEventAnimation devSickEvent =
                new DeveloperIsSickEventAnimation(eventDimension);
        devSickEvent.initGame();
        J2DCanvasPanel eventAnimationCanvas = new J2DCanvasPanel(eventDimension);
        eventAnimationCanvas.setSize(eventDimension);
        eventAnimationCanvas.setSleep(250);
        addEvents(devSickEvent, eventAnimationCanvas);
    }

    /**
     * Add event to event panel.
     *
     * @param event
     */
    private void addEvents(Game2D engine, J2DCanvasPanel canvas) {
        gameEngines.add(engine);
        canvases.add(canvas);
        pnlEvents.add(canvas);
    }

    /**
     * Clear events.
     */
    private void clearEvents() {
        gameEngines.clear();
        canvases.clear();
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
        int pnlStatusSizeIncrement, pnlProjectsSizeIncrement,
                pnlManagementSizeIncrement;
        pnlStatusSizeIncrement = (treExpenses.getRowCount()
                * treExpenses.getRowHeight()) - scpExpensesViewportSize.height;
        if (pnlManagementSize.height == 0) {
            pnlStatusSizeIncrement += treExpenses.getRowHeight() * 0.5;
        }
        pnlProjectsSizeIncrement = (treProjects.getRowCount()
                + ((treProjects.getRowCount() == 0) ? 1 : 0))
                * treProjects.getRowHeight() - scpProjectsViewportSize.height;
        pnlManagementSizeIncrement = pnlStatusSizeIncrement
                + pnlProjectsSizeIncrement;

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
        validate();
    }//GEN-LAST:event_treeExpansion

    /**
     * Handle window closing event.
     *
     * @param evt
     */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int response = JOptionPane.showConfirmDialog(this, "Do you really want to exit?",
                "Exit Confirmation", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (response == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    /**
     * Handle window closing event.
     *
     * @param evt
     */
    private void menuFile_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFile_ExitActionPerformed
        formWindowClosing(null);
    }//GEN-LAST:event_menuFile_ExitActionPerformed
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
    private javax.swing.JPanel pnlAnimation;
    private javax.swing.JPanel pnlBlank;
    private javax.swing.JPanel pnlBudget;
    private javax.swing.JPanel pnlControls;
    private javax.swing.JPanel pnlDuration;
    private javax.swing.JPanel pnlEmployees;
    private javax.swing.JPanel pnlEvents;
    private javax.swing.JPanel pnlGameAnimation;
    private javax.swing.JPanel pnlManagement;
    private javax.swing.JPanel pnlProjects;
    private javax.swing.JPanel pnlStatus;
    private javax.swing.JPanel pnlStatusAndProjects;
    private javax.swing.JPanel pnlStatusBar;
    private javax.swing.Box.Filler rigidArea1;
    private javax.swing.Box.Filler rigidArea2;
    private javax.swing.JScrollPane scpEvents;
    private javax.swing.JScrollPane scpExpenses;
    private javax.swing.JScrollPane scpManagement;
    private javax.swing.JScrollPane scpProjects;
    private javax.swing.JTree treExpenses;
    private javax.swing.JTree treProjects;
    // End of variables declaration//GEN-END:variables

    /**
     * Update data and logs.
     *
     * @param o
     * @param arg
     */
    @Override
    public void update(Observable o, Object arg) {
        /* Populate data. */
        populateData();

        /* Append log message. */
        logMessages += arg + "\n";
    }

    /**
     * Add button listener for main screen.
     *
     * @param buttonListener
     */
    @Override
    public void addButtonListener(ActionListener buttonListener) {
        btnSystem.addActionListener(buttonListener);
        btnInformation.addActionListener(buttonListener);
        btnCurrentProjects.addActionListener(buttonListener);
        btnNextTurn.addActionListener(buttonListener);
    }

    /**
     * Runnable method allow View to be run in separate thread.
     */
    @Override
    public void run() {
        setVisible(true);

        while (true) {
            if (animationEngine.isActive()) {
                animationCanvas.drawStuff(animationEngine);
                animationCanvas.panelDraw();
            }
            for (int i = 0; i < canvases.size(); i++) {
                canvases.get(i).drawStuff(gameEngines.get(i));
                canvases.get(i).panelDraw();
            }
            try {
                Thread.sleep(250);
            } catch (InterruptedException ex) {
                Logger.getLogger(DevFortressView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
