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
public class ProjectsTreeModel extends DefaultTreeModel {

    /**
     * Constructor for ProjectsTreeModel.
     *
     * @param root
     */
    public ProjectsTreeModel(TreeNode root) {
        super(root);
        DefaultMutableTreeNode node = new DefaultMutableTreeNode("Projects");
        this.root = node;
        this.insertNodeInto(new DefaultMutableTreeNode("Project 1"), node, node.getChildCount());
    }
}
