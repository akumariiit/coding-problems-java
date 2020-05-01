package com.dogacoder.www.leetcode.thirtydays;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3297/
 * We have a collection of stones, each stone has a positive integer weight.
 *
 * Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:
 *
 *     If x == y, both stones are totally destroyed;
 *     If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 *
 * At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
 *
 *
 *
 * Example 1:
 *
 * Input: [2,7,4,1,8,1]
 * Output: 1
 * Explanation:
 * We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
 * we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
 * we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
 * we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
 *
 *
 *
 * Note:
 *
 *     1 <= stones.length <= 30
 *     1 <= stones[i] <= 1000
 *
 */
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 0) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        for (Integer i: stones) {
            list.add(i);
        }
        Collections.sort(list);
        while (true) {
            if (list.isEmpty()) {
                return 0;
            }
            if (list.size() == 1) {
                return list.get(0);
            }
            if (list.size() == 2) {
                return list.get(1) - list.get(0);
            }

            int first = list.get(list.size() - 1);
            int second = list.get(list.size() - 2);
            if (first - second > 0) {
                list.remove(list.size() - 1);
                list.remove(list.size() - 1);
                list.add(first-second);
                Collections.sort(list);
            }
            else if (first == second) {
                list.remove(list.size() - 1);
                list.remove(list.size() - 1);
            }
        }
    }

    @Test
    public void test() {
        int[] in = {2,7,4,1,8,1};
        assertEquals(lastStoneWeight(in), 1);
    }

    @Test
    public void test2() {
        int[] in = {3,7,2};
        assertEquals(lastStoneWeight(in), 2);
    }
}
