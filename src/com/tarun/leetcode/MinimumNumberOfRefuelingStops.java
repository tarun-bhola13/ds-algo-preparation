package com.tarun.leetcode;

import java.util.PriorityQueue;

public class MinimumNumberOfRefuelingStops {
    // #leetcode - 871
    public static void main(String[] args) {
        int target = 100;
        int startFuel = 10;
        int[][] stations = {{10, 60}, {20, 30}, {30, 30}, {60, 40}};
        System.out.println(minRefuelStops(target, startFuel, stations));
    }

    private static int minRefuelStops(int target, int startFuel, int[][] stations) {

        int numberOfStops = 0;
        int xCurrent = startFuel;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int[] station : stations) {
            int nextStation = station[0];
            int fuel = station[1];
            while (xCurrent < nextStation) {
                if (pq.isEmpty()) {
                    return -1;
                }
                int fuelTopUp = pq.poll();
                xCurrent += fuelTopUp;
                numberOfStops++;
            }
            pq.add(fuel);
        }

        while (xCurrent < target) {
            if (pq.isEmpty()) {
                return -1;
            }
            int fuelTopUp = pq.poll();
            xCurrent += fuelTopUp;
            numberOfStops++;
        }
        return numberOfStops;
    }

}
