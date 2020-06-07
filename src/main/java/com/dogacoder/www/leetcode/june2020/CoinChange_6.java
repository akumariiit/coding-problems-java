package com.dogacoder.www.leetcode.june2020;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoinChange_6 {
    public int change(int amount, int[] coins) {
        if (coins.length == 0 && amount == 0) {
            return 1;
        }
        if (Objects.isNull(coins) || coins.length == 0) {
            return 0;
        }
        Map<String, Integer> mem = new HashMap<>();
        return getCount(amount, coins, 0, mem);

    }

    private int getCount(int amount, int[] coins, int coinIndex, Map<String, Integer> mem) {
        if (mem.containsKey(amount+"->"+coinIndex)) {
            return mem.get(amount+"->"+coinIndex);
        }
        if (coinIndex >= coins.length || amount < 0) {
            return 0;
        }
        if (amount == 0) {
            return 1;
        }

        int res = getCount(amount-coins[coinIndex], coins, coinIndex, mem)
                + getCount(amount, coins, coinIndex+1, mem);
        mem.put(amount+"->"+coinIndex, res);
        return res;
    }

    @Test
    public void test() {
        int[] c = {1,2,4,5};
        assertEquals(change(15, c), 37);
    }

    @Test
    public void test1() {
        int[] c = {};
        assertEquals(change(0, c), 1);
    }

    @Test
    public void test2() {
        int[] c = {};
        assertEquals(change(1, c), 0);
    }
}
