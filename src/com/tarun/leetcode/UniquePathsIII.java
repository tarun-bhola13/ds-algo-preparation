package com.tarun.leetcode;

public class UniquePathsIII {
    // #leetcode 980
    public static void main(String[] args) {

        int[][] grid = {{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
        int result = findAllUniquePaths(grid);
        System.out.println(result);
    }

    private static int findAllUniquePaths(int[][] grid) {
        int startIndex = 0;
        int endIndex = 0;
        int zeroCount = 0;

        for (int i = 0; i< grid.length ; i++){
            for (int j= 0 ; j < grid[0].length ; j++){
                if (grid[i][j] == 1){
                    startIndex = i;
                    endIndex = j;
                }
                if (grid[i][j] == 0){
                    zeroCount++;
                }
            }
        }

        return dfs(grid,startIndex,endIndex,zeroCount);

    }

    private static int dfs(int[][] grid, int startIndex, int endIndex, int zeroCount) {


        if (startIndex < 0 || endIndex < 0 || startIndex >= grid.length
                || endIndex >= grid[0].length || grid[startIndex][endIndex] == -1){
            return 0;
        }

        if (grid[startIndex][endIndex] == 2){
            return zeroCount == -1 ? 1:0;
        }

        grid[startIndex][endIndex] = -1;
        zeroCount--;

        int totalPaths = dfs(grid,startIndex+1,endIndex,zeroCount)
                + dfs(grid,startIndex-1,endIndex, zeroCount)
                + dfs(grid,startIndex,endIndex+1,zeroCount)
                + dfs(grid,startIndex,endIndex-1,zeroCount);

        grid[startIndex][endIndex] = 0;
        zeroCount++;

        return totalPaths;

    }


}
