package com.dogacoder.www.leetcode.thirtydays;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/530/week-3/3300/
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 *
 * Example:
 *
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 *
 * Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.
 *
 * Note: Please solve it without division and in O(n).
 *
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 *
 */
public class ProductArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int excludingProduct = nums[0];
        output[0] = excludingProduct;
        for (int i = 1; i < nums.length; i++) {
            output[i] = excludingProduct;
            excludingProduct *= nums[i];
        }
        excludingProduct = nums[nums.length-1];
        for (int j = nums.length-2; j > 0; j--) {
            output[j] = output[j]*excludingProduct;
            excludingProduct *= nums[j];
        }
        output[0] = excludingProduct;
        return output;
    }

    @Test
    public void test() {
        int[] nums = {1,2,3,4};
        int[] out = productExceptSelf(nums);
        for (int i = 0; i < out.length; i++) {
            System.out.println(out[i]);
        }
    }

    @Test
    public void test1() {
        int[] nums = {2,2,2,2};
        int[] out = productExceptSelf(nums);
        for (int i = 0; i < out.length; i++) {
            System.out.println(out[i]);
        }
    }
}
