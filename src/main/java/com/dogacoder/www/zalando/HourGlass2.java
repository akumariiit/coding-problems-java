package com.dogacoder.www.zalando;

import org.junit.Test;

public class HourGlass2 {

    public int lightBulbsCount(int[] A) {
        final int size = A.length;
        int[] when = new int[size + 1];

        for(int i=0; i<size; i++) {
            when[A[i]] = i+1;

        }

        for(int i=0; i<size+1; i++) {
            System.out.println(when[i]);

        }

        for(int i=2; i<size+1; i++) {
            when[i] = Math.max(when[i], when[i-1]);
        }

        int count = 0;
        for(int i=0; i<size; i++) {
            if(A[i] >= when[A[i]]) {
                count++;
            }
        }
        return count;
    }

//    public int lightBulbsCount2(int[] A) {
//        final int size = A.length;
//        int[] when = new int[size + 1];
//        for (int i = 0; i < size; i++) {
//            when[A[i]] = i + 1;
//        }
//
//        int count = 0;
//        for (int i = 2; i < size + 1; i++) {
//            when[i] = Math.max(when[i], when[i - 1]);
//            if (i >= when[i]) {
//                count++;
//            }
//        }
//        return count;
//    }

    @Test
    public void test() {
        int [] input = {2,1,3,5,4};
//        int [] input2 = {2,3,4,1,5};
//        int [] input3 = {1,3,4,2,5};
        int ans = lightBulbsCount(input);
//        int ans2 = lightBulbsCount(input2);
//        int ans3 = lightBulbsCount(input3);

        System.out.println(ans);
//        System.out.println(ans2);
//        System.out.println(ans3);
    }
}
