package com.dogacoder.www.array;

import java.util.Arrays;

/**
 * Write a function:
 *
 *     class Solution { public int solution(int[] A); }
 *
 * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 *
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 *
 * Given A = [1, 2, 3], the function should return 4.
 *
 * Given A = [−1, −3], the function should return 1.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 *         N is an integer within the range [1..100,000];
 *         each element of array A is an integer within the range [−1,000,000..1,000,000].
 */
public class SmallestMissing {

    public static int solution(int[] A) {
        Arrays.sort(A);
        int firstPositiveIndex = getIndexOfFirstPositive(A);
        int arraySize = A.length;
        if ((firstPositiveIndex == -1) || (A[firstPositiveIndex] > 1)) {
            return 1;
        }
        int missingPositiveNumber = A[arraySize - 1];
        for (int i = firstPositiveIndex + 1; i < A.length; i++) {
            if (A[i] > 0 && (A[i] - A[i-1]) > 1 ) {
                missingPositiveNumber = A[i-1] + 1;
                return missingPositiveNumber;
            }
        }
        if (missingPositiveNumber == A[arraySize - 1]) {
            return A[arraySize - 1] + 1;
        }
        return missingPositiveNumber;
    }

    private static int getIndexOfFirstPositive(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] A =  {1, 2, 3};
        System.out.println(solution(A));
    }
}
