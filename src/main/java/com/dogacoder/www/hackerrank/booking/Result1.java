package com.dogacoder.www.hackerrank.booking;

import java.util.Collections;
import java.util.List;

public class Result1 {

    /*
     * Complete the 'carParkingRoof' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. LONG_INTEGER_ARRAY cars
     *  2. INTEGER k
     */

    public static long carParkingRoof(List<Long> cars, int k) {
        // Write your code here
        Collections.sort(cars);
        int size = cars.size();
        long result = Long.MAX_VALUE;
        for (int i = 0; i < size-k+1; i++) {
            // i + k - 1
            long currentMin = cars.get(i+k-1) - cars.get(i) + 1;
            result = Math.min(currentMin, result);
        }

        return result;

    }
}
