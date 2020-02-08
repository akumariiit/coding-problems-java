package com.dogacoder.www.zalando;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution {

    public int count(String s) {

        int ans = 0;
        boolean firstOneFound = false;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '1') {
                if (!firstOneFound) {
                    firstOneFound = true;
                    ans+= 1;
                } else {
                    ans += 2;
                }
            } else {
                if (firstOneFound) {
                    ans+= 1;
                }
            }
        }
        return ans;
    }
    public int solution(String S) {

        int firstIndexOfOne = getFirstIndexOfOne(S);

        if (firstIndexOfOne == -1) {
            return 0;
        }

        int countOfZeroes = getCountOfZeroesAfterFirstOne(firstIndexOfOne, S);
        int countOfOnes = getNumberOfOnes(firstIndexOfOne, S);

        System.out.println("countOfZeroes" + countOfZeroes);
        System.out.println("countOfOnes" + countOfOnes);

        return countOfZeroes + (2*countOfOnes) - 1;
    }

    private int getNumberOfOnes(int firstIndexOfOne, String s) {
        int countOfOnes = 0;
        for (int i=firstIndexOfOne; i<s.length(); i++) {
            if (s.charAt(i) == '1') {
                countOfOnes++;
            }
        }
        return countOfOnes;
    }

    private int getCountOfZeroesAfterFirstOne(int firstIndexOfOne, String s) {
        int countOfZeros = 0;
        for (int i=firstIndexOfOne; i<s.length(); i++) {
            if (s.charAt(i) == '0') {
                countOfZeros++;
            }
        }
        return countOfZeros;
    }

    private int getFirstIndexOfOne(String s) {
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '1') {
                return i;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        //String s = "011100";
        //String s = "111010";
        String s = "0";
        assertEquals(solution(s), 9);
    }
}
