package com.tarun.general.basic;

import java.util.ArrayDeque;
import java.util.Deque;

public class NextSmallerAndGreaterElement {

    public static void main(String[] args) {
        int[] input = {3,10,5,1,15,10,7,6};

        int[] output = findNextSmallerElement(input);

        print(output);
        output = findNextGreaterElement(input);
        print(output);
    }

    private static void print(int[] output) {

        for (int i : output){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static int[] findNextGreaterElement(int[] input) {

        Deque<Integer> stack = new ArrayDeque<>();
        int[] answer = new int[input.length];
        for (int i = input.length-1 ; i >= 0 ; i--){
            int element = input[i];
            while (!stack.isEmpty() && stack.peek() <= element){
                stack.poll();
            }

            if (stack.isEmpty()){
                answer[i] = -1;
            }
            else if (stack.peek() > element){
                answer[i] = stack.peek();
            }

            stack.push(element);
        }

        return answer;
    }

    private static int[] findNextSmallerElement(int[] input) {

        Deque<Integer> stack = new ArrayDeque<>();
        int[] answer = new int[input.length];
        for (int i = input.length-1 ; i >= 0 ; i--){
            int element = input[i];
            while (!stack.isEmpty() && stack.peek() >= element){
                stack.pollLast();
            }

            if (stack.isEmpty()){
                answer[i] = -1;
            }
            else if (stack.peek() < element){
                answer[i] = stack.peek();
            }

            stack.push(element);
        }

        return answer;
    }
}
