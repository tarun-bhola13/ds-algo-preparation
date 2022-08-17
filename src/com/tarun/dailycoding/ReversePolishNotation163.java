package com.tarun.dailycoding;

import com.tarun.general.Queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class ReversePolishNotation163 {
    // daily coding problem - 163

    public static void main(String[] args) {

        List<String> list = Arrays.
                asList("15", "7", "1", "1", "+", "-", "/", "3", "*", "2", "1", "1", "+", "+", "-");

        int result = evaluatePostFix(list);
        System.out.println(result);
    }

    private static int evaluatePostFix(List<String> list) {

        Deque<String> stack = new ArrayDeque<>();

        list.forEach(element -> {
            int firstNumber, secondNumber, result;
            switch (element) {
                case "+":
                    if (!stack.isEmpty()) {
                        secondNumber = Integer.parseInt(stack.poll());
                        firstNumber = Integer.parseInt(stack.poll());
                        result = firstNumber + secondNumber;
                        stack.push(String.valueOf(result));
                    }
                    break;

                case "-":
                    if (!stack.isEmpty()) {
                        secondNumber = Integer.parseInt(stack.poll());
                        firstNumber = Integer.parseInt(stack.poll());
                        result = firstNumber - secondNumber;
                        stack.push(String.valueOf(result));
                    }
                    break;

                case "*":
                    if (!stack.isEmpty()) {
                        secondNumber = Integer.parseInt(stack.poll());
                        firstNumber = Integer.parseInt(stack.poll());
                        result = firstNumber * secondNumber;
                        stack.push(String.valueOf(result));
                    }
                    break;

                case "/":
                    if (!stack.isEmpty()) {
                        secondNumber = Integer.parseInt(stack.poll());
                        firstNumber = Integer.parseInt(stack.poll());
                        result = firstNumber / secondNumber;
                        stack.push(String.valueOf(result));
                    }
                    break;
                default: stack.push(element);

            }
        });

        return Integer.parseInt(stack.pop());

    }
}
