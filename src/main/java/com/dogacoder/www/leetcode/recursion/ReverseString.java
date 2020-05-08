package com.dogacoder.www.leetcode.recursion;

import org.junit.jupiter.api.Test;

public class ReverseString {
    public void reverse(String s) {
        printRecur(s, 0, s.length());

    }

    private void printRecur(String s, int i, int length) {
        if (i >= length) {
            return;
        }
        printRecur(s, i+1, length);
        System.out.print(s.charAt(i));
    }

    public void reverseString(char[] s) {
        printRecur(s, 0, s.length);
    }

    private void printRecur(char[] s, int i, int length) {
        if (s==null || i >= length) {
            return;
        }
        printRecur(s, i+1, length);
        if (i >= length-i-1) {
            char temp = s[i];
            s[i] = s[length-i-1];
            s[length-i-1] = temp;
        }
    }

    @Test
    public void test() {
        reverse("abc");
    }

    @Test
    public void test2() {
        reverseString("abc".toCharArray());
    }
}
