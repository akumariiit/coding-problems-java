package com.dogacoder.www.leetcode.array;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        int n = nums.length;

        for (int i=0; i<nums.length; i++) {
            int index = nums[i]-1;
            if (index >= n) {
                index = index - n;
            }
            if (nums[index] <= n) {
                nums[index] = nums[index] + n;
            }
        }

        for (int i=0; i<nums.length; i++) {
            if (nums[i] <= n) {
                list.add(i+1);
            }
        }
        return list;
    }

    @Test
    public void test() {
        int[] a = {4,3,2,7,8,2,3,1};
        assertEquals(findDisappearedNumbers(a).size(), 2);
    }
}
