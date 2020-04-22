package com.dogacoder.www.leetcode.thirtydays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3307/
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 *
 * Example 1:
 *
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 *
 * Note:
 *
 *     The length of the array is in range [1, 20,000].
 *     The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 *
 *
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        int[] sumArray = new int[nums.length];
        sumArray[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sumArray[i] = sumArray[i-1] + nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if ((sumArray[j] - sumArray[i] + nums[i])  == k) {
                    ans++;
                }
            }
        }
        return ans;
    }

    @Test
    public void test() {
        int[] input = {1,1,1};
        assertEquals(subarraySum(input, 2), 2);
    }
}
