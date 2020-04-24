package com.dogacoder.www.leetcode.thirtydays;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/531/week-4/3308/
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
 *
 * Example 1:
 *
 * Input: [5,7]
 * Output: 4
 *
 * Example 2:
 *
 * Input: [0,1]
 * Output: 0
 *
 */

public class BitwiseANDofNumbersRange {
    public int rangeBitwiseAnd2(int m, int n) {
        int res = 0;

        while (m > 0 && n > 0) {
            int msbPos1 = msbPos(m);
            int msbPos2 = msbPos(n);

            if (msbPos1 != msbPos2)
                break;

            int msb_val = (1 << msbPos1);
            res = res + msb_val;

            m = m - msb_val;
            n = n - msb_val;
        }

        return res;
    }

    public int rangeBitwiseAnd(int m, int n) {
        if (m == n) {
            return m;
        }
        int res = m;
        for (int i = m+1; i <=n; i++) {
            res = res & i;
        }
        return res;
    }

    private int msbPos(long n)
    {

        int msbPos = -1;
        while (n > 0) {
            n = n >> 1;
            msbPos++;
        }
        return msbPos;
    }

    @Test
    public void test() {
        System.out.println(rangeBitwiseAnd(2,4));
    }
}
