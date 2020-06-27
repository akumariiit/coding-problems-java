package com.dogacoder.www.educative.dynamic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * Given a set of positive numbers, find if we can partition it into two subsets such that the sum of elements in both the subsets is equal.
 * Example 1: #
 *
 * Input: {1, 2, 3, 4}
 * Output: True
 * Explanation: The given set can be partitioned into two subsets with equal sum: {1, 4} & {2, 3}
 *
 * Example 2: #
 *
 * Input: {1, 1, 3, 4, 7}
 * Output: True
 * Explanation: The given set can be partitioned into two subsets with equal sum: {1, 3, 4} & {1, 7}
 *
 * Example 3: #
 *
 * Input: {2, 3, 4, 6}
 * Output: False
 * Explanation: The given set cannot be partitioned into two subsets with equal sum.
 *
 */
public class EqualSubsetSumPartition {

    // brute force recursively
    public boolean equalSubset(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum%2 == 1) {
            return false;
        }
        int k = sum/2;
        return canDevide(nums, k, 0, nums[0]);
    }

    private boolean canDevide(int[] nums, int k, int i, int sum) {
        if (sum == k) {
            return true;
        }
        if (i >= nums.length || sum > k) {
            return false;
        }

        boolean inc = false;
        if (sum + nums[i] <= k) {
            inc = canDevide(nums, k, i+1, sum+nums[i]);
        }
        boolean excluding = canDevide(nums, k, i+1, sum);
        return inc || excluding;
    }

    @Test
    public void test() {
        int[] p = {1,2,3,4};
        assertTrue(equalSubset(p));
    }

    @Test
    public void test2() {
        int[] p = {1, 1, 3, 4, 7};
        assertTrue(equalSubset(p));
    }

    @Test
    public void test3() {
        int[] p = {2, 3, 4, 6};
        assertFalse(equalSubset(p));
    }

    // brute force recursively
    public boolean equalSubsetTopDownMemo(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum%2 == 1) {
            return false;
        }
        int k = sum/2;
        boolean[][] dp = new boolean[nums.length][sum];
        return canDevideMemo(nums, k, 0, nums[0], dp);
    }

    private boolean canDevideMemo(int[] nums, int k, int i, int sum, boolean[][] dp) {
        if (sum == k) {
            dp[i][sum] = true;
            return true;
        }
        if (i >= nums.length || sum > k) {
            return false;
        }
        if (dp[i][sum]) {
            return true;
        }

        boolean inc = false;
        if (sum + nums[i] <= k) {
            inc = canDevide(nums, k, i+1, sum+nums[i]);
        }
        boolean excluding = canDevide(nums, k, i+1, sum);
        dp[i][sum] = inc || excluding;
        return dp[i][sum];
    }

    @Test
    public void test4() {
        int[] p = {1,2,3,4};
        assertTrue(equalSubsetTopDownMemo(p));
    }

    @Test
    public void test5() {
        int[] p = {1, 1, 3, 4, 7};
        assertTrue(equalSubsetTopDownMemo(p));
    }

    @Test
    public void test6() {
        int[] p = {2, 3, 4, 6};
        assertFalse(equalSubsetTopDownMemo(p));
    }
}
