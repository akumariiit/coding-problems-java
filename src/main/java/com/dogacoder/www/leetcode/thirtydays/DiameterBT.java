package com.dogacoder.www.leetcode.thirtydays;


/**
 *
 *  Given a binary tree, you need to compute the length of the diameter of the tree.
 *  The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * Example:
 * Given a binary tree
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 *
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 * Note: The length of path between two nodes is represented by the number of edges between them.
 *
 */
public class DiameterBT {

    public int diameterOfBinaryTree(TreeNode root) {
        int diameter = 0;
        diameter = findDiameter(root)-1;
        return diameter;

    }

    private int findDiameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lHeight = height(root.left);
        int rHeight = height(root.right);

        int lD = findDiameter(root.left);
        int rD = findDiameter(root.right);


        return Math.max(1+lHeight+rHeight, Math.max(lD, rD));
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }
}
