package com.tarun.general.basic;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianOfRunningStream {

    public static void main(String[] args) {

        int[] input = {2,5,3,4,6,8,7,9};

        printMedianOfStream(input);
    }

    private static void printMedianOfStream(int[] input) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0 ; i < input.length ; i++){

            if (maxHeap.size() == 0){
                maxHeap.add(input[i]);
            }
            else if (minHeap.size() == maxHeap.size()){
                if (minHeap.peek() < input[i]){
                    maxHeap.add(minHeap.poll());
                    minHeap.add(input[i]);
                }else {
                    maxHeap.add(input[i]);
                }
            }else {
                if (maxHeap.peek() > input[i]){
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(input[i]);
                }else {
                    minHeap.add(input[i]);
                }
            }

            if (((minHeap.size() + maxHeap.size()) & 1) == 0){
                double average = (minHeap.peek() + maxHeap.peek()) / 2.0;
                System.out.println(average);
            }else {
                System.out.println(maxHeap.peek());
            }
        }
    }


}
