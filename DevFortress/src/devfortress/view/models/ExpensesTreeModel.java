/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.view.models;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

/**
 *
 * @author tommy
 */
public class ExpensesTreeModel extends DefaultTreeModel {

    /**
     * Constructor for ExpensesTreeModel.
     *
     * @param root
     */
    public ExpensesTreeModel(TreeNode root) {
        super(root);
        this.root = new DefaultMutableTreeNode("Expenses");
    }
}
