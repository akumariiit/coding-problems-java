package com.dogacoder.www.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class InOrder {
    public List<Integer> inorderTraversal(TreeNode root) {
        return inOrder(root);
    }

    private List<Integer> inOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        List<Integer> list = new ArrayList<>();
        list.addAll(inOrder(root.left));
        list.add(root.val);
        list.addAll(inOrder(root.right));
        return list;
    }
}
