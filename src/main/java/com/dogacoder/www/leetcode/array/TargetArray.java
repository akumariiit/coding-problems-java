package com.dogacoder.www.leetcode.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * https://leetcode.com/problems/create-target-array-in-the-given-order/
 * Given two arrays of integers nums and index. Your task is to create target array under the following rules:
 *
 *     Initially target array is empty.
 *     From left to right read nums[i] and index[i], insert at index index[i] the value nums[i] in target array.
 *     Repeat the previous step until there are no elements to read in nums and index.
 *
 * Return the target array.
 *
 * It is guaranteed that the insertion operations will be valid.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1,2,3,4], index = [0,1,2,2,1]
 * Output: [0,4,1,3,2]
 * Explanation:
 * nums       index     target
 * 0            0        [0]
 * 1            1        [0,1]
 * 2            2        [0,1,2]
 * 3            2        [0,1,3,2]
 * 4            1        [0,4,1,3,2]
 *
 * Example 2:
 *
 * Input: nums = [1,2,3,4,0], index = [0,1,2,3,0]
 * Output: [0,1,2,3,4]
 * Explanation:
 * nums       index     target
 * 1            0        [1]
 * 2            1        [1,2]
 * 3            2        [1,2,3]
 * 4            3        [1,2,3,4]
 * 0            0        [0,1,2,3,4]
 *
 * Example 3:
 *
 * Input: nums = [1], index = [0]
 * Output: [1]
 *
 *
 *
 * Constraints:
 *
 *     1 <= nums.length, index.length <= 100
 *     nums.length == index.length
 *     0 <= nums[i] <= 100
 *     0 <= index[i] <= i
 *
 */
public class TargetArray {
    public int[] createTargetArray(int[] nums, int[] index) {
        int[] target = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            target[i] = -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (target[index[i]] != -1) {
                for (int j = nums.length - 2; j >= index[i]; j--) {
                    target[j+1] = target[j];
                }
            }
            target[index[i]] = nums[i];
        }
        return target;
    }

    @Test
    public void test() {
        int[] num = {0,1,2,3,4};
        int[] index = {0,1,2,2,1};
        int[] target = createTargetArray(num, index);
        for (int i = 0; i < target.length; i++) {
            System.out.println(target[i]);
        }
        assertEquals(target[0], 0);
        assertEquals(target[1], 4);
        assertEquals(target[2], 1);
        assertEquals(target[3], 3);
        assertEquals(target[4], 2);
    }
}
