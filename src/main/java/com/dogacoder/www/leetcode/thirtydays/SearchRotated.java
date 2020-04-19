package com.dogacoder.www.leetcode.thirtydays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 */
public class SearchRotated {

    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        return search(nums, target, low, high);
    }

    private int search(int[] nums, int target, int low, int high) {
        if (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (target < nums[mid]) {
                if (target < nums[low] && nums[low] <= nums[mid]) {
                    return search(nums, target, mid+1, high);
                }
                else {
                    return search(nums, target, low, mid-1);
                }
            }
            else {
                if (nums[high] < target && nums[high] >= nums[mid]) {
                    return search(nums, target, low, mid-1);
                }
                else {
                    return search(nums, target, mid+1, high);
                }
            }
        }
        return -1;
    }

    @Test
    public void test() {
        int[] nums = {4,5,6,7,0,1,2};
        int index = search(nums, 0);
        assertEquals(index, 4);
    }

    @Test
    public void test2() {
        int[] nums = {4,5,6,7,0,1,2};
        int index = search(nums, 3);
        assertEquals(index, -1);
    }

    @Test
    public void test3() {
        int[] nums = {5,1,3};
        int index = search(nums, 5);
        assertEquals(index, 0);
    }

    @Test
    public void test4() {
        int[] nums = {1,3};
        int index = search(nums, 3);
        assertEquals(index, 1);
    }

    @Test
    public void test5() {
        int[] nums = {4,5,6,7,8,1,2,3};
        int index = search(nums, 8);
        assertEquals(index, 4);
    }

    @Test
    public void test6() {
        int[] nums = {5,1,2,3,4};
        int index = search(nums, 1);
        assertEquals(index, 1);
    }
}
