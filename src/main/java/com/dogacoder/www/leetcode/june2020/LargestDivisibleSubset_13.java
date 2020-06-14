package com.dogacoder.www.leetcode.june2020;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 *
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3359/
 * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:
 *
 * Si % Sj = 0 or Sj % Si = 0.
 *
 * If there are multiple solutions, return any subset is fine.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: [1,2] (of course, [1,3] will also be ok)
 *
 * Example 2:
 *
 * Input: [1,2,4,8]
 * Output: [1,2,4,8]
 *
 */
public class LargestDivisibleSubset_13 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(nums[i]);
            ans.add(temp);
        }
        int[] s = new int[nums.length];
        s[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i]%nums[j] == 0 && s[j]+1 > s[i]) {
                    s[i] = s[j] + 1;
                    List<Integer> temp = new ArrayList<>(ans.get(j));
                    temp.add(nums[i]);
                    ans.set(i, temp);
                }
            }
        }

        int index = 0;
        int size = ans.get(0).size();
        for (int i = 1; i < nums.length; i++) {
            if (ans.get(i).size() > size) {
                size = ans.get(i).size();
                index = i;
            }
        }
        return ans.get(index);
    }

    @Test
    public void test() {
        int[] a = {1,2,3};
        List<Integer> list = largestDivisibleSubset(a);
        list.forEach(System.out::println);
        assertEquals(list.size(), 2);
    }

    @Test
    public void test2() {
        int[] a = {3,4,16,8};
        List<Integer> list = largestDivisibleSubset(a);
        list.forEach(System.out::println);
        assertEquals(list.size(), 3);
    }
}
