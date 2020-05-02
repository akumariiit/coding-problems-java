package com.dogacoder.www.leetcode.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 *
 * https://leetcode.com/explore/featured/card/fun-with-arrays/521/introduction/3240/
 * Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
 *
 *
 *
 * Example 1:
 *
 * Input: [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 *
 * Example 2:
 *
 * Input: [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 *
 *
 *
 * Note:
 *
 *     1 <= A.length <= 10000
 *     -10000 <= A[i] <= 10000
 *     A is sorted in non-decreasing order.
 *
 */
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
