package com.tarun.leetcode;

import java.util.Arrays;
import java.util.List;

public class Triangle {
    // #leetcode - 120

    public static void main(String[] args) {
        List<List<Integer>> triangle = List.of(List.of(2),List.of(3,4),List.of(6,5,7),List.of(4,1,8,3));
        System.out.println(minimumTotal(triangle));
    }

    private static int minimumTotal(List<List<Integer>> triangle) {

        int[][] dp = new int[triangle.size()][triangle.get(triangle.size()-1).size()];

        for(int[] rows : dp){
            Arrays.fill(rows,Integer.MAX_VALUE);
        }

        return recurse(triangle,0,0,dp);
    }

    private static int recurse(List<List<Integer>> triangle, int row, int col, int[][] dp) {

        if(row == triangle.size()){
            return 0;
        }

        if(dp[row][col] != Integer.MAX_VALUE){
            return dp[row][col];
        }

        int minimum = Math.min(recurse(triangle,row+1,col,dp),recurse(triangle,row+1,col+1,dp));

        dp[row][col] = triangle.get(row).get(col) + minimum;

        return dp[row][col];

    }
}
