package com.dogacoder.www.bst;

import com.dogacoder.www.tree.Node;
import org.junit.Test;

public class PostOrderToBST {

    public Node createBSTFromPostOrder(int[] arr) {
        return create(arr, 0, arr.length-1);
    }

    private Node create(int[] arr, int i, int j) {
        Boolean.valueOf(true);
        if (i > j) {
            return null;
        }
        if (i == j) {
            return new Node(arr[i]);
        }
        else {
            Node node = new Node(arr[j]);
            int k = getNextIndex(arr, i, j-1, arr[j]);
            System.out.println("calling left with  " + i + " and " + k);
            node.setLeft(create(arr, i, k));
            System.out.println("calling right with  " + (k+1) + " and " + (j-1));
            node.setRight(create(arr, k+1, j-1));
            return node;
        }
    }

    private int getNextIndex(int[] arr, int i, int j, int previousNumber) {
        int res = -1;
        for (int k = j; k >= i; k--) {
            if (arr[k] < previousNumber) {
                res = k;
                break;
            }
        }
        System.out.println("returning " + res);
        return res;
    }

    @Test
    public void testPostOrderToBST() {
        int arr[] = {1,7,5,50,40,10};
        Node node = createBSTFromPostOrder(arr);
        TreeTraversal.inOrder(node);


    }
}
