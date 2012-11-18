/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.view.renderers;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 *
 * @author tommy
 */
public class ExpensesTreeCellRenderer extends DefaultTreeCellRenderer {

    /* Declare image icons for nodes. */
    ImageIcon icon;

    /**
     * Default constructor for ExpensesTreeCellRenderer.
     */
    public ExpensesTreeCellRenderer() {
        /* Initialize icons. */
        initializeIcons();
    }

    /**
     * Initialize image icons.
     */
    private void initializeIcons() {
        icon = new ImageIcon(getClass().getResource("../resources/icExpenses.png"));
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
        setIcon(icon);

        return this;
    }
}
