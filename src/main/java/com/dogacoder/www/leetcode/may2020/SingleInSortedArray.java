package com.dogacoder.www.leetcode.may2020;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 *
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3327/
 * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.
 *
 *
 *
 * Example 1:
 *
 * Input: [1,1,2,3,3,4,4,8,8]
 * Output: 2
 *
 * Example 2:
 *
 * Input: [3,3,7,7,10,11,11]
 * Output: 10
 *
 *
 *
 * Note: Your solution should run in O(log n) time and O(1) space.
 *
 */
public class SingleInSortedArray {
    public int singleNonDuplicate(int[] nums) {
        return findSingle(nums, 0, nums.length-1);
    }

    private int findSingle(int[] nums, int start, int end) {
        if (start < end) {
            int mid = start + (end-start)/2;
            if ((mid == 0 && nums[mid] != nums[mid+1]) ||
                    (mid == nums.length-1 && nums[mid] != nums[mid-1]) ||
                    (nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1])) {
                return nums[mid];
            }
            int first = -1;
            int sec = -1;
            if (nums[mid] == nums[mid-1]) {
                first = mid-1;
                sec = mid;
            }
            else if (nums[mid] == nums[mid+1]) {
                first = mid;
                sec = mid+1;
            }
            if (first%2 == 0) {
                return findSingle(nums, mid+1, end);
            }
            else {
                return findSingle(nums, start, mid-1);
            }
        }
        return nums[start];
    }

    @Test
    public void test() {
        int[] a = {1,1,2,3,3,4,4,8,8};
        assertTrue(singleNonDuplicate(a) == 2);
    }
}
