package com.tarun.leetcode;

import java.util.Stack;

public class BaseballGame {
    // #leetcode-682

    public static void main(String[] args) {
        String[] ops = {"5", "-2","4", "C", "D","9" ,"+","+"};

        int points = calPoints(ops);
        System.out.println(points);
    }

    private static int calPoints(String[] ops) {

        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (int i = 0; i < ops.length; i++) {
            String op = ops[i];
            switch (op) {
                case "C":
                    sum = sum - stack.pop();
                    break;
                case "D":
                    int element = 2 * stack.peek();
                    stack.push(element);
                    sum = sum + element;
                    break;
                case "+":
                    int firstElement = stack.pop();
                    int secondElement = stack.peek();
                    int newElement = firstElement + secondElement;
                    stack.push(firstElement);
                    stack.push(newElement);
                    sum = sum + newElement;
                    break;
                default:
                    int value = Integer.valueOf(op);
                    sum = sum + value;
                    stack.push(value);
                    break;
            }
        }

        return sum;
    }
}
