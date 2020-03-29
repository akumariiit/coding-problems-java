package com.dogacoder.www.strings;

import org.junit.jupiter.api.Test;

public class PalindromeRecursion {

    public int biggestPalindromeLength(String s) {

        return getLengthOfBiggestPalindrome(s.toCharArray(), 0, s.length()-1);
    }

    private int getLengthOfBiggestPalindrome(char[] input, int i, int j) {
        if (i == j) {
            return 1;
        }
        else if (input[i] == input[j] && j == i+1) {
            return 2;
        }
        else if (input[i] == input[j]) {
            return 2 + getLengthOfBiggestPalindrome(input, i+1, j-1);
        }
        return Math.max(getLengthOfBiggestPalindrome(input, i+1, j), getLengthOfBiggestPalindrome(input, i, j-1));
    }

    public String biggestPalindrome(String s) {

        return getBiggestPalindrome(s.toCharArray(), 0, s.length()-1);
    }

    private String getBiggestPalindrome(char[] input, int i, int j) {
        if (i == j) {
            return input[i]+"";
        }
        else if (input[i] == input[j] && j == i+1) {
            return input[i]+""+input[j];
        }
        else if (input[i] == input[j]) {
            return input[i] + "" + getBiggestPalindrome(input, i+1, j-1) + "" + input[j];
        }
        String res1 = getBiggestPalindrome(input, i+1, j);
        String res2 = getBiggestPalindrome(input, i, j-1);
        return (res1.length() > res2.length()) ? res1 : res2;
    }

    @Test
    public void test() {
        String input = "abcddcbak";
        System.out.println(biggestPalindromeLength(input));
    }

    @Test
    public void test2() {
        String input = "abcddcbak";
        System.out.println(biggestPalindrome(input));
    }
}
