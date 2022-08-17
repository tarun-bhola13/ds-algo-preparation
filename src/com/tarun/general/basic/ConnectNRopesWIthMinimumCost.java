package com.tarun.general.basic;

import java.util.PriorityQueue;

public class ConnectNRopesWIthMinimumCost {

    public static void main(String[] args) {

        int[] input = {2,5,4,8,6,9};

        int minCost = findMinimumCost(input);
        System.out.println(minCost);
    }

    private static int findMinimumCost(int[] input) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i : input){
            queue.add(i);
        }

        int cost = 0;
        int minCost = 0;
        while (queue.size() != 1){

            cost =  queue.poll() + queue.poll();

            queue.add(cost);
            minCost = minCost + cost;

        }

        return minCost;
    }


}
