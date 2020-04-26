package com.dogacoder.www.leetcode.thirtydays;


import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3283/
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,1]
 * Output: 1
 *
 * Example 2:
 *
 * Input: [4,1,2,1,2]
 * Output: 4
 *
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
            if (countMap.get(nums[i]) == 2) {
                countMap.remove(nums[i]);
            }
        }
        int[] ans = {-1};
        countMap.forEach((key, value) -> {
            if (value == 1) {
                ans[0] = key;
                return;
            }
        });

        return ans[0];
    }

    @Test
    public void test() {
        int[] nums = {1,1,2};
        System.out.println(singleNumber(nums));
    }
}
