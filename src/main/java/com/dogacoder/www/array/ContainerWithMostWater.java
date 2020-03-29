package com.dogacoder.www.array;


import org.junit.jupiter.api.Test;

/**
 *
 * Given n non-negative integers a1, a2, ..., an,
 * where each represents a point at coordinate (i, ai).
 * 'n' vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 *
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Your program should return an integer which corresponds to the maximum area of water that can be contained ( Yes, we know maximum area instead of maximum volume sounds weird. But this is 2D plane we are working with for simplicity ).
 *
 *     Note: You may not slant the container.
 *
 * Example :
 *
 * Input : [1, 5, 4, 3]
 * Output : 6
 *
 * Explanation : 5 and 3 are distance 2 apart. So size of the base = 2. Height of container = min(5, 3) = 3.
 * So total area = 3 * 2 = 6
 *
 */
public class ContainerWithMostWater {

    public int maxArea(int[] in) {
        int area = 0;
        int n = in.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                area = Math.max(area, (j-i) * Math.min(in[i], in[j]));
            }
        }
        return area;
    }

    public int maxAreaUsingPointers(int[] A) {
        int n = A.length;
        int area = 0;
        int left = 0;
        int right = n-1;
        while (left < right) {
            area = Math.max(area, (right - left)* Math.min(A[left], A[right]));
            int lArea = (right - (left+1))* Math.min(A[left+1], A[right]);;
            int rArea = ((right-1) - left)* Math.min(A[left], A[right-1]);;;

            if (lArea > rArea) {
                left++;
            }
            else {
                right--;
            }
        }
        return area;
    }

    @Test
    public void test() {
        int[] input = {1, 5, 4, 3};
        System.out.println(maxAreaUsingPointers(input));
    }
}
