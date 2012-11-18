/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.view.models;

import devfortress.utilities.Constant;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
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

        /* Init. */
        initialize();
    }

    /**
     * Initialize basic tree nodes.
     */
    private void initialize() {
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(
                String.format("%s: $%.2f", Constant.EXPENSE, 0f));
        setRoot(rootNode);
        insertNodeInto(new DefaultMutableTreeNode(String.format("%s: $%.2f",
                Constant.EXPENSE_SALARIES, 0f)), rootNode, root.getChildCount());
        insertNodeInto(new DefaultMutableTreeNode(String.format("%s: $%.2f",
                Constant.EXPENSE_ITEMS, 0f)), rootNode, root.getChildCount());
    }

    /**
     * Set total expense.
     *
     * @param totalExpense
     */
    public void setTotalExpense(float totalExpense) {
        DefaultMutableTreeNode rootNode = (DefaultMutableTreeNode) getRoot();
        rootNode.setUserObject(String.format("%s: $%.2f", Constant.EXPENSE,
                totalExpense));
    }

    /**
     * Set total salary expense.
     *
     * @param salaries
     */
    public void setSalaries(float salaries) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) getChild(root, 0);
        node.setUserObject(String.format("%s: $%.2f", Constant.EXPENSE_SALARIES,
                salaries));
    }

    /**
     * Get total expense for items.
     *
     * @param itemExpenses
     */
    public void setItemExpense(float itemExpenses) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) getChild(root, 1);
        node.setUserObject(String.format("%s: $%.2f", Constant.EXPENSE_ITEMS,
                itemExpenses));
    }

    /**
     * Set item expense.
     *
     * @param name
     * @param itemExpense
     */
    public void setExpenseItems(Map<String, Float> items) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) getChild(root, 1);
        /* Loop through item list. */
        for (Iterator<String> iterator = items.keySet().iterator(); iterator.hasNext();) {
            boolean isNew = true;

            /* Get item name and value. */
            String name = iterator.next();
            float itemExpense = items.get(name);

            /* Loop through item tree to update. */
            for (Enumeration<DefaultMutableTreeNode> enumeration = node.children();
                    isNew && enumeration.hasMoreElements();) {
                /* Get string content of each child item. */
                DefaultMutableTreeNode child = enumeration.nextElement();
                String content = (String) child.getUserObject();
                content = content.split(":")[0];

                /* If item existed, update value. */
                if (content.equals(name)) {
                    child.setUserObject(String.format("%s: $%.2f", name, itemExpense));
                    isNew = false;
                }
            }

            /* If item not existed, add new item to list. */
            if (isNew) {
                insertNodeInto(new DefaultMutableTreeNode(
                        String.format("%s: $%.2f", name, itemExpense)), node,
                        node.getChildCount());
            }
        }
    }
}
