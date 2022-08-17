package com.tarun.general.basic;

import java.util.Stack;

public class PreviousSmallerElement {
    // Previous Smaller and Greater elements

    public static void main(String[] args) {

        int[] input = {4,10,5,18,13,3,12,7};

        int[] output = findPreviousSmallerElement(input);

        for (int i : output){
            System.out.println(i);
        }

        output = findPreviousGreaterElement(input);
        System.out.println("--------------");
        for (int i : output){
            System.out.println(i);
        }
    }

    private static int[] findPreviousSmallerElement(int[] input) {

        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[input.length];

        for (int i = 0 ; i < input.length ; i++){

            int element = input[i];
            while (!stack.isEmpty() && stack.peek() >= element){
                stack.pop();
            }
            if (stack.isEmpty()){
                answer[i] = -1;

            }else if(stack.peek() < element) {
                answer[i] = stack.peek();

            }
            stack.push(element);
        }
        return answer;
    }

    private static int[] findPreviousGreaterElement(int[] input) {

        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[input.length];

        for (int i = 0 ; i < input.length ; i++){

            int element = input[i];
            while (!stack.isEmpty() && stack.peek() <= element){
                stack.pop();
            }
            if (stack.isEmpty()){
                answer[i] = -1;

            }else if(stack.peek() > element) {
                answer[i] = stack.peek();

            }
            stack.push(element);
        }
        return answer;
    }
}
