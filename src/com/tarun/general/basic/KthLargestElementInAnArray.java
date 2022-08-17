package com.tarun.general.basic;

import java.util.Optional;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {

    public static void main(String[] args) {

        int[] input = {67,15,21,12,42,31,51,32,44};

        int k = 3;
        int element = findKthLargestElement(input, k);
        System.out.println(element);
    }

    private static int findKthLargestElement(int[] input, int k) throws NullPointerException{

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0 ; i < k ; i++){
            queue.add(input[i]);
        }

        for (int i = k ; i < input.length ; i++){

            Optional<Integer> element = Optional.of(queue.peek());

            if (element.isPresent()) {
                if (element.get() < input[i]) {
                    queue.poll();
                    queue.add(input[i]);
                }
            }
        }
        return queue.peek();
    }


}
