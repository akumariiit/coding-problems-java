package com.dogacoder.www.leetcode.recursion;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://leetcode.com/explore/learn/card/recursion-i/251/scenario-i-recurrence-relation/3234/
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 *
 * Note that the row index starts from 0.
 *
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *
 * Input: 3
 * Output: [1,3,3,1]
 *
 * Follow up:
 *
 * Could you optimize your algorithm to use only O(k) extra space?
 *
 */
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PascalTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        int[][] state = new int[rowIndex+1][rowIndex+1];
        for (int i = 0; i <= rowIndex; i++ ) {
            int value = getValue(rowIndex, i, state);
            state[rowIndex][i] = value;
            list.add(value);
        }
        return list;
    }
    private int getValue(int i, int j, int[][] state) {
        if (i == j || j == 0) {
            state[i][j] = 1;
            return 1;
        }
        else {
            if (state[i][j] != 0) {
                return state[i][j];
            }
            else {
                int left = getValue(i-1, j-1, state);
                int right = getValue(i-1, j, state);
                state[i-1][j-1] = left;
                state[i-1][j] = right;
                return left+right;
            }
        }
    }

    @Test
    public void test() {
        assertTrue(getRow(33).size() == 34);
    }
}
