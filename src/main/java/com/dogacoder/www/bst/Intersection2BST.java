package com.dogacoder.www.bst;

import com.dogacoder.www.tree.BinaryTree;
import com.dogacoder.www.tree.BinaryTreeUtil;
import com.dogacoder.www.tree.Node;
import org.junit.Test;

public class Intersection2BST {

    public void printIntersection(Node root1, Node root2) {
        if (root1 == null || root2 == null) {
            return;
        }
        if (root1.getData() == root2.getData()) {
            System.out.println(root1.getData());
            printIntersection(root1.getLeft(), root2.getLeft());
            printIntersection(root1.getRight(), root2.getRight());
        }
        if (root1.getData() > root2.getData()) {
            printIntersection(root1.getLeft(), root2);
            printIntersection(root1, root2.getRight());
        }
        if (root1.getData() < root2.getData()) {
            printIntersection(root1, root2.getLeft());
            printIntersection(root1.getRight(), root2);
        }
    }

    @Test
    public void testIntersection() {
        BinaryTree bst1 = BinaryTreeUtil.createBinarySearchTree();
        BinaryTree bst2 = BinaryTreeUtil.createBinarySearchTree();
        printIntersection(bst1.getRoot(), bst2.getRoot());
        int i = 5;
        if (i <= 5) {
            System.out.println("second " + i);
        }
        else if (i == 5) {
            System.out.println("first" + i);
        }
        else {
            System.out.println("not found");
        }
    }
}
