package com.dogacoder.www;

import java.util.Arrays;

public class Demo {
    public int solution(int[] A) {
        Arrays.sort(A);
        if ((A[0] > 1) || (A[A.length-1] < 0)) {
            return 1;
        }
        int result = 0;
        for (int i = 1; i < A.length; i++) {
            if (((A[i] - A[i-1]) > 1) && (A[i-1] >= 0)) {
                result  = A[i-1] + 1;
                break;
            }
        }
        if (result == 0) {
            result = A[A.length-1] + 1;
        }
        return result;
    }
}
