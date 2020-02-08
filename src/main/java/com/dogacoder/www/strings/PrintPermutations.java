package com.dogacoder.www.strings;

import org.junit.Test;

public class PrintPermutations {

    public void printPermutations(String s) {
        System.out.println(s);

        final int size = s.length();
        printRecursively(s, 0,  size-1);

    }

    private void printRecursively(String s, int left, int right) {
        if (left == right) {
            System.out.println(s);
        } else {
            for (int i=left; i<=right; i++) {
                s = swap(s, left, i);
                printRecursively(s, left+1, right);
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

    @Test
    public void testPrintPermutations() {
        String s = "ABCD";
        printPermutations(s);
    }
}
