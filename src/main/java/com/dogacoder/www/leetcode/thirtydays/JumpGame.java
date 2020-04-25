package com.dogacoder.www.leetcode.thirtydays;


import org.junit.jupiter.api.Test;

import javax.print.attribute.standard.NumberUp;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/531/week-4/3310/
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * Example 1:
 *
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Example 2:
 *
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 *              jump length is 0, which makes it impossible to reach the last index.
 *
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        boolean[] state = new boolean[nums.length];
        if (nums[0] == 0 && nums.length > 1) {
            return false;
        }
        state[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int k = 0; k < i; k++) {
                if (state[k] && i-k <= nums[k]) {
                    state[i] = true;
                    break;
                }
            }
        }
        return state[nums.length-1];
    }

    @Test
    public void test() {
        int[] nums = {2,3,1,1,4};
        assertTrue(canJump(nums));
    }

    @Test
    public void test2() {
        int[] nums = {3,2,1,0,4};
        assertFalse(canJump(nums));
    }

    @Test
    public void test3() {
        int[] nums = {0};
        assertTrue(canJump(nums));
    }
}
