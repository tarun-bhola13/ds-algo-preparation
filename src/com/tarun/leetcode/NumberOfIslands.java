package com.tarun.leetcode;

public class NumberOfIslands {
    // #leetcode - 200
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        System.out.println(numIslands(grid));
    }

    private static int numIslands(char[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int count = 0;
        for(int i = 0 ; i < grid.length ;i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                count += findNumberOfIslands(grid,visited,i,j);
            }
        }
        return count;
    }

    private static int findNumberOfIslands(char[][] grid, int[][] visited, int row, int col) {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length){
            return 0;
        }
        if (visited[row][col] == 1 || grid[row][col] == '0'){
            return 0;
        }
        if(grid[row][col] == '1'){
            visited[row][col] = 1;
            findNumberOfIslands(grid,visited,row+1,col);
            findNumberOfIslands(grid,visited,row-1,col);
            findNumberOfIslands(grid,visited,row,col+1);
            findNumberOfIslands(grid,visited,row,col-1);

            return 1;
        }
        return 0;
    }
}
