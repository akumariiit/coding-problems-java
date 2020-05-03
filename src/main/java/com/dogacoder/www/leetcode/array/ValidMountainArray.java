package com.dogacoder.www.leetcode.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }
        int in = -1;
        for (int i = 1; i < A.length-1; i++) {
            if (A[i] > A[i-1] && A[i] > A[i+1]) {
                in = i;
                break;
            }
        }
        if (in == -1) {
            return false;
        }
        for (int i = 0; i < in; i++) {
            if (A[i+1] <= A[i]) {
                return false;
            }
        }
        for (int i = in; i < A.length-1; i++) {
            if (A[i+1] >= A[i]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        int[] a = {0, 3, 2, 1};
        System.out.println(validMountainArray(a));
        assertTrue(validMountainArray(a));
    }
}
