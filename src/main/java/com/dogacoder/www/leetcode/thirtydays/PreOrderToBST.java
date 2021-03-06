package com.dogacoder.www.leetcode.thirtydays;

/**
 *
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3305/
 * Return the root node of a binary search tree that matches the given preorder traversal.
 *
 * (Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)
 *
 * It's guaranteed that for the given test cases there is always possible to find a binary search tree with the given requirements.
 *
 * Example 1:
 *
 * Input: [8,5,1,7,10,12]
 * Output: [8,5,10,1,7,null,12]
 *
 *
 *
 * Constraints:
 *
 *     1 <= preorder.length <= 100
 *     1 <= preorder[i] <= 10^8
 *     The values of preorder are distinct.
 *
 */


public class PreOrderToBST {
    public TreeNode bstFromPreorder(int[] preorder) {
        return createBST(preorder, 0, preorder.length-1);
    }

    private TreeNode createBST(int[] preorder, int l, int r) {
        if (l == r) {
            return new TreeNode(preorder[l]);
        }
        if (l > r) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[l]);
        int newIndex = findNewIndex(preorder, preorder[l], l, r);
        System.out.println("new index = " + newIndex);
        node.left = createBST(preorder, l+1, newIndex);
        node.right = createBST(preorder, newIndex+1, r);
        return node;
    }

    private int findNewIndex(int[] preorder, int val, int l, int r) {
        int index = l;
        for (int i = l+1; i <= r; i++) {
            if (preorder[i] < val) {
                index++;
            }
            else {
                break;
            }
        }
        return index;
    }


    class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
    }
}


