package com.dogacoder.www.matrics;

/**
 *

 You are given a matrix A consisting of N rows and M columns, where each cell contains a digit. Your task is to find a continuous sequence of neighbouring cells, starting in the top-left corner and ending in the bottom-right corner (going only down and right), that creates the biggest possible integer by concatenation of digits on the path. By neighbouring cells we mean cells that have exactly one common side.

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
public class BiggestNumberDFS {
    public static void main(String[] args) {
        int[][] a = {{9, 9, 7}, {9, 7, 2}, {6, 9, 5}, {9, 1, 2}};
        //int[][] a = {{1}};
        //int[][] a = {{1, 1, 1}, {1, 1, 5}, {1, 1, 1}, {1, 1, 1}};
        System.out.println(solution(a));
    }
    public static String solution(int[][] A) {
        return findBiggest(A, 0, 0, A.length, A[0].length);
    }

    private static String findBiggest(int[][] A, int i, int j, int N, int M) {
        if (i == N && j == M) {
            return "";
        }
        if (i < N && j == M) {
            String s = "";
            for (int k = i + 1; k < N; k++) {
                s += A[k][j-1];
            }
            return s;
        }
        if (i == N && j < M) {
            String s = "";
            for (int k = j + 1; k < M; k++) {
                s += A[i-1][k];
            }
            return s;
        }

        String right = A[i][j] + findBiggest(A, i, j+1, N, M);
        String down = A[i][j] + findBiggest(A, i+1, j, N, M);
        if (right.compareTo(down) > 0) {
            return right;
        }
        else {
            return down;
        }
    }
}
