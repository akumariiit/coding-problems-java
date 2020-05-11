package com.dogacoder.www.leetcode.may2020;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3326/
 *  An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).
 *
 * Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.
 *
 * To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.
 *
 * At the end, return the modified image.
 *
 * Example 1:
 *
 * Input:
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 * Explanation:
 * From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected
 * by a path of the same color as the starting pixel are colored with the new color.
 * Note the bottom corner is not colored 2, because it is not 4-directionally connected
 * to the starting pixel.
 *
 * Note:
 * The length of image and image[0] will be in the range [1, 50].
 * The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
 * The value of each color in image[i][j] and newColor will be an integer in [0, 65535].
 *
 */
public class FloorFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0) {
            return image;
        }
        boolean[][] visited = new boolean[image.length][image[0].length];
        int val = image[sr][sc];
        image[sr][sc] = newColor;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(sr, sc));
        visited[sr][sc] = true;

        while (!queue.isEmpty()) {
            int x = queue.peek().x;
            int y = queue.peek().y;
            queue.poll();

            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            for (int i = 0; i < dx.length; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (isValid(newX, newY, image.length, image[0].length) && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    if (image[newX][newY] == val) {
                        image[newX][newY] = newColor;
                        queue.add(new Point(newX, newY));
                    }
                }
            }
        }
        return image;
    }

    private boolean isValid(int newX, int newY, int rows, int cols) {
        return (newX >= 0 && newY >=0 && newX < rows && newY < cols);
    }

    class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[][] floodFill_DFS(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (newColor == oldColor) {
            return image;
        }
        fillColor(image, sr, sc, newColor, oldColor);
        return image;
    }

    private void fillColor(int[][] image, int sr, int sc, int newColor, int oldColor) {
        if (isValid(image, sr, sc) && image[sr][sc] == oldColor) {
            image[sr][sc] = newColor;
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            for (int i = 0; i < dx.length; i++) {
                fillColor(image, sr+dx[i], sc+dy[i], newColor, oldColor);
            }
        }
    }

    private boolean isValid(int[][] image, int sr, int sc) {
        return (sr >= 0 && sc >=0 && sr < image.length && sc< image[0].length);
    }

    @Test
    public void test() {
        int[][] a = {{1,1,1},{1,1,0},{1,0,1}};
        floodFill(a, 1,1, 2);
    }
    @Test
    public void test2() {
        int[][] a = {{1,1,1},{1,1,0},{1,0,1}};
        floodFill_DFS(a, 1,1, 2);
        System.out.println(a);
    }
}
