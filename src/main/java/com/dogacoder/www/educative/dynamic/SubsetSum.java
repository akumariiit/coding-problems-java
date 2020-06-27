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
        return canDivide(nums, 0, s);
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

    // Top down with memoization
    public boolean subsetExistsTopDown(int[] nums, int sum) {
        if (nums.length == 0) {
            return false;
        }
        Boolean[][] dp = new Boolean[nums.length][sum+1];
        return canDivideMemo(nums, 0, sum, dp);
    }

    private boolean canDivideMemo(int[] nums, int i, int sum, Boolean[][] dp) {
        if (sum == 0) {
            return true;
        }
        if (sum < 0 || i >= nums.length) {
            return false;
        }
        if (dp[i][sum] == null) {
            // including current element
            boolean inc = false;
            if (nums[i] <= sum) {
                inc = canDivideMemo(nums, i+1, sum-nums[i], dp);
                if (inc) {
                    return dp[i][sum] = true;
                }
            }
            // excluding current element
            return dp[i][sum] = canDivideMemo(nums, i+1, sum, dp);
        }
        else {
            return dp[i][sum];
        }
    }

    @Test
    public void test4() {
        int[] p = {1,2,3,4};
        assertTrue(subsetExistsTopDown(p, 6));
    }

    @Test
    public void test5() {
        int[] p = {1, 2, 7, 1, 5};
        assertTrue(subsetExistsTopDown(p, 10));
    }

    @Test
    public void test6() {
        int[] p = {1, 3, 4, 8};
        assertFalse(subsetExistsTopDown(p, 6));
    }
}
