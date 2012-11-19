/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.view.models;

import devfortress.model.Project;
import devfortress.utilities.Constant;
import java.util.Enumeration;
import java.util.List;
import java.util.ListIterator;
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
        setRoot(new DefaultMutableTreeNode("Projects"));
    }

    /**
     * Set project list.
     *
     * @param projects
     */
    public void setProjects(List<Project> projects) {
        DefaultMutableTreeNode rootNode = (DefaultMutableTreeNode) root;
        rootNode.removeAllChildren();
        
        /* Loop through project list to update data. */
        for (ListIterator<Project> iterator = projects.listIterator();
                iterator.hasNext();) {
            boolean isNew = true;

            /* Get current project and its name. */
            Project project = iterator.next();
            String name = project.getName();

            /* Loop through project tree. */
            for (Enumeration<DefaultMutableTreeNode> enumeration = rootNode.children();
                    isNew && enumeration.hasMoreElements();) {
                /* Get current node and its value. */
                DefaultMutableTreeNode node = enumeration.nextElement();
                String value = (String) node.getUserObject();

                /* If project existed, update it. */
                if (name.equals(value)) {
                    isNew = false;
                    DefaultMutableTreeNode child =
                            (DefaultMutableTreeNode) node.getChildAt(0);
                    child.setUserObject(String.format("%s: %d",
                            Constant.PROJECT_POINTS, project.getTotalPoints()));
                    child = (DefaultMutableTreeNode) node.getChildAt(1);
                    child.setUserObject(String.format("%s: %d Points",
                            Constant.PROJECT_REMAINING_POINTS,
                            project.getRemainingPoints()));
                    child = (DefaultMutableTreeNode) node.getChildAt(2);
                    child.setUserObject(String.format("%s: $%.2f",
                            Constant.PROJECT_PAY, project.getPayment()));
                    child = (DefaultMutableTreeNode) node.getChildAt(3);
                    child.setUserObject(String.format("%s: %d Months",
                            Constant.PROJECT_DUE,
                            project.getRemainingTime().getMonths()));
                }
            }

            /* If project not existed, add new project to tree. */
            /*points,remaining,pay,due.*/
            if (isNew) {
                DefaultMutableTreeNode node = new DefaultMutableTreeNode(name);
                insertNodeInto(node, rootNode, rootNode.getChildCount());
                DefaultMutableTreeNode child =
                        new DefaultMutableTreeNode(String.format("%s: %d",
                        Constant.PROJECT_POINTS, project.getTotalPoints()));
                insertNodeInto(child, node, node.getChildCount());
                child = new DefaultMutableTreeNode(String.format("%s: %d Points",
                        Constant.PROJECT_REMAINING_POINTS, project.getRemainingPoints()));
                insertNodeInto(child, node, node.getChildCount());
                child = new DefaultMutableTreeNode(String.format("%s: $%.2f",
                        Constant.PROJECT_PAY, project.getPayment()));
                insertNodeInto(child, node, node.getChildCount());
                child = new DefaultMutableTreeNode(String.format("%s: %d Months",
                        Constant.PROJECT_DUE, project.getRemainingTime().getMonths()));
                insertNodeInto(child, node, node.getChildCount());
            }
        }
    }
}
