package com.dogacoder.www.leetcode.may2020;

import java.util.ArrayList;
import java.util.List;

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
