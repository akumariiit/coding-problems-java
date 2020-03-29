package com.dogacoder.www.array;

import org.junit.jupiter.api.Test;

public class MaxSumContiguousSubarray {

    public int find(int[] input) {
        int n = input.length;

        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = input[i];
        }

        int max = Integer.MIN_VALUE;
        for (int k = 1; k < n; k++) {
            if (s[k-1]+input[k] > input[k]) {
                s[k] = s[k-1]+input[k];
            }
        }

        for (int i = 0; i < n; i++) {
            max = Math.max(s[i], max);
        }
        return max;
    }

    @Test
    public void test() {
        int[] input = {1, 2, 3, 4, -10};
        int[] b = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(find(b));
    }
}
