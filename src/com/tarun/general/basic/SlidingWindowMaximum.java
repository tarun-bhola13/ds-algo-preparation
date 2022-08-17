package com.tarun.general.basic;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {

    public static void main(String[] args) {

        int[] input = {4, 1, 3, 5, 1, 2, 3, 2, 1, 1, 5};
        int window = 3;

        int[] output = findMaxInSlidingWindow(input, window);
        output = findMaxInSlidingWindowUsingDeque(input,window);
        output = findMaxInSlidingWindowUsingPriorityQueue(input, window);

        for (int i : output) {
            System.out.println(i);
        }

    }

    private static  int[] findMaxInSlidingWindowUsingPriorityQueue(int[] input, int window){
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int[] output = new int[input.length-window+1];

        for (int i = 0 ; i < window ; i++){
            queue.add(input[i]);
        }
        int j = 0;
        output[j++] = queue.peek();
        for (int i = 3 ; i < input.length ; i++){
            queue.remove(input[i-window]);
            queue.add(input[i]);
            output[j++] = queue.peek();
        }
        return output;
    }

    private static int[] findMaxInSlidingWindowUsingDeque(int[] input, int window) {

        Deque<Integer> deque = new ArrayDeque<>();
        int[] output = new int[input.length - window + 1];

        deque.add(0);
        for (int i = 1 ; i < window ; i++){
            while (input[deque.peekLast()] < input[i]){
                deque.pollLast();
            }
            deque.add(i);
        }
        int j = 0;
        output[j++] = input[deque.element()];

        for (int i = 3; i < input.length; i++) {

                deque.remove(i - window);

            while (!deque.isEmpty() && input[deque.peekLast()] <= input[i]) {
                deque.pollLast();
            }
            deque.add(i);


            output[j++] = input[deque.element()];
        }

        return output;

    }


    private static int[] findMaxInSlidingWindow(int[] input, int window) {

        int[] output = new int[input.length - window + 1];
        for (int i = 0; i < output.length; i++) {
            int max = input[i];
            for (int j = i; j < input.length && j < i + window; j++) {
                if (max < input[j]) {
                    max = input[j];
                }
            }
            output[i] = max;
        }

        return output;
    }


}
