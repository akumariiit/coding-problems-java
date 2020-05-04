package com.dogacoder.www.leetcode.may2020;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberComplement {
    public int findComplement(int num) {
        String bin = getBinary(num);
        for (int i = bin.length() - 1; i >= 0; i--) {
            if (bin.charAt(i) == '1') {
                bin = bin.substring(0, i) + '0' + bin.substring(i+1);
            }
            else {
                bin = bin.substring(0, i) + '1' + bin.substring(i+1);
            }
        }
        int msb = getMSB(bin);
        if (msb == -1) {
            return 0;
        }
        int res = 0;
        for (int i = msb; i < bin.length(); i++) {
            if (bin.charAt(i) == '1') {
                res += 1 << bin.length() - (i + 1);
            }
        }
        return res;
    }

    public int findComplement_Quick(int num) {
        int cp = num;
        int sum = 0;
        while(num > 0){
            sum = (sum << 1) + 1;
            num >>= 1;
        }
        return sum - cp;

    }

    private int getMSB(String bin) {
        for (int i = 0; i < bin.length(); i++) {
            if (bin.charAt(i) == '1') {
                return i;
            }
        }
        return -1;
    }

    private String getBinary(int num) {
        if (num <= 1) {
            return num+"";
        }
        else {
            return getBinary(num/2) + num%2 + "";
        }
    }

    @Test
    public void test() {
        assertEquals(findComplement(5), 2);
    }

    @Test
    public void test2() {
        assertEquals(findComplement(1), 0);
    }
}
