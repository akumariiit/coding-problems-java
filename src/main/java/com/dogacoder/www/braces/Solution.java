package com.dogacoder.www.braces;

import org.junit.Test;

import java.util.Stack;


class Solution {
    public boolean solution(String input) {
        // Type your solution here

        if (input.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        stack.push(input.charAt(0));

        for (int i = 1; i < input.length(); i++) {
            //stack.push(input.charAt(i));
            char c = input.charAt(i);
            if (c == ')' || c == '}' || c == ']') {
                char topChar = stack.peek();
                if ((c == ')' && topChar == '(') || (c == '}' && topChar == '{') || (c == ']' && topChar == '[')) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void test() {
        String s1 = "{()()}[]";
        String s2 = "()()()";
        String s3 = "({[]})";
        boolean ans = solution(s1);
        boolean ans2 = solution(s2);
        boolean ans3 = solution(s3);

        System.out.println(ans);
        System.out.println(ans2);
        System.out.println(ans3);
    }
}
