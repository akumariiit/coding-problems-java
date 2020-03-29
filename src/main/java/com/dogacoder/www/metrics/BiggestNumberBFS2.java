package com.dogacoder.www.metrics;

import java.util.LinkedList;
import java.util.Queue;

/**
 *

 You are given a matrix A consisting of N rows and M columns, where each cell contains a digit. Your task is to find a continuous sequence of neighbouring cells,
 starting in the top-left corner and ending in the bottom-right corner (going only down and right),
 that creates the biggest possible integer by concatenation of digits on the path. By neighbouring cells we mean cells that have exactly one common side.

 Write a function:

 class Solution { public String solution(int[][] A); }

 that, given matrix A consisting of N rows and M columns, returns a string which represents the sequence of cells that we should pick to obtain the biggest possible integer.

 For example, given the following matrix A:

 [9 9 7] [9 7 2] [6 9 5] [9 1 2]

 the function should return "997952", because you can obtain such a sequence by choosing a path as shown below:

 [9 9 *] [* 7 *] [* 9 5] [* * 2]

 Write an efficient algorithm for the following assumptions:

 N and M are integers within the range [1..1,000];
 each element of matrix A is an integer within the range [1..9].


 */
public class BiggestNumberBFS2 {
    public String solution(int[][] A) {
        int rows = A.length;
        int columns = A[0].length;
        Cell[][] visited = init(A);
        Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(true, A[0][0]+""));
        visited[0][0].setVisited(true);

        while (!queue.isEmpty()) {

        }

        return "";

    }

    private Cell[][] init(int[][] input) {
        Cell[][] visited = new Cell[input.length][input[0].length];
        for (int i=0; i<input.length; i++) {
            for (int j=0; j<input[0].length; j++) {
                visited[i][j].setVisited(false);
                visited[i][j].setBiggestSoFar(input[i][j]+"");
            }
        }
        return visited;
    }


    private class Cell {
        private boolean visited;
        private String biggestSoFar;

        public Cell(boolean visited, String biggestSoFar) {
            this.visited = visited;
            this.biggestSoFar = biggestSoFar;
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

        public String getBiggestSoFar() {
            return biggestSoFar;
        }

        public void setBiggestSoFar(String biggestSoFar) {
            this.biggestSoFar = biggestSoFar;
        }
    }
}
