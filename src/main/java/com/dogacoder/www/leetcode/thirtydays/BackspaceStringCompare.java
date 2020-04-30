package com.dogacoder.www.leetcode.thirtydays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3291/
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 *
 * Note that after backspacing an empty text, the text will continue empty.
 *
 * Example 1:
 *
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 *
 * Example 2:
 *
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 *
 * Example 3:
 *
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 *
 * Example 4:
 *
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 *
 * Note:
 *
 *     1 <= S.length <= 200
 *     1 <= T.length <= 200
 *     S and T only contain lowercase letters and '#' characters.
 *
 * Follow up:
 *
 *     Can you solve it in O(N) time and O(1) space?
 *
 */
public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        String first = process(S);
        String second = process(T);
        return first.equals(second);
    }
    private String process(String s) {
        int t = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (t > -1) {
                    t--;
                }
            }
            else {
                t++;
                s = s.substring(0, t) + s.charAt(i) + s.substring(t+1);
            }
        }
        return s.substring(0, t+1);
    }

    @Test
    public void test() {
        String one = "ab#c";
        String two = "ad#c";
        assertTrue(backspaceCompare(one, two));

    }

    @Test
    public void test2() {
        String one = "ab##";
        String two = "c#d#";
        assertTrue(backspaceCompare(one, two));

    }

    @Test
    public void test3() {
        String one = "a##c";
        String two = "#a#c";
        assertTrue(backspaceCompare(one, two));

    }


    @Test
    public void test4() {
        String one = "#";
        String two = "#";
        assertTrue(backspaceCompare(one, two));

    }
}
