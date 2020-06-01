package com.dogacoder.www.leetcode.june2020;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3347/
 * Invert a binary tree.
 *
 * Example:
 *
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * Trivia:
 * This problem was inspired by this original tweet by Max Howell:
 *
 *     Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.
 *
 */
public class InvertBinaryTree_1 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        TreeNode newRoot = invertTree(root);
        System.out.println(newRoot.val);
        System.out.println(newRoot.left.val);
        System.out.println(newRoot.right.val);
        System.out.println(newRoot.left.left.val);
        System.out.println(newRoot.left.right.val);
        System.out.println(newRoot.right.left.val);
        System.out.println(newRoot.right.right.val);
        assertEquals(newRoot.val, 4);
        assertEquals(newRoot.left.val, 7);
        assertEquals(newRoot.right.val, 2);
        assertEquals(newRoot.left.left.val, 9);
        assertEquals(newRoot.left.right.val, 6);
        assertEquals(newRoot.right.left.val, 3);
        assertEquals(newRoot.right.right.val, 1);

    }
}
