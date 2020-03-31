package com.dogacoder.www.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * Say you have an array, A, for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most 2 transactions.
 *
 * Return the maximum possible profit.
 *
 * Note: You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 *
 * Input Format:
 *
 * The first and the only argument is an integer array, A.
 *
 * Output Format:
 *
 * Return an integer, representing the maximum possible profit.
 *
 * Constraints:
 *
 * 1 <= length(A) <= 7e5
 * 1 <= A[i] <= 1e7
 *
 * Examples:
 *
 * Input 1:
 *     A = [1, 2, 1, 2]
 *
 * Output 1:
 *     2
 *
 * Explanation 1:
 *     Day 0 : Buy
 *     Day 1 : Sell
 *     Day 2 : Buy
 *     Day 3 : Sell
 *
 * Input 2:
 *     A = [7, 2, 4, 8, 7]
 *
 * Output 2:
 *     6
 *
 * Explanation 2:
 *     Day 1 : Buy
 *     Day 3 : Sell
 *
 */

public class BuySellStocks3 {
    public int maxProfit(final int[] A) {
        if (A.length <= 1) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int prof = 0;
        int prof1 = 0;
        int prof2 = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] > min) {
                prof += A[i] - min;

                if (prof >= prof1 && prof > prof2) {
                    prof2 = prof1;
                    prof1 = prof;
                }
                else if (prof < prof1 && prof >= prof2) {
                    prof2 = prof;
                }
                prof = 0;
            }
            min = A[i];
        }
        return prof1+prof2;
    }

    public int maxProfit2(final int[] A) {
        if (A.length <= 1) {
            return 0;
        }
        int buy1 = Integer.MAX_VALUE, buy2 = Integer.MAX_VALUE;
        int sell1 = 0, sell2 = 0;

        for (int i = 0; i < A.length; i++) {
            buy1 = Math.min(buy1, A[i]);
            sell1 = Math.max(sell1, A[i] - buy1);
            buy2 = Math.min(buy2, A[i] - sell1);
            sell2 = Math.max(sell2, A[i] - buy2);
        }

        return sell2;
    }

    @Test
    public void test() {
        int[] A = {7, 2, 4, 8, 7};
        int[] B = {1, 2, 1, 2};
        System.out.println(maxProfit(B));
        assertEquals(maxProfit(A), 6);
        assertEquals(maxProfit(B), 2);
    }
}
