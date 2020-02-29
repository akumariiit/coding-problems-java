package com.dogacoder.www.aws;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class HourGlass2 {

    public int solution(Integer[] a, Integer[] b) {
        final List<Integer> result = new ArrayList<>();
        int n = a.length;
        Long subArrayFromALeft[] = new Long[n];
        Long subArrayFromARight[] = new Long[n];
        Long subArrayFromBLeft[] = new Long[n];
        Long subArrayFromBRight[] = new Long[n];

        subArrayFromALeft[0] = 0l + a[0];
        subArrayFromARight[n-1] = 0l + a[n-1];
        subArrayFromBLeft[0] = 0l + b[0];
        subArrayFromBRight[n-1] = 0l + b[n-1];

        for(int i=1; i<n; i++) {
            subArrayFromALeft[i] = subArrayFromALeft[i-1] + a[i];
            subArrayFromBLeft[i] = subArrayFromBLeft[i-1] + b[i];
        }

        for(int i = n-2; i>=0; i--) {
            subArrayFromARight[i] = subArrayFromARight[i+1] + a[i];
            subArrayFromBRight[i] = subArrayFromBRight[i+1] + b[i];
        }

        for(int i=1; i<n; i++) {
            if(subArrayFromALeft[i-1].equals(subArrayFromARight[i])
                    && subArrayFromBLeft[i-1].equals(subArrayFromBRight[i])
                    && subArrayFromARight[i].equals(subArrayFromBRight[i])) {
                result.add(i);
            }
        }
        result.stream().forEach(r-> System.out.println(r));
        return result.size();

    }

    @Test
    public void test() {
        Integer a[] = {1, 4, 2, -2, 5};
        Integer b[] = {7, -2, -2, 2, 5};


        System.out.println("Returned value " + solution(a,b));

    }

}
