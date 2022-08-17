package com.tarun.leetcode;

import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach {
    // #leetcode - 1642
    static int furthestBuilding;
    public static void main(String[] args) {
        int[] heights = {14,3,19,3};
        int bricks = 17;
        int ladders = 0;
        System.out.println(furthestBuildingOptimized(heights,bricks,ladders));
    }

    private static int furthestBuilding(int[] heights, int bricks, int ladders) {
        tryMoving(heights,bricks,ladders,1);
        return furthestBuilding;
    }

    private static void tryMoving(int[] heights, int bricks, int ladders, int index) {
        if(index >= heights.length ||ladders < 0 || bricks < 0){
            return;
        }
        int diff = heights[index-1] - heights[index];
        if(diff >= 0) {
            furthestBuilding = Math.max(furthestBuilding,index);
            tryMoving(heights, bricks, ladders, index + 1);
        }else {
            if(bricks - Math.abs(diff) >= 0){
                furthestBuilding = Math.max(furthestBuilding,index);
                tryMoving(heights,bricks-Math.abs(diff),ladders,index+1);
            }
            if(ladders > 0){
                furthestBuilding = Math.max(furthestBuilding,index);
                tryMoving(heights,bricks,ladders-1,index+1);
            }
        }
    }

    private static int furthestBuildingOptimized(int[] heights, int bricks, int ladders) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0 ; i < heights.length -1 ; i++){
            int diff = heights[i+1] - heights[i];
            if(diff > 0){
                pq.add(diff);
            }else{
                continue;
            }
            if(pq.size() > ladders){
                bricks -= pq.poll();
            }
            if(bricks < 0){
                return i;
            }
        }
        return heights.length - 1;
    }
}
