package com.dogacoder.www.bst;

import com.dogacoder.www.tree.BinaryTree;
import com.dogacoder.www.tree.BinaryTreeUtil;
import com.dogacoder.www.tree.Node;
import org.junit.Test;

public class TreeTraversal {
    public static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.getLeft());
            System.out.print(root.getData()+",");
            inOrder(root.getRight());
        }
    }

    public static void postOrder(Node root) {
        if (root != null) {
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.print(root.getData()+",");
        }
    }

    public static void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.getData() + ",");
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    @Test
    public void testAll() {
        BinaryTree bst = BinaryTreeUtil.createBinarySearchTree();
        inOrder(bst.getRoot());
        System.out.println();
        postOrder(bst.getRoot());
        System.out.println();
        preOrder(bst.getRoot());
        System.out.println();
    }
}
