package com.dogacoder.www.leetcode.tree;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * https://leetcode.com/problems/validate-binary-search-tree/
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 *     The left subtree of a node contains only nodes with keys less than the node's key.
 *     The right subtree of a node contains only nodes with keys greater than the node's key.
 *     Both the left and right subtrees must also be binary search trees.
 *
 *
 *
 * Example 1:
 *
 *     2
 *    / \
 *   1   3
 *
 * Input: [2,1,3]
 * Output: true
 *
 * Example 2:
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 *
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 */
public class isBST {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.left.val >= root.val) {
            return false;
        }
        if (root.right != null && root.right.val <= root.val) {
            return false;
        }
        if (root.right == null && root.left == null) {
            return true;
        }
        int fromLeft = getMax(root.left);
        int fromRight = getMin(root.right);
        System.out.println("from left " + fromLeft + " from right " + fromRight);
        return fromLeft < root.val && fromRight > root.val && isValidBST(root.left) && isValidBST(root.right);
    }

    private int getMax(TreeNode node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        if (node.right == null && node.left == null) {
            return node.val;
        }
        return Math.max(getMax(node.left), getMax(node.right));
    }
    private int getMin(TreeNode node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }
        if (node.right == null && node.left == null) {
            return node.val;
        }
        return Math.min(getMin(node.left), getMin(node.right));
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(-12);
        root.left = null;
        root.right = new TreeNode(85);
        root.right.left = new TreeNode(50);
        assertTrue(isValidBST(root));
    }
}
