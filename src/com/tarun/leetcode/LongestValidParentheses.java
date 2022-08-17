package com.tarun.leetcode;

import java.util.Stack;

public class LongestValidParentheses {

    public static void main(String[] args) {
        String s = "())";
        int result = longestValidParentheses(s);
        System.out.println(result);
    }

    private static int longestValidParentheses(String s) {
        int length = s.length();
        if (length <= 1) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            if (stack.isEmpty()) {
                    stack.push(i);

            } else {
                if (s.charAt(i) == ')' && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                } else {
                    stack.push(i);
                }
            }
        }
            int count = 0;
            int lastIndex = length;
            while (!stack.isEmpty()) {
                int index = stack.pop();
                count = Math.max(count, lastIndex - index - 1);
                lastIndex = index;
            }
            count = Math.max(count,lastIndex);

        return count;
    }
}
