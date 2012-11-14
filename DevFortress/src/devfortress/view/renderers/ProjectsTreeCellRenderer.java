/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.view.renderers;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 *
 * @author tommy
 */
public class ProjectsTreeCellRenderer extends DefaultTreeCellRenderer {

    /* Declare image icons for nodes. */
    ImageIcon projectIcon, pointsIcon, remainingPointsIcon, payIcon, dueIcon;

    /**
     * Default constructor for ExpensesTreeCellRenderer.
     */
    public ProjectsTreeCellRenderer() {
        /* Initialize icons. */
        initializeIcons();
    }

    /**
     * Initialize image icons.
     */
    private void initializeIcons() {
        projectIcon = new ImageIcon(getClass().getResource("../resources/icProject.png"));
        pointsIcon = new ImageIcon(getClass().getResource("../resources/icFunctionPoints.png"));
        remainingPointsIcon = new ImageIcon(getClass().getResource("../resources/icRemainingPoints.png"));
        payIcon = new ImageIcon(getClass().getResource("../resources/icPay.png"));
        dueIcon = new ImageIcon(getClass().getResource("../resources/icDue.png"));
    }

    /**
     * Get tree cell renderer component prepended by defined icon.
     *
     * @param tree
     * @param value
     * @param sel
     * @param expanded
     * @param leaf
     * @param row
     * @param hasFocus
     * @return
     */
    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value,
            boolean sel,
            boolean expanded,
            boolean leaf, int row,
            boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

        /* Set icons for nodes. */
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
        if (node.getLevel() > 1) {
            int index = node.getParent().getIndex(node);
            switch (index) {
                case 0:
                    setIcon(pointsIcon);
                    break;
                case 1:
                    setIcon(remainingPointsIcon);
                    break;
                case 2:
                    setIcon(payIcon);
                    break;
                case 3:
                    setIcon(dueIcon);
                    break;
            }
        } else {
            setIcon(projectIcon);
        }

        return this;
    }
}
