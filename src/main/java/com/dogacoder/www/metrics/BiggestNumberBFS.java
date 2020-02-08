package com.dogacoder.www.metrics;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

import static junit.framework.TestCase.assertTrue;

public class BiggestNumberBFS {
    int pushCount = 0;

    public String solution(int[][] A) {
        Queue<Position> queue = new LinkedList<>();
        Position[][] state = initState(A);
        queue.add(state[0][0]);
        state[0][0].setVisited(true);
        int rows = A.length;
        int columns = A[0].length;
        while (!queue.isEmpty()) {
            Position currentPosition = queue.poll();
            System.out.println("Popping " + currentPosition.getBiggestSoFar());
            if (currentPosition.getX() == rows-1 && currentPosition.getY()==columns-1) {
                return currentPosition.biggestSoFar;
            }
            Position down = null;
            Position right = null;
            if (currentPosition.getX()+1 < rows) {
                down = state[currentPosition.getX() + 1][currentPosition.getY()];
            }
            if (currentPosition.getY()+1 < columns) {
                right = state[currentPosition.getX()][currentPosition.getY() + 1];
            }

            if (down != null && right != null) {
                if (A[down.getX()][down.getY()] >= A[right.getX()][right.getY()]) {
                    pushDown((Queue<Position>) queue, state, currentPosition, down, A[currentPosition.getX() + 1]);
                }
                if (A[down.getX()][down.getY()] <= A[right.getX()][right.getY()]) {
                    pushRight((Queue<Position>) queue, state, currentPosition, right, A[currentPosition.getX()]);
                }
            }
            if (down != null && right == null) {
                down = state[currentPosition.getX()+1][currentPosition.getY()];
                pushDown(queue, state, currentPosition, down, A[currentPosition.getX()+1]);
            }
            if (down == null && right != null) {
                right = state[currentPosition.getX()][currentPosition.getY()+1];
                pushRight(queue, state, currentPosition, right, A[currentPosition.getX()]);
            }
        }
        return state[rows-1][columns-1].getBiggestSoFar();

    }

    private void pushRight(Queue<Position> queue, Position[][] state, Position currentPosition, Position right, int[] ints) {
        String rightString = ints[currentPosition.getY() + 1] + "";
        String newRightString = currentPosition.getBiggestSoFar() + rightString;
        String rightBiggestSoFar = right.getBiggestSoFar();
        if (!right.isVisited()
                && ((newRightString.length() > rightBiggestSoFar.length()) || (newRightString.compareTo(rightBiggestSoFar) > 0))) {
            right.setBiggestSoFar(newRightString);
            //right.setVisited(true);
            state[currentPosition.getX()][currentPosition.getY() + 1] = right;
            System.out.println("Pushing " + rightString + " at position " + currentPosition.getX() + "," + (currentPosition.getY()+1) + " pushCount " + ++pushCount);
            queue.add(right);
        }
    }

    private void pushDown(Queue<Position> queue, Position[][] state, Position currentPosition, Position down, int[] ints) {
        String downString = ints[currentPosition.getY()] + "";
        String newDownString = currentPosition.getBiggestSoFar() + downString;
        String downBiggestSoFar = down.getBiggestSoFar();
        if (!down.isVisited()
                && ((newDownString.length() > downBiggestSoFar.length()) || (newDownString.compareTo(downBiggestSoFar) > 0))) {
            down.setBiggestSoFar(newDownString);
            //down.setVisited(true);
            state[currentPosition.getX() + 1][currentPosition.getY()] = down;
            System.out.println("Pushing " + downString + " at position " + (currentPosition.getX()+1) + "," + currentPosition.getY() + " pushCount " + ++pushCount);
            queue.add(down);
        }
    }

    private Position[][] initState(int[][] input) {
        Position[][] state = new Position[input.length][input[0].length];
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                state[i][j] = new Position(i, j, input[i][j]+"", false);
            }
        }
        return state;
    }


    class Position {
        private int x;
        private int y;
        private String biggestSoFar;
        private boolean visited;

        public Position(int x, int y, String biggestSoFar, boolean visited) {
            this.x = x;
            this.y = y;
            this.biggestSoFar = biggestSoFar;
            this.visited = visited;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public String getBiggestSoFar() {
            return biggestSoFar;
        }

        public void setBiggestSoFar(String biggestSoFar) {
            this.biggestSoFar = biggestSoFar;
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

        @Override
        public String toString() {
            return "Position{" +
                    "x=" + x +
                    ", y=" + y +
                    ", biggestSoFar=" + biggestSoFar +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof BiggestNumberBFS.Position)) return false;
            BiggestNumberBFS.Position position = (BiggestNumberBFS.Position) o;
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
        int[][] grid = { { 9,9,7 },{ 9,7,2 },{ 6,9,5 },{ 9,1,2 }};
        int[][] grid1 = { { 6,6,6 },{ 6,6,6 },{ 6,6,7 },{ 6,6,6 }, { 6,6,6 }};
        String answer = solution(grid1);
        System.out.println(answer);
        assertTrue(answer.equals("6666766"));
    }
}
