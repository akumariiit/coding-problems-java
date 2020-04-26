package com.dogacoder.www.leetcode.thirtydays;


/**
 *
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3286/
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 *
 * Note:
 *
 *     You must do this in-place without making a copy of the array.
 *     Minimize the total number of operations.
 *
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int curr = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != 0) {
                nums[curr] = nums[i];
                if (curr != i) {
                    nums[i] = 0;
                }
                curr++;
            }
            i++;
        }
    }
}
