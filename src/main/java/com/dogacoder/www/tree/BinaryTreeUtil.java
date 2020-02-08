package com.dogacoder.www.tree;

public class BinaryTreeUtil {

    public static void main(String[] args) {
        BinaryTree binaryTree = createBinaryTree();
        System.out.println(getHeight(binaryTree.getRoot()));
    }

    public static int getHeight(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.getLeft());
        int rightHeight = getHeight(root.getRight());
        if ((leftHeight) > (rightHeight)) {
            return 1+leftHeight;
        }
        else {
            return 1+rightHeight;
        }
    }

    public static BinaryTree createBinaryTree() {
        BinaryTree tree = new BinaryTree();
        tree.setRoot(new Node(1));
        tree.getRoot().setLeft(new Node(2));
        tree.getRoot().setRight(new Node(3));
        tree.getRoot().getLeft().setLeft(new Node(4));
        tree.getRoot().getLeft().setRight(new Node(5));
        return tree;
    }

    public static BinaryTree createBinarySearchTree() {

        BinaryTree tree = new BinaryTree();
        tree.setRoot(new Node(8));
        tree.getRoot().setLeft(new Node(3));
        tree.getRoot().setRight(new Node(10));
        tree.getRoot().getLeft().setLeft(new Node(2));
        tree.getRoot().getLeft().setRight(new Node(5));
        tree.getRoot().getRight().setLeft(new Node(9));
        tree.getRoot().getRight().setRight(new Node(15));
        return tree;
    }
}
