package com.dogacoder.www.bst;

import com.dogacoder.www.tree.BinaryTree;
import com.dogacoder.www.tree.BinaryTreeUtil;
import com.dogacoder.www.tree.Node;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LCA {

    public Node findLCA(Node root, int n1, int n2) {
        if (root == null) {
            return null;
        }

        if (root.getData() > n2 && root.getData() > n1) {
            return findLCA(root.getLeft(), n1, n2);
        }
        if (root.getData() < n2 && root.getData() < n1) {
            return findLCA(root.getRight(), n1, n2);
        }
        return root;
    }

    @Test
    public void testLCA() {
        BinaryTree binaryTree = BinaryTreeUtil.createBinarySearchTree();
        assertEquals(findLCA(binaryTree.getRoot(), 3, 10).getData(), 8);
    }
}
