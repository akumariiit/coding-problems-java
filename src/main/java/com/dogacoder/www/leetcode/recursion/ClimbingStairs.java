package com.dogacoder.www.leetcode.recursion;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClimbingStairs {
    public int climbStairs(int n) {
        Map<Integer, Integer> countMap = new HashMap<>();
        return climbDFS(n, countMap);

    }
    private int climbDFS(int n, Map<Integer, Integer> countMap) {
        if (countMap.containsKey(n)) {
            return countMap.get(n);
        }
        if (n <= 0) {
            return 0;
        }
        if (n <= 3) {
            return n;
        }
        int l = climbDFS(n-1, countMap);
        int r = climbDFS(n-2, countMap);
        countMap.put(n-1, l);
        countMap.put(n-2, r);
        return l+r;
    }

    public int climbStairs_optimized(int n) {
        int[] ways = new int[n+1];
        ways[0] = 1;
        ways[1] = 1;
        for (int i = 2; i <=n; i++) {
            ways[i] = ways[i-1] + ways[i-2];
        }
        return ways[n];
    }

    @Test
    public void test() {
        assertEquals(climbStairs(2), 2);
    }

    @Test
    public void test1() {
        assertEquals(climbStairs(5), 8);
    }

    @Test
    public void test2() {
        assertEquals(climbStairs_optimized(5), 8);
    }
}
