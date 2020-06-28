package com.dogacoder.www.educative.dynamic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountOfSubsetSum {

    // Brute Force TC 2 Power N
    // At every index we are either including or excluding
    public int count(int[] nums, int sum) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        return countBruteForce(nums, 0, sum);
    }

    private int countBruteForce(int[] nums, int index, int sum) {
        if (sum == 0) {
            return 1;
        }
        if (sum < 0 || index >= nums.length) {
            return 0;
        }

        // excluding current index element
        int exc = countBruteForce(nums, index+1, sum);
        // including current index element
        int inc = 0;
        if (nums[index] <= sum) {
            inc = countBruteForce(nums, index+1, sum-nums[index]);
        }
        return inc+exc;
    }

    @Test
    public void test1() {
        int[] p = {1, 1, 2, 3};
        assertEquals(count(p, 4), 3);
    }

    @Test
    public void test2() {
        int[] p = {1, 2, 7, 1, 5};
        assertEquals(count(p, 9), 3);
    }
}
