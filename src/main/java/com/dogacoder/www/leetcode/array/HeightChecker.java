package com.dogacoder.www.leetcode.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeightChecker {
    public int heightChecker(int[] heights) {
        int[] second = new int[heights.length];
        for (int i=0; i<heights.length; i++) {
            second[i] = heights[i];
        }
        Arrays.sort(second);
        int ans = 0;
        for (int i=0; i<heights.length; i++) {
            if (heights[i] != second[i]) {
                ans++;
            }
        }
        return ans;
    }

    @Test
    public void test() {
        int[] a = {1,1,4,2,1,3};
        assertEquals(heightChecker(a), 3);
    }


}
