package com.dogacoder.www.array;

import org.junit.Test;

/**
 *

 If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

 Find the sum of all the multiples of 3 or 5 below 1000.

 */
public class SumOfNumbers {

    public int solution() {
        int sum = 3;
        int start = 5;
        while (start < 1000) {
            if ((start % 3 == 0) || (start % 5 ==0)) {
                sum += start;
            }
            start++;
        }
        return sum;
    }

    @Test
    public void testSum() {
        System.out.println(solution());
    }
}
