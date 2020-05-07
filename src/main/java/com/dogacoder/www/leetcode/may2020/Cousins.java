package com.dogacoder.www.leetcode.may2020;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://leetcode.com/explore/challenge/card/May-Leetcoding-challenge/534/week-1-may-1st-may-7th/3322/
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
 *
 * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
 *
 * We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
 *
 * Return true if and only if the nodes corresponding to the values x and y are cousins.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [1,2,3,4], x = 4, y = 3
 * Output: false
 *
 * Example 2:
 *
 * Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
 * Output: true
 *
 * Example 3:
 *
 * Input: root = [1,2,3,null,4], x = 2, y = 3
 * Output: false
 *
 *
 *
 * Note:
 *
 *     The number of nodes in the tree will be between 2 and 100.
 *     Each node has a unique integer value from 1 to 100.
 *
 */
public class Cousins {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        List<TreeNode> first = new ArrayList<>();
        List<TreeNode> second = new ArrayList<>();
        populate(root, x, first);
        populate(root, y, second);

        int l1 = first.size();
        int l2 = second.size();

        if (l1 != l2) {
            return false;
        }
        l1--;
        l2--;
        int count = 0;
        while (l1 >= 0 && l2 >= 0) {
            if (first.get(l1--) != second.get(l2--)) {
                count++;
            }
            if (count > 1) {
                return true;
            }
        }
        return false;
    }

    private boolean populate(TreeNode root, int x, List<TreeNode> list) {
        if (root == null) {
            return false;
        }
        if (root.val == x || populate(root.left, x, list) || populate(root.right, x, list)) {
            list.add(root);
            return true;
        }
        return false;
    }
}
