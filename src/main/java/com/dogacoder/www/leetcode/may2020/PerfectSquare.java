package com.dogacoder.www.leetcode.may2020;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        int n = num/2;
        while (n > 1) {
            double res = Double.valueOf(num) / n;
            if (res == Double.valueOf(n)) {
                return true;
            }
            n--;
        }
        return false;
    }

    @Test
    public void test() {
        assertFalse(isPerfectSquare(626));
    }
}
