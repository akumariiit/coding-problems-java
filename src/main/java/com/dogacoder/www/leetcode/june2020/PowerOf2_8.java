package com.dogacoder.www.leetcode.june2020;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * https://leetcode.com/explore/featured/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3354/
 * Given an integer, write a function to determine if it is a power of two.
 *
 * Example 1:
 *
 * Input: 1
 * Output: true
 * Explanation: 20 = 1
 *
 * Example 2:
 *
 * Input: 16
 * Output: true
 * Explanation: 24 = 16
 *
 * Example 3:
 *
 * Input: 218
 * Output: false
 */
public class PowerOf2_8 {

    public boolean isPowerOfTwo(int n) {
        if (n == 1) {
            return true;
        }
        if (n <= 0) {
            return false;
        }
        int msb = getMSB(n);
        return (n ^ (1 << msb)) == 0;
    }

    private int getMSB(int n) {
        int msb = -1;
        while (n > 0) {
            msb++;
            n = n >> 1;
        }
        return msb;
    }

    @Test
    public void test() {
        int a = 0;
        int b = 4;
        int c = 129;
        int d = -2;
        assertFalse(isPowerOfTwo(a));
        assertTrue(isPowerOfTwo(b));
        assertFalse(isPowerOfTwo(c));
        assertFalse(isPowerOfTwo(d));
    }

}
