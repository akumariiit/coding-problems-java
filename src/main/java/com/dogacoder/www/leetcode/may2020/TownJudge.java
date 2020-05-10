package com.dogacoder.www.leetcode.may2020;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 *
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3325/
 * In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.
 *
 * If the town judge exists, then:
 *
 *     The town judge trusts nobody.
 *     Everybody (except for the town judge) trusts the town judge.
 *     There is exactly one person that satisfies properties 1 and 2.
 *
 * You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.
 *
 * If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: N = 2, trust = [[1,2]]
 * Output: 2
 *
 * Example 2:
 *
 * Input: N = 3, trust = [[1,3],[2,3]]
 * Output: 3
 *
 * Example 3:
 *
 * Input: N = 3, trust = [[1,3],[2,3],[3,1]]
 * Output: -1
 *
 * Example 4:
 *
 * Input: N = 3, trust = [[1,2],[2,3]]
 * Output: -1
 *
 * Example 5:
 *
 * Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
 * Output: 3
 *
 *
 *
 * Note:
 *
 *     1 <= N <= 1000
 *     trust.length <= 10000
 *     trust[i] are all different
 *     trust[i][0] != trust[i][1]
 *     1 <= trust[i][0], trust[i][1] <= N
 *
 */
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
