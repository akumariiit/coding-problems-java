package com.dogacoder.www.strings;

import org.junit.Test;

public class PalindromeDynamic {

    public int biggestPalindrome(String s) {
        int n = s.length();
        int[][] L = new int[n][n];
        for (int i = 0; i < n; i++) {
            L[i][i] = 1;
        }

        for (int cl = 2; cl <= n; cl++) {
            for (int i = 0; i < n-cl+1; i++) {
                int j = i + cl - 1;

                if (s.charAt(i) == s.charAt(j) && cl == 2) {
                    L[i][j] = 2;
                }
                else if (s.charAt(i) == s.charAt(j)) {
                    L[i][j] = L[i+1][j-1] + 2;
                }
                else {
                    L[i][j] = Math.max(L[i][j-1], L[i+1][j]);
                }
            }
        }
        return L[0][n-1];
    }

    @Test
    public void test() {
        String input = "abcddcbak";
        System.out.println(biggestPalindrome(input));
    }
}
