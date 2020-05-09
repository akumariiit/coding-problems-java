package com.dogacoder.www.leetcode.recursion;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Fibonacci {
    public int fib(int N) {
        Map<Integer, Integer> map = new HashMap<>();
        return fib(N, map);
    }

    private int fib(int n, Map<Integer, Integer> map) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n <= 1) {
            map.put(n, n);
            return n;
        }
        int v1 = fib(n-1);
        int v2 = fib(n-2);
        map.put(n, v1+v2);
        return v1+v2;
    }

    @Test
    public void test() {
        assertEquals(fib(33), 3524578);
    }
}
