package com.tarun.leetcode;

public class UniquePathsII {
    // #leetcode - 63
    public static void main(String[] args) {

//        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
//        int[][] obstacleGrid = {{0,1,0,0},{0,0,1,0},{0,0,0,1},{1,0,0,0}};
        int[][] obstacleGrid = {{0}};
        int result = uniquePathsWithObstacles(obstacleGrid);
        System.out.println(result);
    }

    private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
     int m = obstacleGrid.length;
     int n = obstacleGrid[0].length;

     int[][] dp = new int[m+1][n+1];

     for(int i = 1 ; i <= m; i++){
         for(int j = 1 ; j <= n ;j++){
           if(i==1 && j ==1 && obstacleGrid[i-1][j-1] == 0) {
               dp[i][j] = 1;
           }
           else if(obstacleGrid[i-1][j-1] == 0) {
               dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
           }
         }
     }

     return dp[m][n];

    }


}
