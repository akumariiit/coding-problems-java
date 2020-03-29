package com.dogacoder.www.array;


import org.junit.jupiter.api.Test;

import java.util.TreeSet;

/**
 *
 * Find the longest increasing subsequence of a given array of integers, A.
 *
 * In other words, find a subsequence of array in which the subsequence’s elements are in strictly increasing order,
 * and in which the subsequence is as long as possible.
 * This subsequence is not necessarily contiguous, or unique.
 * In this case, we only care about the length of the longest increasing subsequence.
 *
 * Input Format:
 *
 * The first and the only argument is an integer array A.
 *
 * Output Format:
 *
 * Return an integer representing the length of the longest increasing subsequence.
 *
 * Constraints:
 *
 * 1 <= length(A) <= 2500
 * 1 <= A[i] <= 2000
 *
 * Example :
 *
 * Input 1:
 *     A = [1, 2, 1, 5]
 *
 * Output 1:
 *     3
 *
 * Explanation 1:
 *     The sequence : [1, 2, 5]
 *
 * Input 2:
 *     A = [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]
 *
 * Output 2:
 *     6
 *
 * Explanation 2:
 *     The sequence : [0, 2, 6, 9, 13, 15] or [0, 4, 6, 9, 11, 15] or [0, 4, 6, 9, 13, 15]
 *
 */
public class LongestSubSequence {

    public int longest(int[] A) {
        if(A.length < 2) {
            return A.length;
        }

        int maxLen = 1;
        TreeSet<Integer> set = new TreeSet<>();
        for(int num : A) {
            Integer next = set.ceiling(num);
            if(next != null) {
                System.out.println("removing "  + next);
                set.remove(next);
            }

            System.out.println("Adding " + num);
            set.add(num);
            System.out.println("Set now: " + set);
            maxLen = Math.max(maxLen, set.size());
        }
        return maxLen;
    }

    public int longestDP(int[] input) {
        int[] state = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            state[i] = 1;
        }

        int max = 1;

        for (int k = 1; k < input.length; k++ ) {
            for (int j = 0; j < k ; j++) {
                if (input[k] > input[j] && state[j] + 1 > state[k]) {
                    state[k] = state[j] + 1;
                    max = Math.max(max, state[k]);
                }
            }
        }
        return max;
    }

    private void print(int[] state) {
        for (int j = 0; j < state.length ; j++) {
            System.out.print(" " + state[j] + " ");
        }
    }

    @Test
    public void test() {
        int[] A = {1, 2, 1, 5};

        int[] B = {30, 92, 22, 48, 52, 64, 92, 50, 85, 38, 97, 15, 14, 75, 59, 46, 74, 6, 95, 67, 86, 88, 25, 49, 67, 69, 50, 99, 83, 49, 60, 6, 90, 1, 50, 41, 57, 18, 36, 5, 44, 100, 23, 33, 52, 11, 46, 49, 34, 27, 77, 57, 93, 82, 38, 95, 6, 51, 100, 32, 11, 26, 50, 3, 55, 39, 84, 54, 44, 75, 76, 51, 21, 40, 28, 50, 30, 6, 84, 58, 76, 42, 35, 49, 98, 49, 13, 101, 3, 1, 60, 48, 99, 70};
        System.out.println(longest(B));
    }

    @Test
    public void testDP() {
        int[] A = {1, 2, 1, 5};

        int[] B = {30, 92, 22, 48, 52, 64, 92, 50, 85, 38, 97, 15, 14, 75, 59, 46, 74, 6, 95, 67, 86, 88, 25, 49, 67, 69, 50, 99, 83, 49, 60, 6, 90, 1, 50, 41, 57, 18, 36, 5, 44, 100, 23, 33, 52, 11, 46, 49, 34, 27, 77, 57, 93, 82, 38, 95, 6, 51, 100, 32, 11, 26, 50, 3, 55, 39, 84, 54, 44, 75, 76, 51, 21, 40, 28, 50, 30, 6, 84, 58, 76, 42, 35, 49, 98, 49, 13, 101, 3, 1, 60, 48, 99, 70};
        int res = longestDP(B);
        System.out.println();
        System.out.println(res);
    }
}
