package com.dogacoder.www.leetcode.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * return its minimum depth = 2.
 *
 */
public class MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null ) {
            return 0;
        }
        return helper(root);
    }
    private int helper(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE - 1;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int ld = 1 + helper(root.left);
        int rd = 1 + helper(root.right);
        return Math.min(ld, rd);
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        assertEquals(minDepth(root), 2);
    }

    @Test
    public void test2() {
        TreeNode root = null;
        assertEquals(minDepth(root), 0);
    }
}
