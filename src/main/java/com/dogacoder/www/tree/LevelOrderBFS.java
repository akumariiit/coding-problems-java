package com.dogacoder.www.tree;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static junit.framework.TestCase.assertTrue;

public class LevelOrderBFS {

    public void printTreeBFS(Node root) {
        if (root == null) {
            return;
        }
        Node temp = root;
        Queue<Node> queue = new LinkedList<>();
        while (temp != null) {
            System.out.println(temp.getData());
            if (temp.getLeft() != null) {
                queue.add(temp.getLeft());
            }
            if (temp.getRight() != null) {
                queue.add(temp.getRight());
            }
            temp = queue.poll();
        }

    }

    @Test
    public void printTreeBFSTest() {
        BinaryTree binaryTree = BinaryTreeUtil.createBinaryTree();
        printTreeBFS(binaryTree.getRoot());
        assertTrue(binaryTree != null);
    }

}
