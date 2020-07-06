package com.dogacoder.www.educative.dynamic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * Given two integer arrays to represent weights and profits of ‘N’ items,
 * we need to find a subset of these items which will give us maximum profit
 * such that their cumulative weight is not more than a given number ‘C’.
 * We can assume an infinite supply of item quantities; therefore, each item can be selected multiple times.
 *
 */
public class UnboundedKnapsack {
    public int solveKnapsack(int[] p, int[] w, int c) {
        return calcRecur(p, w, c, 0);
    }

    private int calcRecur(int[] p, int[] w, int c, int i) {
        if (p.length == 0 || i >= p.length || c <= 0 || p.length != w.length) {
            return 0;
        }
        int exc = calcRecur(p, w, c, i+1);
        int inc = 0;
        if (w[i] <= c) {
            // Not increment index to consider all possible count for item at i
            inc = p[i] + calcRecur(p, w, c-w[i], i);
        }
        return Math.max(inc, exc);
//        int max = exc;
//        if (w[i] <= c) {
//            int taken = 1;
//            int times = 1;
//            while (taken*w[i] <= c) {
//                int inc = (times * p[i]) + calcRecur(p, w, c-taken*w[i], i);
//                max = Math.max(inc, exc);
//                System.out.println("inc == " + inc + " exc == " + exc + " : Max == " + max);
//                taken += 1;
//                times += 1;
//            }
//        }
//        return max;
    }

    @Test
    public void test() {
        int[] p = {15,20,50};
        int[] w = {1,2,3};
        int c = 5;
        assertEquals(solveKnapsack(p, w, c), 80);
    }

    @Test
    public void test2() {
        int[] p = { 15, 50, 60, 90 };
        int[] w = { 1, 3, 4, 5} ;
        int c = 8;
        assertEquals(solveKnapsack(p, w, c), 140);
    }

    public int solveKnapsackTopDown(int[] p, int[] w, int c) {
        Integer[][] dp = new Integer[p.length][c+1];
        return calcRecurTopDown(p, w, c, 0, dp);
    }

    private int calcRecurTopDown(int[] profit, int[] weight, int capacity, int index, Integer[][] dp) {
        if (index >= profit.length || profit.length == 0 || weight.length != profit.length || capacity <= 0) {
            return 0;
        }
        if (null == dp[index][capacity]) {
            int exc = calcRecurTopDown(profit, weight, capacity, index+1, dp);
            int inc = 0;
            if (weight[index] <= capacity) {
                inc = profit[index] + calcRecurTopDown(profit, weight, capacity - weight[index], index, dp);
            }
            dp[index][capacity] = Math.max(inc, exc);
        }
        return dp[index][capacity];
    }

    @Test
    public void test3() {
        int[] p = {15,20,50};
        int[] w = {1,2,3};
        int c = 5;
        assertEquals(solveKnapsackTopDown(p, w, c), 80);
    }

    @Test
    public void test4() {
        int[] p = { 15, 50, 60, 90 };
        int[] w = { 1, 3, 4, 5} ;
        int c = 8;
        assertEquals(solveKnapsackTopDown(p, w, c), 140);
    }
}
