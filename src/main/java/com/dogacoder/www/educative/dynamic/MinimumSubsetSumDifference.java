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


    // Using top down approach with Memoization
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

    /**
     *
     * Let’s assume ‘S’ represents the total sum of all the numbers. So what we are trying to achieve in this problem
     * is to find a subset whose sum is as close to ‘S/2’ as possible, because if we can partition the given set into
     * two subsets of an equal sum, we get the minimum difference i.e. zero. This transforms our problem to Subset Sum,
     * where we try to find a subset whose sum is equal to a given number-- ‘S/2’ in our case.
     * If we can’t find such a subset, then we will take the subset which has the sum closest to ‘S/2’.
     * This is easily possible, as we will be calculating all possible sums with every subset.
     *
     * Essentially, we need to calculate all the possible sums up to ‘S/2’ for all numbers.
     * So how do we populate the array db[TotalNumbers][S/2+1] in the bottom-up fashion?
     *
     * For every possible sum ‘s’ (where 0 <= s <= S/2), we have two options:
     *
     *     Exclude the number. In this case, we will see if we can get the sum ‘s’ from the subset excluding this number => dp[index-1][s]
     *     Include the number if its value is not more than ‘s’. In this case, we will see if we can find a subset to get the remaining sum => dp[index-1][s-num[index]]
     *
     * If either of the two above scenarios is true, we can find a subset with a sum equal to ‘s’. We should dig into this before we can learn how to find the closest subset.
     *
     * @param nums
     * @return minimum sum
     */
    public int minDiffBottomUp(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int n = nums.length;
        int k = sum/2;
        boolean[][] dp = new boolean[n][k+1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        for (int i = 0; i <= k; i++) {
            if (nums[0] == i) {
                dp[0][i] = true;
            }
        }

        // process all subsets for all sums
        for (int i = 1; i < n; i++) {
            for (int s = 1; s <= k; s++) {
                // boolean exc = dp[i-1][s];
                // if we can get the sum 's' without the number at index 'i'
                if (dp[i-1][s]) {
                    dp[i][s] = true;
                    continue;
                }
                // else include the number and see if we can find a subset to get the remaining sum
                if (nums[i] <= s) {
                    dp[i][s] = dp[i-1][s-nums[i]];
                }
            }
        }

        // find sum nearest to sum/2
        int index;
        for (index = k; index >= 0; index--) {
            if (dp[n-1][index]) {
                break;
            }
        }
        return Math.abs(index - (sum - index));
    }

    @Test
    public void test7() {
        int[] p = {1, 2, 3, 9};
        assertEquals(minDiffBottomUp(p), 3);
    }

    @Test
    public void test8() {
        int[] p = {1, 2, 7, 1, 5};
        assertEquals(minDiffBottomUp(p), 0);
    }

    @Test
    public void test9() {
        int[] p = {1, 3, 100, 4};
        assertEquals(minDiffBottomUp(p), 92);
    }
}
