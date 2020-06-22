package com.dogacoder.www.matrics;


import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a chess board, find the shortest distance (minimum number of steps) taken by a Knight
 * to reach given destination from given source. The idea is to use Breadth First Search (BFS)
 * as it is a Shortest Path problem.
 */
public class ChessKnightBFSPrintPath {

    @Test public void testShortestPath() {
        Position start = new Position(0, 0, 0, "00");
        Position end = new Position(0, 1, 0, "");
        System.out.println(getShortestDistance(start, end, 8));
    }

    public String getShortestDistance(Position start, Position end, int N) {
        Queue<Position> queue = new LinkedList<>();

        int[] dx = {-2, 2, -1, 1, -2, 2, -1, 1};
        int[] dy = {-1, -1, -2, -2, 1, 1, 2, 2};

        boolean[][] visited = initVisited(N);
        queue.add(start);
        visited[start.getX()][start.getY()] = true;
        while (!queue.isEmpty()) {
            Position temp = queue.poll();
            if (temp.getX() == end.getX() && temp.getY() == end.getY()) {
                return temp.getPathFromStart();
            }

            for (int i = 0; i < 8; i++) {
                int newX = temp.getX() + dx[i];
                int newY = temp.getY() + dy[i];
                if (isValidPosition(newX, newY, N) && !visited[newX][newY]) {
                    Position newPosition = new Position(newX, newY, temp.getDistance() + 1, temp.getPathFromStart() + " => " + newX + "" + newY);
                    queue.add(newPosition);
                    visited[newPosition.getX()][newPosition.getY()] = true;
                }
            }
        }
        return "NOT_FOUND";
    }

    private boolean[][] initVisited(int N) {
        boolean[][] visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visited[i][j] = false;
            }
        }
        return visited;
    }

    private boolean isValidPosition(int x, int y, int N) {
        if (x >= 0 && x < N && y >= 0 && y < N) {
            return true;
        }
        return false;

    }



    class Position {
        int x;
        int y;
        int distance;
        String pathFromStart;

        public Position(int x, int y, int distance, String pathFromStart) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.pathFromStart = pathFromStart;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public String getPathFromStart() {
            return pathFromStart;
        }

        public void setPathFromStart(String pathFromStart) {
            this.pathFromStart = pathFromStart;
        }
    }
}
