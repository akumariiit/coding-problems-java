package com.dogacoder.www.tree;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * The diameter of a tree (sometimes called the width) is the number of edges on the longest path between two end nodes.
 * The diameter of a tree T is the largest of the following quantities:
 * * the diameter of T’s left subtree
 * * the diameter of T’s right subtree
 * * the longest path between leaves that goes through the root of T (this can be computed from the heights of the subtrees of T)
 *
 */
public class Diameter {

    public int getDiameter(Node node) {
        return diameter(node)-1;

    }

    private int diameter(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = BinaryTreeUtil.getHeight(node.getLeft());
        int rightHeight = BinaryTreeUtil.getHeight(node.getRight());

        int leftDiameter = diameter(node.getLeft());
        int rightDiameter = diameter(node.getRight());

        return Math.max(leftHeight+rightHeight+1, Math.max(leftDiameter, rightDiameter));
    }

    @Test
    public void test() {
        BinaryTree binaryTree = BinaryTreeUtil.createBinaryTree();
        assertEquals(getDiameter(binaryTree.getRoot()), 3);
    }
}
