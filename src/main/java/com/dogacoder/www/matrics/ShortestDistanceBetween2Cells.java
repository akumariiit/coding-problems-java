package com.dogacoder.www.matrics;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

import static junit.framework.TestCase.assertTrue;

/**
 * Given a matrix of N*M order. Find the shortest distance from a source cell to a destination cell,
 * traversing through limited cells only. Also you can move only up, down,
 * left and right. If found output the distance else -1.
 * s represents ‘source’
 * d represents ‘destination’
 * * represents cell you can travel
 * 0 represents cell you can not travel
 * This problem is meant for single source and destination.
 * Examples:
 *
 * Input : {'0', '*', '0', 's'},
 *         {'*', '0', '*', '*'},
 *         {'0', '*', '*', '*'},
 *         {'d', '*', '*', '*'}
 * Output : 6
 *
 * Input :  {'0', '*', '0', 's'},
 *          {'*', '0', '*', '*'},
 *          {'0', '*', '*', '*'},
 *          {'d', '0', '0', '0'}
 * Output :  -1
 */
public class ShortestDistanceBetween2Cells {

    public int getShortestDistance(char[][] input) {
        int rows = input.length;
        int columns = input[0].length;
        boolean[][] visited = initVisitedArray(input);
        Queue<Position> queue = new LinkedList<>();
        Position startPosition = getStartingPosition(input);

        queue.add(startPosition);
        Position currentPosition = startPosition;
        visited[currentPosition.x][currentPosition.y] = true;
        while (!queue.isEmpty()) {
            queue.poll();
            if (input[currentPosition.x][currentPosition.y] == 'd') {
                return currentPosition.distance;
            }
            // go down
            if (currentPosition.x < rows-1
                    && !visited[currentPosition.x+1][currentPosition.y]) {
                currentPosition = new Position(currentPosition.x+1, currentPosition.y, currentPosition.distance+1);
                queue.add(currentPosition);
                visited[currentPosition.x][currentPosition.y] = true;
            }
            // go up
            if (currentPosition.x > 0
                    && !visited[currentPosition.x-1][currentPosition.y]) {
                currentPosition = new Position(currentPosition.x-1, currentPosition.y, currentPosition.distance+1);
                queue.add(currentPosition);
                visited[currentPosition.x][currentPosition.y] = true;
            }
            // go right
            if (currentPosition.y < columns-1
                    && !visited[currentPosition.x][currentPosition.y+1]) {
                currentPosition = new Position(currentPosition.x, currentPosition.y-1, currentPosition.distance+1);
                queue.add(currentPosition);
                visited[currentPosition.x][currentPosition.y] = true;
            }
            // go left
            if (currentPosition.y > 0
                    && !visited[currentPosition.x][currentPosition.y-1]) {
                currentPosition = new Position(currentPosition.x, currentPosition.y-1, currentPosition.distance+1);
                queue.add(currentPosition);
                visited[currentPosition.x][currentPosition.y] = true;
            }
        }
        return -1;

    }

    private boolean[][] initVisitedArray(char[][] input) {
        boolean[][] visited = new boolean[input.length][input[0].length];
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if (input[i][j] == '0') {
                    visited[i][j] = true;
                }
                else {
                    visited[i][j] = false;
                }
            }
        }
        return visited;
    }

    private Position getStartingPosition(char[][] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if (input[i][j] == 's') {
                    return new Position(i,j,0);
                }
            }
        }
        return null;
    }

    class Position {
        int x;
        int y;
        int distance;

        public Position(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getDistance() {
            return distance;
        }

        @Override
        public String toString() {
            return "Position{" +
                    "x=" + x +
                    ", y=" + y +
                    ", distance=" + distance +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Position)) return false;
            Position position = (Position) o;
            return getX() == position.getX() &&
                    getY() == position.getY();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getX(), getY());
        }
    }

    @Test
    public void testShortestDistance() {
        char grid[][] = { { '0', '*', '0', 's' },
            { '*', '0', '*', '*' },
            { '0', '*', '*', '*' },
            { 'd', '*', '*', '*' } };
        int answer = getShortestDistance(grid);
        System.out.println(answer);
        assertTrue(answer == 6);

    }
}
