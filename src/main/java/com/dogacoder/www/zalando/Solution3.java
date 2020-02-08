package com.dogacoder.www.zalando;

import org.junit.Test;

import java.util.*;

public class Solution3 {

    public int solution(int[] input) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int number: input) {
            int existingCount = countMap.getOrDefault(number, 0);
            countMap.put(number, existingCount + 1);
        }
        Long countOfPairs = 0L;

        for(Integer count: countMap.values()) {
            long value = (long)count - 1;
            countOfPairs += (value*(1+value)/2);
        }
        if(countOfPairs > 1000000000) {
            return 1000000000;
        }
        return countOfPairs.intValue();
    }

    public int solution1(int[] input) {
        Long count = 0L;
        for (int i = 0; i < input.length; i++) {
            for (int j = i+1; j < input.length; j++) {
                if (input[i] == input[j]) {
                    count++;
                    if (count > 1000000000) {
                        return 1000000000;
                    }
                }
            }
        }

        return count.intValue();
    }


    public boolean solution(String input) {

        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        for(Character c: input.toCharArray()) {
            if(c == '(' || c=='{' || c=='[') {
                stack.addFirst(c);
            } else {
                Character top = stack.peekFirst();
                Character expected = map.get(top);
                if(expected != c) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        return (stack.size() == 0);

    }
    public boolean solution1(String input) {
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
        int [] input = {3,5,6,3,3,5};
        int ans = solution1(input);
        System.out.println(ans);

//        String s1 = "{()()}[]";
//        String s2 = "()()()";
//        String s3 = "({[]})";
//
//        String s4 = ")(()()";
//        String s5 = "([)]";
//        String s6 = "[{((})]";

//        boolean ans = solution(s4);
//        boolean ans2 = solution(s5);
//        boolean ans3 = solution(s6);
//
//        System.out.println(ans);
//        System.out.println(ans2);
//        System.out.println(ans3);
//
//        System.out.println(solution(s1));
//        System.out.println(solution(s2));
//        System.out.println(solution(s3));
    }

    @Test
    public void test1() {
        Deque<Character> stack = new ArrayDeque<>();
        String s = "{()()}[]";
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');


        for(Character c: s.toCharArray()) {
            if(c == '(' || c=='{' || c=='[') {
                stack.addFirst(c);
            } else {
                Character top = stack.peekFirst();
                Character expected = map.get(top);
                if(expected != c) {
                    System.out.println("invalid");
                    return;
                } else {
                    stack.pop();
                }
            }
        }

        if(stack.size() == 0) {
            System.out.println("valid");
        } else {
            System.out.println("invalid: " + stack.size());
        }
    }
}
