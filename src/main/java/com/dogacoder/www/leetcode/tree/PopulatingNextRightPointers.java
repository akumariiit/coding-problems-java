package com.dogacoder.www.leetcode.tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointers {

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        Node temp = null;
        while (!queue.isEmpty()) {
            Node node = queue.peek();
            if (node == null) {
                queue.poll();
                if (queue.size() > 0) {
                    queue.add(null);
                }
                temp = null;
            }
            else {
                if (temp != null) {
                    temp.next = queue.peek();
                }
                temp = queue.poll();
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
        return root;
    }

    public Node connect_optimized(Node root) {
        if(root == null) {
            return root;
        }
        Node level = root;
        while(level != null) {
            Node curr = level;
            while(curr != null) {
                if(curr.left != null && curr.right != null) {
                    curr.left.next = curr.right;
                }
                if(curr.next != null && curr.right != null) {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            level = level.left;
        }
        return root;
    }

}
