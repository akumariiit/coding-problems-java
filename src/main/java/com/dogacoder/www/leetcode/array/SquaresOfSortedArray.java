package com.dogacoder.www.leetcode.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SquaresOfSortedArray {
    public int[] sortedSquares(int[] A) {
        for (int i=0; i<A.length; i++) {
            if (A[i] < 0) {
                A[i] = -A[i];
            }
            else {
                break;
            }
        }
        Arrays.sort(A);
        for (int i=0; i<A.length; i++) {
            A[i] = A[i] * A[i];
        }
        return A;
    }

    @Test
    public void test() {
        int[] a = {1, 2, 3};
        System.out.println(sortedSquares(a));
    }
}
