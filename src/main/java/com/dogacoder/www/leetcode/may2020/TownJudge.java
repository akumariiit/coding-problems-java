package com.dogacoder.www.leetcode.may2020;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TownJudge {
    public int findJudge(int N, int[][] trust) {
        if (trust.length < N-1) {
            return -1;
        }
        Map<Integer, List<Integer>> listMap = new HashMap<>();
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < trust.length; i++) {
            List<Integer> temp = listMap.getOrDefault(trust[i][0], new ArrayList<>());
            temp.add(trust[i][1]);
            listMap.put(trust[i][0], temp);
            countMap.put(trust[i][1], countMap.getOrDefault(trust[i][1], 0)+1);
        }
        if (listMap.size() != N-1) {
            return -1;
        }
        List<Integer> counts = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (!listMap.containsKey(i)) {
                counts.add(i);
            }
        }
        if (counts.size() > 1) {
            return -1;
        }
        if (countMap.get(counts.get(0)) != N-1) {
            return -1;
        }
        return counts.get(0);
    }

    @Test
    public void test() {
        int[][] a = {{1,3},{1,4},{2,3},{2,4},{4,3}};
        assertEquals(findJudge(4, a), 3);
    }
}
