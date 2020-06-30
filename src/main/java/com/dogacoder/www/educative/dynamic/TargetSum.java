package com.dogacoder.www.educative.dynamic;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * Given a set of positive numbers (non zero) and a target sum ‘S’. Each number should be assigned either a ‘+’ or ‘-’ sign. We need to find out total ways to assign symbols to make the sum of numbers equal to target ‘S’.
 * Example 1: #
 *
 * Input: {1, 1, 2, 3}, S=1
 * Output: 3
 * Explanation: The given set has '3' ways to make a sum of '1': {+1-1-2+3} & {-1+1-2+3} & {+1+1+2-3}
 *
 * Example 2: #
 *
 * Input: {1, 2, 7, 1}, S=9
 * Output: 2
 * Explanation: The given set has '2' ways to make a sum of '9': {+1+2+7-1} & {-1+2+7+1}
 *
 */
public class TargetSum {

    // brute force. Time complexity 2 power N
    public int ways(int[] nums, int sum) {
        if (nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        return wayRecursive(nums, 0, 0, sum);
    }

    private int wayRecursive(int[] nums, int index, int currentSum, int sum) {
        if (index == nums.length && sum == currentSum) {
            return 1;
        }
        if (index >= nums.length) {
            return 0;
        }
        int excl = wayRecursive(nums, index+1, currentSum-nums[index], sum);
        int incl = wayRecursive(nums, index+1, currentSum+nums[index], sum);
        return excl+incl;
    }

    @Test
    public void test1() {
        int[] p = {1, 1, 2, 3};
        assertEquals(ways(p, 1), 3);
    }

    @Test
    public void test2() {
        int[] p = {1, 2, 7, 1};
        assertEquals(ways(p, 9), 2);
    }

    public int waysTopDownMemo(int[] nums, int sum) {
        if (nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        Integer[][] dp = new Integer[n][2*total+1];
        return wayRecursiveTopDownMemo(nums, 0, 0, sum, dp, total);
    }

    private int wayRecursiveTopDownMemo(int[] nums, int index, int currentSum, int sum, Integer[][] dp, int total) {
        if (index == nums.length && sum == currentSum) {
            return 1;
        }
        if (index >= nums.length) {
            return 0;
        }
        if (dp[index][currentSum+total] == null) {
            int excl = wayRecursiveTopDownMemo(nums, index+1, currentSum-nums[index], sum, dp, total);
            int incl = wayRecursiveTopDownMemo(nums, index+1, currentSum+nums[index], sum, dp, total);
            return dp[index][currentSum+total] = excl+incl;
        }
        return dp[index][currentSum+total];
    }

    @Test
    public void test3() {
        int[] p = {1, 1, 2, 3};
        assertEquals(waysTopDownMemo(p, 1), 3);
    }

    @Test
    public void test4() {
        int[] p = {1, 2, 7, 1};
        assertEquals(waysTopDownMemo(p, 9), 2);
    }
}
