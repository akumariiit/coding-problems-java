package com.dogacoder.www.leetcode.biweekly25;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxDiff {
    public int maxDiff(int num) {
        String s1 = num+"";
        String a = "";
        String b = "";
        for (int i = 0; i < s1.length(); i++) {
            if (Integer.parseInt(s1.charAt(i)+"") != 9) {
                a = s1.charAt(i)+"";
                break;
            }
        }
        boolean firstChar = false;
        for (int i = 0; i < s1.length(); i++) {
            if (Integer.parseInt(s1.charAt(i)+"") > 1) {
                b = s1.charAt(i)+"";
                if (i == 0) {
                    firstChar = true;
                }
                break;
            }
        }
        if (!a.isEmpty()) {
            s1 = s1.replaceAll(a, "9");
        }
        String s2 = num+"";
        if (!b.isEmpty()) {
            if (firstChar) {
                s2 = s2.replaceAll(b, "1");
            }
            else {
                s2 = s2.replaceAll(b, "0");
            }

        }
        return Integer.parseInt(s1) - Integer.parseInt(s2);
    }

    @Test
    public void test() {
        int n = 555;
        assertEquals(maxDiff(n), 888);
    }
    @Test
    public void test2() {
        int n = 9;
        assertEquals(maxDiff(n), 8);
    }
    @Test
    public void test3() {
        int n = 123456;
        assertEquals(maxDiff(n), 820000);
    }
    @Test
    public void test4() {
        int n = 9288;
        assertEquals(maxDiff(n), 8700);
    }

    @Test
    public void test5() {
        int n = 1101057;
        assertEquals(maxDiff(n), 8808050);

        // 9909057
        //
    }
}
