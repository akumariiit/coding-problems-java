package com.dogacoder.www.leetcode.june2020;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals(getPermutation(3,3), "213");
    }

    @Test
    public void test1() {
        assertEquals(getPermutation(9,1000), "124658793");
    }
}
