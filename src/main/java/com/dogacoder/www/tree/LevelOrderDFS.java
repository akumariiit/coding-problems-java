package com.dogacoder.www.tree;

public class LevelOrderDFS {
    public static void main(String[] args) {
        pringLevels(BinaryTreeUtil.createBinaryTree().getRoot());
    }
    public static void pringLevels(Node root) {
        int height = BinaryTreeUtil.getHeight(root);
        for (int i=1; i<=height; i++) {
            printGivenLevel(root, i);
        }
    }

    private static void printGivenLevel(Node root, int i) {
        if (root == null) {
            return;
        }
        if (i == 1) {
            System.out.println(root.getData());
        }
        else if (i > 1) {
            printGivenLevel(root.getLeft(), i - 1);
            printGivenLevel(root.getRight(), i - 1);
        }
    }
}
