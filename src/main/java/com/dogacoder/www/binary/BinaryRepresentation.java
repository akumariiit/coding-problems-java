package com.dogacoder.www.binary;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class BinaryRepresentation {

    public String getBinaryRepresentation(int n) {
        return convert(n, "");
    }

    private String convert(int n, String s) {
        if (n == 1 || n == 0) {
            return n + "";
        }
        return convert(n/2, s) + n%2;
    }

    @Test
    public void testBinaryRepresentation() {
        assertTrue(getBinaryRepresentation(2).equals("10"));
    }

}
