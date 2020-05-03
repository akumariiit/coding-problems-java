package com.dogacoder.www.leetcode.may2020;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * https://leetcode.com/explore/challenge/card/May-Leetcoding-challenge/534/week-1-may-1st-may-7th/3318/
 *  Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 *
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 * Note:
 * You may assume that both strings contain only lowercase letters.
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 *
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> countMap = new HashMap<Character, Integer>();
        for (Character c: magazine.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0)+1);
        }
        for (Character c: ransomNote.toCharArray()) {
            if (!countMap.containsKey(c) || countMap.get(c) <= 0) {
                return false;
            }
            countMap.put(c, countMap.get(c) - 1);
        }
        return true;
    }

    @Test
    public void test() {
        String a = "aaa";
        String b = "abbaa";
        assertTrue(canConstruct(a, b));
    }
}
