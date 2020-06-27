package com.dogacoder.www.educative.dynamic;


import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * Given two integer arrays to represent weights and profits of ‘N’ items,
 * we need to find a subset of these items which will give us maximum profit such that
 * their cumulative weight is not more than a given number ‘C’.
 * Each item can only be selected once, which means either we put an item in the knapsack or we skip it.
 *
 */
public class ZeroOneKnapsack {

    // brute force recursively
    public int maxProfit(int[] p, int[] w, int capacity) {
        if (p.length == 0) {
            return 0;
        }
        int n = p.length;
        return calc(p, w, capacity, n, 0);
    }

    private int calc(int[] p, int[] w, int capacity, int n, int index) {
        if (index >= n || capacity <= 0) {
            return 0;
        }
        // profit by including or excluding current index
        int inc = 0;
        if (w[index] <= capacity) {
            inc = p[index] + calc(p, w, capacity-w[index], n, index+1);
        }
        int exc = calc(p, w, capacity, n, index+1);

        return Math.max(inc, exc);
    }

    public int maxProfitTopDown(int[] p, int[] w, int capacity) {
        Map<String, Integer> map = new HashMap<>();
        if (p.length == 0) {
            return 0;
        }
        int n = p.length;
        return calcTopDown(p, w, capacity, n, 0 , map);
    }

    private int calcTopDown(int[] p, int[] w, int capacity, int n, int index, Map<String, Integer> map) {
        if (index >= n || capacity <= 0) {
            return 0;
        }
        // if we have already solved a similar problem, return the result from memory
        if (map.containsKey(capacity + "," + index)) {
            return map.get(capacity + "," + index);
        }
        // recursive call after choosing the element at the currentIndex
        // if the weight of the element at currentIndex exceeds the capacity, we shouldn't process this
        int inc = 0;
        if (w[index] <= capacity) {
            inc = p[index] + calcTopDown(p, w, capacity-w[index], n, index+1, map);
        }
        // recursive call after excluding the element at the currentIndex
        int exc = calcTopDown(p, w, capacity, n, index+1, map);
        map.put(capacity + "," + index, Math.max(inc, exc));
        return map.get(capacity + "," + index);
    }

    public int maxProfitBottomUp(int[] p, int[] w, int capacity) {
        if (p.length == 0) {
            return 0;
        }
        int[][] dp = new int[p.length][capacity+1];
        // populate the capacity=0 columns, with '0' capacity we have '0' profit
        // if we have only one weight, we will take it if it is not more than the capacity
        for (int i = 0; i < p.length; i++) {
            for (int c = 0; c <= capacity; c++) {
                if (c == 0) {
                    dp[i][c] = 0;
                }
                if (i == 0) {
                    dp[i][c] = c >= w[i] ? p[i] : 0;
                }
            }
        }

        // another way commented out

        /*
        for(int i=0; i < p.length; i++)
            dp[i][0] = 0;
        for(int c=0; c <= capacity; c++) {
            if(w[0] <= c)
                dp[0][c] = p[0];
        }
         */

        for (int i = 1; i < p.length; i++) {
            for (int c = 1; c <= capacity; c++) {
                int inc = 0;
                // include the item, if it is not more than the capacity
                if (c >= w[i]) {
                    inc = p[i] + dp[i-1][c-w[i]];
                }
                // exclude the item
                int exc = dp[i-1][c];
                // take maximum
                dp[i][c] = Math.max(inc, exc);

            }
        }
        // maximum profit will be at the bottom-right corner.
        printTaken(w, p, dp, capacity);
        return dp[p.length-1][capacity];
    }

    private void printTaken(int[] w, int[] p, int[][] dp, int capacity) {
        int totalProfit = dp[w.length-1][capacity];
        for (int i = w.length-1; i > 0; i--) {
            if (totalProfit != dp[i-1][capacity]) {
                System.out.println(w[i]);
                capacity -= w[i];
                totalProfit -= p[i];
            }
        }
        if (totalProfit != 0) {
            System.out.println(w[0]);
        }
    }


    @Test
    public void test() {
        int[] p = {4,5, 3, 7};
        int[] w = {2,3,1,4};
        int c = 5;
        assertEquals(maxProfit(p, w, c), 10);
    }

    @Test
    public void testTopDown() {
        int[] p = {4,5, 3, 7};
        int[] w = {2,3,1,4};
        int c = 5;
        assertEquals(maxProfitTopDown(p, w, c), 10);
    }

    @Test
    public void testBottomUp() {
        int[] p = {4,5,3,7};
        int[] w = {2,3,1,4};
        int c = 5;
        assertEquals(maxProfitBottomUp(p, w, c), 10);
    }
}
