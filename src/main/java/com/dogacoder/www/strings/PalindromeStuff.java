package com.dogacoder.www.strings;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PalindromeStuff {

    public boolean isPalindrome(String input) {
        char[] in = input.toCharArray();
        int size = input.length();

        int start = 0;
        int end = size-1;

        while (start <= end) {
            if (in[start] != in[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public List<Palindrome> biggestPalindrome(String input) {

        int size = input.length();

        while (size > 0) {
            List<Palindrome> palindromes = getPalindromesOfSize(size, input);
            if (!palindromes.isEmpty()) {
                return palindromes;
            }
            else {
                size--;
            }
        }
        return Collections.emptyList();
    }

    private List<Palindrome> getPalindromesOfSize(int k, String input) {
        List<Palindrome> res = new ArrayList<>();
        int start = 0;
        int end = k-1;
        int size = input.length();

        while(end < size) {
            String s = input.substring(start, end+1);
            if (isPalindrome(s)) {
                res.add(new Palindrome(s.length(), s));
            }
            start++;
            end++;
        }
        return res;
    }

    class Palindrome {
        int size;
        String value;

        public Palindrome(int size, String value) {
            this.size = size;
            this.value = value;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        @Override
        public String toString() {
            return "Palindrome{" +
                    "size=" + size +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

    @Test
    public void testBiggestPalindrome() {
        String input = "abcddcbak";
        System.out.println(biggestPalindrome(input));
    }

    @Test
    public void testPalindrome() {
        String input = "abcddcbak";
        System.out.println(isPalindrome(input));
    }
}
