package com.dogacoder.www.leetcode.tree;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/537/
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 *
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 *
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        return isSumRecur(root, sum, 0);
    }

    private boolean isSumRecur(TreeNode root, int sum, int value) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && sum == value+root.val) {
            return true;
        }
        return isSumRecur(root.left, sum, value+root.val) || isSumRecur(root.right, sum, value+root.val);
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(hasPathSum(root, 6));
        assertTrue(hasPathSum(root, 6));
    }

}
