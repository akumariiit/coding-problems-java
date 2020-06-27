package com.dogacoder.www.educative.dynamic;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * Given a set of positive numbers, determine if there exists a subset whose sum is equal to a given number ‘S’.
 *
 */
public class SubsetSum {

    // brute force recursively
    public boolean subsetExists(int[] nums, int s) {
        if (nums.length == 0) {
            return false;
        }
        return canDevide(nums, 0, s);
    }

    private boolean canDevide(int[] nums, int i, int sum) {
        if (sum == 0) {
            return true;
        }
        if (i >= nums.length) {
            return false;
        }

        boolean inc = false;
        if (nums[i] <= sum) {
            inc = canDevide(nums, i+1, sum-nums[i]);
        }
        if (inc) {
            return true;
        }
        boolean excluding = canDevide(nums,i+1, sum);
        return excluding;
    }

    @Test
    public void test() {
        int[] p = {1,2,3,4};
        assertTrue(subsetExists(p, 6));
    }

    @Test
    public void test2() {
        int[] p = {1, 2, 7, 1, 5};
        assertTrue(subsetExists(p, 10));
    }

    @Test
    public void test3() {
        int[] p = {1, 3, 4, 8};
        assertFalse(subsetExists(p, 6));
    }
}
