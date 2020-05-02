package com.dogacoder.www.leetcode.biweekly25;

import org.junit.jupiter.api.Test;


/**
 *
 * https://leetcode.com/problems/game-of-life/
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 *
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 *
 *     Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 *     Any live cell with two or three live neighbors lives on to the next generation.
 *     Any live cell with more than three live neighbors dies, as if by over-population..
 *     Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 *
 * Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.
 *
 * Example:
 *
 * Input:
 * [
 *   [0,1,0],
 *   [0,0,1],
 *   [1,1,1],
 *   [0,0,0]
 * ]
 * Output:
 * [
 *   [0,0,0],
 *   [1,0,1],
 *   [0,1,1],
 *   [0,1,0]
 * ]
 *
 * Follow up:
 *
 *     Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
 *     In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
 *
 */
public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                int nei = howManyNeighbours(i, j, board);
                System.out.println("nei = " + nei + " for " + i + " and " + j);
                if (board[i][j] == 1) {
                    if (nei < 2 || nei > 3) {
                        board[i][j] = 4;
                    }
                    else {
                        board[i][j] = 5;
                    }
                }
                else {
                    if (nei == 3) {
                        board[i][j] = 3;
                    }
                    else {
                        board[i][j] = 2;
                    }
                }
            }
        }
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (board[i][j] == 2 || board[i][j] == 4) {
                    board[i][j] = 0;
                }
                if (board[i][j] == 3 || board[i][j] == 5) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private int howManyNeighbours(int i, int j, int[][] board) {
        int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
        int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
        int nei = 0;
        for (int k=0; k<8; k++) {
            int newX = i + dx[k];
            int newY = j + dy[k];
            if (isValid(newX, newY, board.length, board[0].length)) {
                if (board[newX][newY] == 4 || board[newX][newY] == 5 || board[newX][newY] == 1) {
                    nei++;
                }
            }
        }
        return nei;
    }
    private boolean isValid(int nx, int ny, int rows, int cols) {
        return (nx >= 0 && nx < rows && ny >= 0 && ny < cols);
    }

    @Test
    public void test() {
        int[][] a = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(a);
        System.out.println(a);
    }
}
