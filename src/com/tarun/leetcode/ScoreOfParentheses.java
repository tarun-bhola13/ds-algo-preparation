package com.tarun.leetcode;

import java.util.Stack;

public class ScoreOfParentheses {

    public static void main(String[] args) {

        String s = "(((()))())";
        int score = scoreOfParentheses(s);
        System.out.println(score);
    }

    private static int scoreOfParentheses(String s) {

        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c + "");
            } else {
                if (c == ')') {
                    int innerScore = 0;
                    while (!stack.isEmpty() && !stack.peek().equals("(")) {
                        innerScore += Integer.valueOf(stack.pop());
                    }
                    stack.pop();

                    if (innerScore == 0) {
                        stack.push("1");
                    } else {
                        stack.push(2 * innerScore + "");
                    }
                } else {
                    stack.push(c + "");
                }

            }
        }
        int score = 0;
        while (!stack.isEmpty()) {
            score += Integer.valueOf(stack.pop());
        }
        return score;
    }

}


