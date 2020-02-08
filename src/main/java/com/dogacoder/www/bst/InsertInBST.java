package com.dogacoder.www.bst;

import com.dogacoder.www.tree.BinaryTree;
import com.dogacoder.www.tree.BinaryTreeUtil;
import com.dogacoder.www.tree.Node;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InsertInBST {

    public void insertInBST(Node root, int key) {
        if (key > root.getData() && root.getRight() == null) {
            root.setRight(new Node(key));
            return;
        }
        if (key < root.getData() && root.getLeft() == null) {
            root.setLeft(new Node(key));
            return;
        }
        if (key < root.getData()) {
            insertInBST(root.getLeft(), key);
        }
        else {
            insertInBST(root.getRight(), key);
        }
    }
    @Test
    public void insertTest() {
        BinaryTree bst = BinaryTreeUtil.createBinarySearchTree();
        int height = BinaryTreeUtil.getHeight(bst.getRoot());
        assertEquals(height, 3);
        insertInBST(bst.getRoot(), 16);
        int newHeight = BinaryTreeUtil.getHeight(bst.getRoot());
        assertEquals(newHeight, 4);
    }
}
