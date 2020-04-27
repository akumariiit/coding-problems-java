package com.dogacoder.www.leetcode.thirtydays;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3289/
 * Given an integer array arr, count element x such that x + 1 is also in arr.
 *
 * If there're duplicates in arr, count them seperately.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,2,3]
 * Output: 2
 * Explanation: 1 and 2 are counted cause 2 and 3 are in arr.
 *
 * Example 2:
 *
 * Input: arr = [1,1,3,3,5,5,7,7]
 * Output: 0
 * Explanation: No numbers are counted, cause there's no 2, 4, 6, or 8 in arr.
 *
 * Example 3:
 *
 * Input: arr = [1,3,2,3,5,0]
 * Output: 3
 * Explanation: 0, 1 and 2 are counted cause 1, 2 and 3 are in arr.
 *
 * Example 4:
 *
 * Input: arr = [1,1,2,2]
 * Output: 2
 * Explanation: Two 1s are counted cause 2 is in arr.
 *
 *
 *
 * Constraints:
 *
 *     1 <= arr.length <= 1000
 *     0 <= arr[i] <= 1000
 *
 */
public class CountingElements {
    public int countElements(int[] arr) {
        int res = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            countMap.put(arr[i], countMap.getOrDefault(arr[i], 0)+1);
        }
        for (int i = 0; i < arr.length; i++) {
            int element = arr[i]+1;
            if (countMap.containsKey(element) && countMap.get(element) > 0) {
                res++;
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] arr = {1,2,3};
        assertEquals(countElements(arr), 2);
    }

    @Test
    public void test2() {
        int[] arr = {1,1,3,3,5,5,7,7};
        assertEquals(countElements(arr), 0);
    }

    @Test
    public void test3() {
        int[] arr = {1,3,2,3,5,0};
        assertEquals(countElements(arr), 3);
    }

    @Test
    public void test4() {
        int[] arr = {1,1,2,2};
        assertEquals(countElements(arr), 2);
    }

    @Test
    public void test5() {
        int[] arr = {1,1,2};
        assertEquals(countElements(arr), 2);
    }
}
