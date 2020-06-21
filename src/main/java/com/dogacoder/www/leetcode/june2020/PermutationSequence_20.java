package com.dogacoder.www.leetcode.june2020;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 *
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3366/
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 *
 *     "123"
 *     "132"
 *     "213"
 *     "231"
 *     "312"
 *     "321"
 *
 * Given n and k, return the kth permutation sequence.
 *
 * Note:
 *
 *     Given n will be between 1 and 9 inclusive.
 *     Given k will be between 1 and n! inclusive.
 *
 * Example 1:
 *
 * Input: n = 3, k = 3
 * Output: "213"
 *
 * Example 2:
 *
 * Input: n = 4, k = 9
 * Output: "2314"
 *
 */
public class PermutationSequence_20 {
    int current = 0;
    List<String> results = new ArrayList<>();
    public String getPermutation(int n, int k) {
        String s = "";
        for (int i = 1; i <= n; i++) {
            s += i;
        }

        permutation(s, 0, n-1);
        System.out.println(current);
        System.out.println(results.indexOf("124658793"));
        return results.get(k-1);
    }


    private void printRecursively(String s, int left, int right) {
        if (left == right) {
            current++;
            results.add(s);
        } else {
            for (int i=left; i<=right; i++) {
                s = swap(s, left, i);
                printRecursively(s, left+1, right);
                s = swap(s, left, i);
            }
        }

    }

    private void permutation(String s, int left, int right) {
        if (left == right) {
            current++;
            results.add(s);
        }
        else {
            for (int i = left; i <= right; i++) {
                s = swap(s, left, i);
                permutation(s, left+1, right);
                s = swap(s, left, i);
            }
        }
    }

    private String swap(String s, int left, int right) {
        char[] arr = s.toCharArray();
        char c = arr[left];
        arr[left] = arr[right];
        arr[right] = c;
        return String.valueOf(arr);

    }


    public String getPermutation2(int n, int k) {
        int[] f = new int[n+1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            f[i] = f[i-1] * i;
        }
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        StringBuilder sb = new StringBuilder("");
        k--;

        for (int i = 1; i <= n; i++) {
            int index = k/f[n-i];
            sb.append(nums.get(index));
            nums.remove(index);
            k -= index * f[n-i];
        }
        return sb.toString();
    }

    @Test
    public void test() {
        assertEquals(getPermutation2(3,3), "213");
    }

    @Test
    public void test1() {
        assertEquals(getPermutation2(9,1000), "124658793");
    }
}
