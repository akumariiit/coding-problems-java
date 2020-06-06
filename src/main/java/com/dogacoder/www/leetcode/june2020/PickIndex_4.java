package com.dogacoder.www.leetcode.june2020;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class PickIndex_4 {
    int[] sumArr;
    public PickIndex_4(int[] w) {
        sumArr = new int[w.length];
        sumArr[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            sumArr[i] = sumArr[i-1] + w[i];
        }
    }

    public int pickIndex() {
        int n = sumArr.length;
        int num = new Random().nextInt(sumArr[n-1]) + 1;
//        for (int i = 0; i < n; i++) {
//            if (sumArr[i] > num) {
//                return i;
//            }
//        }
        int low = 0;
        int high = n-1;

        while (low < high) {
            int mid = low + (high-low)/2;
            if (sumArr[mid] == num) {
                return mid;
            }
            if (sumArr[mid] < num) {
                low = mid+1;
            }
            else {
                high = mid;
            }
        }
        return low;
    }

    @Test
    public void test() {
//        int[] w = {1, 2, 3};
//        PickIndex_4 obj = new PickIndex_4(w);
//        int p1 = obj.pickIndex();
        Random random = new Random();
        int rand = random.nextInt();
        System.out.println("random "  + rand);
    }
}
