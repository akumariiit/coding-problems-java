package com.dogacoder.www.leetcode.june2020;

import org.junit.jupiter.api.Test;

/**
 *
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3363/
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * Example:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 *
 * After running your function, the board should be:
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 * Explanation:
 *
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
 *
 */
public class SurroundedRegions {

    public void solve(char[][] board) {
        if (board != null && board.length > 0) {
            int rows = board.length;
            int cols = board[0].length;
            if (rows > 2 && cols > 2) {
                boolean[][] visited = new boolean[rows][cols];
                for (int i = 0; i < rows; i++) {
                    populate(i, 0, board, visited);
                    populate(i, cols-1, board, visited);
                }
                for (int j = 0; j < cols; j++) {
                    populate(0, j, board, visited);
                    populate(rows-1, j, board, visited);
                }

                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (board[i][j] == 'O' && !visited[i][j]) {
                            board[i][j] = 'X';
                        }
                    }
                }
            }

        }
    }

    private void populate(int i, int j, char[][] board, boolean[][] visited) {
        if (board[i][j] == 'X') {
            return;
        }
        if (board[i][j] == 'O') {
            visited[i][j] = true;
        }
        int[] di = {-1, 1, 0, 0};
        int[] dj = {0, 0, -1, 1};
        for (int k = 0; k < 4; k++) {
            int newI = i+di[k];
            int newJ = j+dj[k];
            if (isValid(newI, newJ, board) && board[newI][newJ] == 'O' && !visited[newI][newJ]) {
                visited[newI][newJ] = true;
                populate(newI, newJ, board, visited);
            }
        }

    }

    private boolean isValid(int i, int j, char[][] board) {
        return i > 0 && j > 0 && i < board.length && j < board[0].length;
    }

    @Test
    public void test() {
        char[][] a = {{'X', 'X', 'X', 'X'},{'X','X','X','X'},{'X','X','X','X'},{'X','X','X','X'}};
    }

    @Test
    public void test1() {
        char[][] a = {{'O','X', 'X', 'O', 'X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};
        solve(a);
        System.out.println(a);
    }
}
