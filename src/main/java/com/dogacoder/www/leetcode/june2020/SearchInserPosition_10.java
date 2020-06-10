package com.dogacoder.www.leetcode.june2020;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * https://leetcode.com/explore/featured/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3356/
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Example 1:
 *
 * Input: [1,3,5,6], 5
 * Output: 2
 *
 * Example 2:
 *
 * Input: [1,3,5,6], 2
 * Output: 1
 *
 * Example 3:
 *
 * Input: [1,3,5,6], 7
 * Output: 4
 *
 * Example 4:
 *
 * Input: [1,3,5,6], 0
 * Output: 0
 *
 */
public class SearchInserPosition_10 {
    public int searchInsert(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);

        if (index < 0) {
            return helper(nums, 0, nums.length-1, target);
        }
        return index;
    }

    private int helper(int[] nums, int start, int end, int target) {
        if (start <= end) {
            if (nums[start] > target) {
                return start;
            }
            if (nums[end] < target) {
                return end+1;
            }
            int mid = start + (end-start)/2;
            if (nums[mid] < target) {
                return helper(nums, mid+1, end, target);
            } else {
                return helper(nums, start, mid-1, target);
            }
        }
        return -1;
    }

    @Test
    public void test1() {
        int[] c = {1,3,5,7};
        assertEquals(searchInsert(c, 2), 1);
    }
}
