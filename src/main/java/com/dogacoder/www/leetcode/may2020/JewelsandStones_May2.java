package com.dogacoder.www.leetcode.may2020;


import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3317/
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 *
 * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".
 *
 * Example 1:
 *
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 *
 * Example 2:
 *
 * Input: J = "z", S = "ZZ"
 * Output: 0
 *
 * Note:
 *
 *     S and J will consist of letters and have length at most 50.
 *     The characters in J are distinct.
 *
 */
public class JewelsandStones_May2 {
    public int numJewelsInStones(String J, String S) {
        Map<Character, Boolean> charMap = new HashMap<>();
        for (int i=0; i<J.length(); i++) {
            charMap.put(J.charAt(i), true);
        }

        int ans = 0;
        for (int i=0; i<S.length(); i++) {
            if (charMap.containsKey(S.charAt(i))) {
                ans++;
            }
        }
        return ans;
    }

    @Test
    public void test() {
        String s = "aAAbbbb";
        String j = "aA";
        assertEquals(numJewelsInStones(j, s), 3);
    }

    @Test
    public void test2() {
        String s = "aAAbbbb";
        String j = "";
        assertEquals(numJewelsInStones(j, s), 0);
    }
    @Test
    public void test3() {
        String s = "ZZ";
        String j = "z";
        assertEquals(numJewelsInStones(j, s), 0);
    }
}
