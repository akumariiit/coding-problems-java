package com.dogacoder.www.aws;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        final Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            countMap.put(A[i], countMap.getOrDefault(A[i], 0)+1);
        }

        int maxElement = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getKey() == entry.getValue()) {
                System.out.println("adding " + entry.getKey());
                if (entry.getKey() >= maxElement) {
                    maxElement = entry.getKey();
                }
            }
        }
        return maxElement;
    }

    @Test
    public void test() {
        int input[] = {3, 8, 2, 3, 3, 2};
        int input1[] = {7, 1, 2, 8, 2};
        int input2[] = {1, 1, 1, 1, 1, 2,2,2,2,3,3,3,4,4,4,4};
        System.out.println(solution(input2));
        //assertTrue(solution(input) == 3);
    }
}
