package com.dogacoder.www.leetcode.may2020;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3321/\
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example 1:
 *
 * Input: [3,2,3]
 * Output: 3
 *
 * Example 2:
 *
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 *
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int n = nums.length;
        for (int e: nums) {
            countMap.put(e, countMap.getOrDefault(e, 0) + 1);
            if (countMap.get(e) > n/2) {
                return e;
            }
        }
        return -1;
    }

    // Boyer-Moore Voting Algorithm
    public int majorityElement_Optimized(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    @Test
    public void test() {
        int[] a = {3,2,3};
        assertEquals(majorityElement(a), 3);
    }
}
