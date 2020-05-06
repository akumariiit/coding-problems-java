package com.dogacoder.www.leetcode.tree;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/932/
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 *
 *
 * Example 1:
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 *
 * Example 2:
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 *
 *
 *
 * Note:
 *
 *     All of the nodes' values will be unique.
 *     p and q are different and both values will exist in the binary tree.
 *
 */
public class LCABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        List<TreeNode> first = new ArrayList<>();
        List<TreeNode> second = new ArrayList<>();
        populate(root, p, first);
        populate(root, q, second);
        int i = first.size() - 1;
        int j = second.size() -1;
        TreeNode temp = first.get(i);
        while (i >= 0 && j >=0) {
            if (first.get(i) == second.get(j)) {
                temp = first.get(i);
                i--;
                j--;
            }
            else {
                return temp;
            }
        }
        if (i < 0) {
            return first.get(0);
        }
        return second.get(0);
    }

    private boolean populate(TreeNode root, TreeNode q, List<TreeNode> arr) {
        if (root == null) {
            return false;
        }
        if (root.val == q.val) {
            arr.add(root);
            return true;
        }
        if (root.val == q.val || populate(root.left, q, arr) || populate(root.right, q, arr)) {
            arr.add(root);
            return true;
        }
        return false;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    public TreeNode lowestCommonAncestor_Optimized(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        TreeNode p = new TreeNode(15);
        TreeNode q = new TreeNode(7);
        root.right.left = p;
        root.right.right = q;
        System.out.println(lowestCommonAncestor(root, p, q));
    }
}
