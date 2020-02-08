package com.dogacoder.www.counting;

import java.util.HashMap;
import java.util.Map;

/**
 *

 A non-empty array A consisting of N integers is given.

 A permutation is a sequence containing each element from 1 to N once, and only once.

 For example, array A such that:
 A[0] = 4
 A[1] = 1
 A[2] = 3
 A[3] = 2

 is a permutation, but array A such that:
 A[0] = 4
 A[1] = 1
 A[2] = 3

 is not a permutation, because value 2 is missing.

 The goal is to check whether array A is a permutation.

 Write a function:

 class Solution { public int solution(int[] A); }

 that, given an array A, returns 1 if array A is a permutation and 0 if it is not.

 For example, given array A such that:
 A[0] = 4
 A[1] = 1
 A[2] = 3
 A[3] = 2

 the function should return 1.

 Given array A such that:
 A[0] = 4
 A[1] = 1
 A[2] = 3

 the function should return 0.

 Write an efficient algorithm for the following assumptions:

 N is an integer within the range [1..100,000];
 each element of array A is an integer within the range [1..1,000,000,000].


 */


public class CheckPermutation {
    public static void main(String[] args) {
        int[] a = {1,4,1};
        System.out.println(solution(a));
    }

    public static int solution(int[] A) {
        // write your code in Java SE 8
        int size = A.length;
        int sum = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < size; i++) {
            countMap.put(A[i], countMap.getOrDefault(A[i], 0)+1);
            if (countMap.get(A[i]) > 1) {
                return 0;
            }
            sum += A[i];
        }
        if ((size * (size+1)/2) == sum) {
            return 1;
        }
        return 0;
    }
}
