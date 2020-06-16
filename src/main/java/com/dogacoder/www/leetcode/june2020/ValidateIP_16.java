package com.dogacoder.www.leetcode.june2020;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidateIP_16 {


    public String validIPAddress(String IP) {
        if (IP == null || IP.length() == 0) {
            return "Neither";
        }
        Map<Character, Boolean> hexMap = create();
        String[] parts = IP.split(":");
        if (parts.length == 1) {
            parts = IP.split("\\.");
        }
        if (!(parts.length == 4 || parts.length == 8)
                || IP.startsWith(".") || IP.endsWith(".")
                || IP.startsWith(":") || IP.endsWith(":")) {
            return "Neither";
        }
        if (parts.length == 4 && isValidV4(parts)) {
            return "IPv4";
        }
        if (parts.length == 8 && isValidV6(parts, hexMap)) {
            return "IPv6";
        }
        return "Neither";
    }

    private boolean isValidV4(String[] parts) {
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].length() == 0) {
                return false;
            }
            if (parts[i].length() > 1 && parts[i].startsWith("0")) {
                return false;
            }
            if (parts[i].contains("-")) {
                return false;
            }
            try {
                int value = Integer.parseInt(parts[i]);
                if (value < 0 || value > 255) {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidV6(String[] parts, Map<Character, Boolean> hexMap) {
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].length() < 1 || parts[i].length() > 4) {
                return false;
            }
            char[] arr = parts[i].toCharArray();
            for (int j = 0; j < arr.length; j++) {
                if (!hexMap.containsKey(arr[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    private Map<Character, Boolean> create() {
        Map<Character, Boolean> hexMap = new HashMap<>();
        hexMap.put('0', true);
        hexMap.put('1', true);
        hexMap.put('2', true);
        hexMap.put('3', true);
        hexMap.put('4', true);
        hexMap.put('5', true);
        hexMap.put('6', true);
        hexMap.put('7', true);
        hexMap.put('8', true);
        hexMap.put('9', true);
        hexMap.put('a', true);
        hexMap.put('b', true);
        hexMap.put('c', true);
        hexMap.put('d', true);
        hexMap.put('e', true);
        hexMap.put('f', true);
        hexMap.put('A', true);
        hexMap.put('B', true);
        hexMap.put('C', true);
        hexMap.put('D', true);
        hexMap.put('E', true);
        hexMap.put('F', true);
        return hexMap;
    }

    @Test
    public void test() {
        String s = "2001:0db8:85a3:0000:0000:8a2e:0370:7334";
        assertEquals(validIPAddress(s), "IPv6");
    }

    @Test
    public void test1() {
        String s = "2001:db8:85a3:0:0:8A2E:0370:7334";
        assertEquals(validIPAddress(s), "IPv6");
    }

    @Test
    public void test2() {
        String s = "2001:0db8:85a3::8A2E:0370:7334";
        assertEquals(validIPAddress(s), "Neither");
    }

    @Test
    public void test3() {
        String s = "02001:0db8:85a3:0000:0000:8a2e:0370:7334";
        assertEquals(validIPAddress(s), "Neither");
    }

    @Test
    public void test4() {
        String s = "172.16.254.1";
        assertEquals(validIPAddress(s), "IPv4");
    }

    @Test
    public void test5() {
        String s = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
        assertEquals(validIPAddress(s), "Neither");
    }

    @Test
    public void test6() {
        String s = "1.1.1.1.";
        assertEquals(validIPAddress(s), "Neither");
    }

    @Test
    public void test7() {
        String s = ".1.1.1.1";
        assertEquals(validIPAddress(s), "Neither");
    }

    @Test
    public void test8() {
        String s = "15.16.-0.1";
        assertEquals(validIPAddress(s), "Neither");
    }

    @Test
    public void test9() {
        String s = "192.0.0.1";
        assertEquals(validIPAddress(s), "IPv4");
    }
}
