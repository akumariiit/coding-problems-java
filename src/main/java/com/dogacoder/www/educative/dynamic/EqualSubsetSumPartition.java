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
        return canDivide(nums, 0, k);
    }

    private boolean canDivide(int[] nums, int i, int sum) {
        if (sum == 0) {
            return true;
        }
        if (i >= nums.length) {
            return false;
        }

        boolean inc = false;
        if (nums[i] <= sum) {
            inc = canDivide(nums, i+1, sum-nums[i]);
        }
        if (inc) {
            return true;
        }
        boolean excluding = canDivide(nums,i+1, sum);
        return excluding;
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

    // Top down with memoization
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
        Boolean[][] dp = new Boolean[nums.length][k+1];
        return canDivideMemo(nums, k, 0, dp);
    }

    private boolean canDivideMemo(int[] nums, int sum, int i, Boolean[][] dp) {
        if (sum == 0) {
            return true;
        }
        if (i >= nums.length) {
            return false;
        }
        if (dp[i][sum] != null) {
            return dp[i][sum] ;
        }

        if (nums[i] <= sum) {
            boolean inc = canDivideMemo(nums, sum-nums[i], i+1, dp);
            if (inc) {
                return dp[i][sum] = true;
            }
        }
        boolean excluding = canDivideMemo(nums, sum,i+1, dp);
        return dp[i][sum] = excluding;
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

    // bottom up with state
    public boolean equalSubsetBottomUp(int[] nums) {
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
        int n = nums.length;
        boolean[][] dp = new boolean[nums.length][k+1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        for (int i = 0; i <= k; i++) {
            if(nums[0] == i) {
                dp[0][i] = true;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int s = 1; s <= k; s++) {
                // excluding i
                boolean excluding  = dp[i-1][s];
                // including i
                if (excluding) {
                    dp[i][s] = true;
                    continue;
                }
                boolean including = false;
                if (nums[i] <= s) {
                    including = dp[i-1][s-nums[i]];
                }
                dp[i][s] = including;
            }
        }
        return dp[n-1][k];
    }

    @Test
    public void test7() {
        int[] p = {1,2,3,4};
        assertTrue(equalSubsetBottomUp(p));
    }

    @Test
    public void test8() {
        int[] p = {1, 1, 3, 4, 7};
        assertTrue(equalSubsetBottomUp(p));
    }

    @Test
    public void test9() {
        int[] p = {2, 3, 4, 6};
        assertFalse(equalSubsetBottomUp(p));
    }
}
