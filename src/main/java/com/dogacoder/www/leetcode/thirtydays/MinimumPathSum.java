package com.dogacoder.www.leetcode.thirtydays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3303/
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 *
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int[][] mem = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                mem[i][j] = Integer.MAX_VALUE;
            }
        }
        return getMinimumPathSum(grid, grid.length, grid[0].length, 0, 0, mem);
        }

    private int getMinimumPathSum(int[][] grid, int rows, int cols, int x, int y, int[][] mem) {
        if (x == rows-1 && y == cols-1) {
            return grid[x][y];
        }

        if (mem[x][y] != Integer.MAX_VALUE) {
            return grid[x][y] + mem[x][y];
        }
        else {
            int right = Integer.MAX_VALUE;
            int down = Integer.MAX_VALUE;
            if (y + 1 < cols) {
                right = getMinimumPathSum(grid, rows, cols, x, y + 1, mem);
            }
            if (x + 1 < rows) {
                down = getMinimumPathSum(grid, rows, cols, x + 1, y, mem);
            }
            mem[x][y] = Math.min(right, down);
            return grid[x][y] + Math.min(right, down);
        }
    }

    @Test
    public void test() {
        int[][] in = {{1,3,1},{1,5,1},{4,2,1}};
        assertEquals(minPathSum(in), 7);

    }
    @Test
    public void test2() {
        int[][] in = {{3,8,6,0,5,9,9,6,3,4,0,5,7,3,9,3},{0,9,2,5,5,4,9,1,4,6,9,5,6,7,3,2},{8,2,2,3,3,3,1,6,9,1,1,6,6,2,1,9},{1,3,6,9,9,5,0,3,4,9,1,0,9,6,2,7},{8,6,2,2,1,3,0,0,7,2,7,5,4,8,4,8},{4,1,9,5,8,9,9,2,0,2,5,1,8,7,0,9},{6,2,1,7,8,1,8,5,5,7,0,2,5,7,2,1},{8,1,7,6,2,8,1,2,2,6,4,0,5,4,1,3},{9,2,1,7,6,1,4,3,8,6,5,5,3,9,7,3},{0,6,0,2,4,3,7,6,1,3,8,6,9,0,0,8},{4,3,7,2,4,3,6,4,0,3,9,5,3,6,9,3},{2,1,8,8,4,5,6,5,8,7,3,7,7,5,8,3},{0,7,6,6,1,2,0,3,5,0,8,0,8,7,4,3},{0,4,3,4,9,0,1,9,7,7,8,6,4,6,9,5},{6,5,1,9,9,2,2,7,4,2,7,2,2,3,7,2},{7,1,9,6,1,2,7,0,9,6,6,4,4,5,1,0},{3,4,9,2,8,3,1,2,6,9,7,0,2,4,2,0},{5,1,8,8,4,6,8,5,2,4,1,6,2,2,9,7}};
        assertEquals(minPathSum(in), 83);

    }

    @Test
    public void test3() {
        int[][] in = {{1,3,1},{1,5,1},{1,1,1}};
        assertEquals(minPathSum(in), 5);

    }


}
