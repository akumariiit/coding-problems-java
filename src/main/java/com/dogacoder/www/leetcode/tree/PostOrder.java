package com.dogacoder.www.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class PostOrder {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        List<Integer> list = new ArrayList<>();
        list.addAll(postorderTraversal(root.left));
        list.addAll(postorderTraversal(root.right));
        list.add(root.val);
        return list;
    }
}
