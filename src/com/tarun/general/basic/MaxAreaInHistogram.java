package com.tarun.general.basic;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxAreaInHistogram {

    public static void main(String[] args) {

        int[] input = {4,2,1,5,6,3,2,4,2};

        int maxArea = findMaxAreaInHistogram(input);

        System.out.println(maxArea);
    }

    private static int findMaxAreaInHistogram(int[] input) {

        int[] previousSmaller = findPreviousSmaller(input);
        int[] nextSmaller = findNextSmaller(input);
        int maxArea = 0;
        for (int i = 0 ; i < input.length ;i++){
            int area = (nextSmaller[i]-previousSmaller[i] -1) * input[i];

            maxArea = Math.max(maxArea,area);
        }

        return maxArea;
    }

    private static int[] findNextSmaller(int[] input) {

        Deque<Integer> stack = new ArrayDeque<>();
        int[] answer = new int[input.length];

        for (int i = input.length-1 ; i >= 0 ; i--){

            while (!stack.isEmpty() && input[stack.peek()]  >= input[i]){
                stack.pop();
            }
            if (stack.isEmpty()){
                answer[i] = input.length;
            }else if(input[stack.peek()] < input[i]){
                answer[i] = stack.peek();
            }
            stack.push(i);
        }
        return answer;
    }

    private static int[] findPreviousSmaller(int[] input) {

        Deque<Integer> stack = new ArrayDeque<>();
        int[] answer = new int[input.length];

        for (int i = 0 ; i < input.length ; i++){

            while (!stack.isEmpty() && input[stack.peek()]  >= input[i]){
                stack.pop();
            }
            if (stack.isEmpty()){
                answer[i] = -1;
            }else if(input[stack.peek()] < input[i]){
                answer[i] = stack.peek();
            }
            stack.push(i);
        }
        return answer;
    }


}
