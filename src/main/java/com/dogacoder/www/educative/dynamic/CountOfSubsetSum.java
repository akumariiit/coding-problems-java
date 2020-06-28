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

    // using memoization in top down approach
    // Time and Space complexity O(N*SUM) Since we are calculating for each subarray and for each sum

    public int countTopDownMemo(int[] nums, int sum) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        Integer[][] dp = new Integer[n][sum+1];
        return countTopDownRecur(nums, 0, sum, dp);
    }

    private int countTopDownRecur(int[] nums, int index, int sum, Integer[][] dp) {
        if (sum == 0) {
            return 1;
        }
        if (index >= nums.length || sum < 0) {
            return 0;
        }
        if (dp[index][sum] == null) {
            // excluding
            dp[index][sum] = countTopDownRecur(nums, index+1, sum, dp);
            // including
            if (nums[index] <= sum) {
                dp[index][sum] += countTopDownRecur(nums, index+1, sum-nums[index], dp);
            }
        }
        return dp[index][sum];
    }
    @Test
    public void test3() {
        int[] p = {1, 1, 2, 3};
        assertEquals(countTopDownMemo(p, 4), 3);
    }

    @Test
    public void test4() {
        int[] p = {1, 2, 7, 1, 5};
        assertEquals(countTopDownMemo(p, 9), 3);
    }

    // Time complexity O(N*Sum)
    // Space complexity O(N*Sum)
    /**
     *
     We will try to find if we can make all possible sums with every subset to populate the array db[TotalNumbers][S+1].
     So, at every step we have two options:

     1. Exclude the number. Count all the subsets without the given number up to the given sum => dp[index-1][sum]
     2. Include the number if its value is not more than the ‘sum’. In this case,
     we will count all the subsets to get the remaining sum => dp[index-1][sum-num[index]]

     To find the total sets, we will add both of the above two values:
     `dp[index][sum] = dp[index-1][sum] + dp[index-1][sum-num[index]])`

     **/

    public int countBottomUp(int[] nums, int sum) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[][] dp = new int[n][sum+1];
        for (int i = 0; i < n; i ++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= sum; i++) {
            dp[0][i] = (i == nums[0]) ? 1 : 0;
        }

        for (int i = 1; i < n; i++) {
            for (int s = 1; s <= sum; s++) {
                // excluding
                dp[i][s] = dp[i-1][s];
                // including
                if (s >= nums[i]) {
                    dp[i][s] += dp[i-1][s-nums[i]];
                }
            }
        }
        return dp[n-1][sum];
    }

    @Test
    public void test5() {
        int[] p = {1, 1, 2, 3};
        assertEquals(countBottomUp(p, 4), 3);
    }

    @Test
    public void test6() {
        int[] p = {1, 2, 7, 1, 5};
        assertEquals(countBottomUp(p, 9), 3);
    }

    // Time complexity O(N*Sum)
    // Space complexity O(Sum)
    /**
     *
     We will try to find if we can make all possible sums with every subset to populate the array db[TotalNumbers][S+1].
     So, at every step we have two options:

     1. Exclude the number. Count all the subsets without the given number up to the given sum => dp[index-1][sum]
     2. Include the number if its value is not more than the ‘sum’. In this case,
     we will count all the subsets to get the remaining sum => dp[index-1][sum-num[index]]

     To find the total sets, we will add both of the above two values:
     `dp[index][sum] = dp[index-1][sum] + dp[index-1][sum-num[index]])`

     **/

    public int countBottomUpSpaceOptimized(int[] nums, int sum) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[sum+1];
        dp[0] = 1;
        for (int i = 1; i <= sum; i++) {
            dp[i] = (i == nums[0]) ? 1 : 0;
        }

        for (int i = 1; i < n; i++) {
            for (int s = sum; s >= 0; s--) {
                // excluding
                dp[s] = dp[s];
                // including
                if (s >= nums[i]) {
                    dp[s] += dp[s-nums[i]];
                }
            }
        }
        return dp[sum];
    }

    @Test
    public void test7() {
        int[] p = {1, 1, 2, 3};
        assertEquals(countBottomUpSpaceOptimized(p, 4), 3);
    }

    @Test
    public void test8() {
        int[] p = {1, 2, 7, 1, 5};
        assertEquals(countBottomUpSpaceOptimized(p, 9), 3);
    }
}
