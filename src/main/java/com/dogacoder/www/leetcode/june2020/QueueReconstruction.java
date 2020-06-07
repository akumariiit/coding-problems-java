package com.dogacoder.www.leetcode.june2020;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueueReconstruction {
    public int[][] reconstructQueue(int[][] p) {
        Comparator<int[]> comparator = Comparator.<int[]>comparingInt(a -> a[0]).thenComparing((o1, o2) -> {
            if (o2[1] > o1[1]) {
                return 1;
            } else {
                return -1;
            }
        });

        Arrays.sort(p, comparator);

        System.out.println();
        for (int i = 0; i < p.length; i++) {
            System.out.println(p[i][0] + " and "+ p[i][1]);
        }

        int res[][] = new int[p.length][p[0].length];
        for (int i = 0; i < p.length; i++) {
            res[i][0] = -1;
            res[i][1] = -1;
        }
        for (int i = 0; i < p.length; i++) {
            int count = 0;
            for (int j = 0; j < p.length; j++) {
                if (count == p[i][1] && res[j][0] == -1 && res[j][1] == -1) {
                    res[j][0] = p[i][0];
                    res[j][1] = p[i][1];
                    System.out.println("After setting");
                    for (int k = 0; k < p.length; k++) {
                        System.out.println(res[k][0] + " and "+ res[k][1]);
                    }
                    System.out.println("Next setting");
                    break;
                }
                else if (res[j][0] == -1 && res[j][1] == -1) {
                    count++;
                }

            }
        }
        System.out.println("Final :");
        for (int i = 0; i < p.length; i++) {
            System.out.println(res[i][0] + " and "+ res[i][1]);
        }
        return res;
    }

    @Test
    public void test() {
        int[][] a = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][] r = reconstructQueue(a);
        assertEquals(r[0][0], 5);
        assertEquals(r[0][1], 0);
        assertEquals(r[1][0], 7);
        assertEquals(r[1][1], 0);
        assertEquals(r[2][0], 5);
        assertEquals(r[2][1], 2);
        assertEquals(r[3][0], 6);
        assertEquals(r[3][1], 1);
        assertEquals(r[4][0], 4);
        assertEquals(r[4][1], 4);
        assertEquals(r[5][0], 7);
        assertEquals(r[5][1], 1);
    }

    @Test
    public void test2() {
        int[][] a = {{9,0},{7,0},{1,9},{3,0},{2,7},{5,3},{6,0},{3,4},{6,2},{5,2}};
        int[][] r = reconstructQueue(a);
        assertEquals(r[0][0], 3);
        assertEquals(r[0][1], 0);
        assertEquals(r[1][0], 6);
        assertEquals(r[1][1], 0);
        assertEquals(r[2][0], 7);
        assertEquals(r[2][1], 0);
    }

    @Test
    public void test3() {
        int[][] a = {{0,0},{6,2},{5,5},{4,3},{5,2},{1,1},{6,0},{6,3},{7,0},{5,1}};
        int[][] r = reconstructQueue(a);
        assertEquals(r[0][0], 0);
        assertEquals(r[0][1], 0);
        assertEquals(r[1][0], 6);
        assertEquals(r[1][1], 0);
        assertEquals(r[2][0], 1);
        assertEquals(r[2][1], 1);
        assertEquals(r[3][0], 5);
        assertEquals(r[3][1], 1);
        assertEquals(r[4][0], 5);
        assertEquals(r[4][1], 2);
        assertEquals(r[5][0], 4);
        assertEquals(r[5][1], 3);
        assertEquals(r[6][0], 7);
        assertEquals(r[6][1], 0);
        assertEquals(r[7][0], 6);
        assertEquals(r[7][1], 2);
        assertEquals(r[8][0], 5);
        assertEquals(r[8][1], 5);
        assertEquals(r[9][0], 6);
        assertEquals(r[9][1], 3);

    }
}
