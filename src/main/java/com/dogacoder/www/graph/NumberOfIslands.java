package com.dogacoder.www.graph;

import org.junit.Test;

/**
 *
 * Given a boolean 2D matrix, find the number of islands. A group of connected 1s forms an island. For example, the below matrix contains 5 islands
 *
 * Example:
 *
 * Input : mat[][] = {{1, 1, 0, 0, 0},
 *                    {0, 1, 0, 0, 1},
 *                    {1, 0, 0, 1, 1},
 *                    {0, 0, 0, 0, 0},
 *                    {1, 0, 1, 0, 1}
 * Output : 5
 *
 * This is a variation of the standard problem: “Counting the number of connected components in an undirected graph”.
 *
 *
 * Before we go to the problem, let us understand what is a connected component.
 * A connected component of an undirected graph is a subgraph in which every two vertices are connected to each other by a path(s),
 * and which is connected to no other vertices outside the subgraph.
 * For example, the graph shown below has three connected components.
 *
 * Recommended: Please solve it on “PRACTICE” first, before moving on to the solution.
 *
 * A graph where all vertices are connected with each other has exactly one connected component,
 * consisting of the whole graph. Such a graph with only one connected component is called a Strongly Connected Graph.
 *
 * The problem can be easily solved by applying DFS() on each component.
 * In each DFS() call, a component or a sub-graph is visited.
 * We will call DFS on the next un-visited component.
 * The number of calls to DFS() gives the number of connected components. BFS can also be used.
 *
 */
public class NumberOfIslands {

    public int getNumberOfIslands(int[][] metrics) {

        int ans = 0;
        boolean[][] visited = new boolean[metrics.length][metrics[0].length];

        for (int i = 0; i < metrics.length; i++) {
            for (int j = 0; j < metrics[0].length; j++) {
                if (!visited[i][j] && metrics[i][j] == 1) {
                    ans++;
                    callDFS(visited, metrics, i, j);
                }
            }
        }

        return ans;
    }

    private void callDFS(boolean[][] visited, int[][] metrics, int x, int y) {
        int[] dx = {-1, -1, -1, 1, 1, 1, 0, 0};
        int[] dy = {-1, 0, 1, -1, 0, 1, -1, 1};
        visited[x][y] = true;
        for (int i = 0; i < 8; i++) {
            int nextX = x+dx[i];
            int nextY = y+dy[i];
            if (isValid(nextX, nextY, visited.length, visited[0].length, metrics, visited)) {
                callDFS(visited, metrics, nextX, nextY);
            }
        }
    }

    private boolean isValid(int x, int y, int row, int cols, int[][] metrics, boolean[][] visited) {
        return (x >= 0 && x < row && y >= 0 && y < cols && metrics[x][y] == 1 && !visited[x][y]);
    }

    @Test
    public void test() {
        int M[][] = new int[][] { { 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 1 },
                { 1, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1 } };
        System.out.println("Number of islands is: " + getNumberOfIslands(M));
    }
}
