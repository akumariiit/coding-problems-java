package com.dogacoder.www.educative.dynamic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * Given a set of positive numbers, partition the set into two subsets with a minimum difference between their subset sums.
 * Example 1: #
 *
 * Input: {1, 2, 3, 9}
 * Output: 3
 * Explanation: We can partition the given set into two subsets where minimum absolute difference
 * between the sum of numbers is '3'. Following are the two subsets: {1, 2, 3} & {9}.
 *
 * Example 2: #
 *
 * Input: {1, 2, 7, 1, 5}
 * Output: 0
 * Explanation: We can partition the given set into two subsets where minimum absolute difference
 * between the sum of number is '0'. Following are the two subsets: {1, 2, 5} & {7, 1}.
 *
 * Example 3: #
 *
 * Input: {1, 3, 100, 4}
 * Output: 92
 * Explanation: We can partition the given set into two subsets where minimum absolute difference
 * between the sum of numbers is '92'. Here are the two subsets: {1, 3, 4} & {100}.
 *
 */
public class MinimumSubsetSumDifference {

    // brute force
    public int minDiff(int[] nums) {
        return calc(nums, 0, 0, 0);
    }

    private int calc(int[] nums, int index, int sum1, int sum2) {
        if (index == nums.length) {
            return Math.abs(sum1-sum2);
        }

        int diff1 = calc(nums, index+1, sum1+nums[index], sum2);
        int diff2 = calc(nums, index+1, sum1, sum2+nums[index]);
        return Math.min(diff1, diff2);
    }

    @Test
    public void test() {
        int[] p = {1, 2, 3, 9};
        assertEquals(minDiff(p), 3);
    }

    @Test
    public void test2() {
        int[] p = {1, 2, 7, 1, 5};
        assertEquals(minDiff(p), 0);
    }

    @Test
    public void test3() {
        int[] p = {1, 3, 100, 4};
        assertEquals(minDiff(p), 92);
    }

    public int minDiffTopDownMemo(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum+=num;
        }
        Integer[][] dp = new Integer[n][sum+1];
        return calcTopDownMemo(nums, 0, 0, 0, dp);
    }

    private int calcTopDownMemo(int[] nums, int index, int sum1, int sum2, Integer[][] dp) {
        if (index == nums.length) {
            return Math.abs(sum1 - sum2);
        }

        int diff = Math.abs(sum1-sum2);
        if (dp[index][diff] == null) {
            int diff1 = calcTopDownMemo(nums, index+1, sum1+nums[index], sum2, dp);
            int diff2 = calcTopDownMemo(nums, index+1, sum1, sum2+nums[index], dp);
            return dp[index][diff] = Math.min(diff1, diff2);
        }
        else {
            return dp[index][diff];
        }

    }

    @Test
    public void test4() {
        int[] p = {1, 2, 3, 9};
        assertEquals(minDiffTopDownMemo(p), 3);
    }

    @Test
    public void test5() {
        int[] p = {1, 2, 7, 1, 5};
        assertEquals(minDiffTopDownMemo(p), 0);
    }

    @Test
    public void test6() {
        int[] p = {1, 3, 100, 4};
        assertEquals(minDiffTopDownMemo(p), 92);
    }
}
