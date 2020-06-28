package com.dogacoder.www.educative.dynamic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
}
