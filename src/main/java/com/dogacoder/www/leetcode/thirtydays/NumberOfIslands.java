package com.dogacoder.www.leetcode.thirtydays;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3302/
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 *
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 *
 */
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int numberOfIslands = 0;
        for (int i = 0 ; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    numberOfIslands++;
                    doVisit(grid, visited, i, j);
                }
            }
        }
        return numberOfIslands;
    }

    private void doVisit(char[][] grid, boolean[][] visited, int i, int j) {
        Queue<Entry> queue = new ArrayDeque<>();
        queue.add(new Entry(i, j, grid[i][j]));
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            Entry val = queue.poll();
            int[] dx = {1, 0, -1, 0};
            int[] dy = {0, 1, 0, -1};
            for (int k = 0; k < 4; k++) {
                int newX = val.getRow() + dx[k];
                int newY = val.getCol() + dy[k];
                if (isValid(newX, newY, grid.length, grid[0].length)
                        && !visited[newX][newY]
                        && grid[newX][newY] == '1') {
                    queue.add(new Entry(newX, newY, grid[newX][newY]));
                    visited[newX][newY] = true;
                }
            }
        }
    }

    private boolean isValid(int newX, int newY, int rows, int cols) {
        return (newX < rows && newY < cols && newX >=0 && newY >=0);
    }

    class Entry {
        int row;
        int col;
        char value;

        public Entry(int row, int col, char value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }

        public char getValue() {
            return value;
        }
    }

    @Test
    public void test() {
        char[][] in = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        assertEquals(numIslands(in), 1);

    }
}
