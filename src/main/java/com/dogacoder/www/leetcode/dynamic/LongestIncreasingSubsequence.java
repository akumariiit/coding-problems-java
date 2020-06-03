package com.dogacoder.www.leetcode.dynamic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * https://leetcode.com/problems/longest-increasing-subsequence/
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * Example:
 *
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 *
 * Note:
 *
 *     There may be more than one LIS combination, it is only necessary for you to return the length.
 *     Your algorithm should run in O(n2) complexity.
 *
 * Follow up: Could you improve it to O(n log n) time complexity?
 *
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] s = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            s[i] = 1;
        }
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && s[i] < s[j] + 1) {
                    s[i] = s[j] + 1;
                    if (s[i] > res) {
                        res = s[i];
                    }
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(s[i]);
        }
        return res == 0 ? 1 : res;
    }

    @Test
    public void test() {
        int[] a = {10,9,2,5,3,7,101,18};
        assertEquals(lengthOfLIS(a), 4);
    }

    @Test
    public void test2() {
        int[] a = {-2, -1};
        assertEquals(lengthOfLIS(a), 2);
    }

}
