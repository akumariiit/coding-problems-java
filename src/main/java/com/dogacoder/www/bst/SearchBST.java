package com.dogacoder.www.bst;
import com.dogacoder.www.tree.BinaryTree;
import com.dogacoder.www.tree.BinaryTreeUtil;
import com.dogacoder.www.tree.Node;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class SearchBST {

    public Node search(Node root, int key) {
        if ( root == null || root.getData() == key) {
            return root;
        }
        if (root.getData() > key) {
            return search(root.getLeft(), key);
        }
        return search(root.getRight(), key);
    }

    @Test
    public void testKeyPresentInBST() {
        BinaryTree bst = BinaryTreeUtil.createBinarySearchTree();
        assertTrue(search(bst.getRoot(), 5) != null);
        assertEquals(search(bst.getRoot(), 5).getData(), 5);
    }

    @Test
    public void testKeyNotPresentInBST() {
        BinaryTree bst = BinaryTreeUtil.createBinarySearchTree();
        assertTrue(search(bst.getRoot(), 16) == null);
    }
}
