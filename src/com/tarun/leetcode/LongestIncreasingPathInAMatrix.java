package com.tarun.leetcode;

public class LongestIncreasingPathInAMatrix {
    //#leetcode - 329
    private static int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
    public static void main(String[] args) {
        int[][] matrix =  {{9,9,4},{6,6,8},{2,1,1}};

        int result = longestIncreasingPath(matrix);
        System.out.println(result);
    }

    private static int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] cache = new int[m][n];
        int maxLength = 1;

        for(int i= 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){

                int currentLength = dfs(i,j,matrix,m,n,cache);
                maxLength = Math.max(maxLength,currentLength);
            }
        }
return maxLength;
    }

    private static int dfs(int i, int j, int[][] matrix, int m, int n, int[][] cache) {

        if(i <0 || j < 0 || i >=m || j >=n){
            return 0;
        }
        if(cache[i][j] > 0){
            return cache[i][j];
        }
        int currentLength = 1;
        for(int[] direction : directions){
            int xNeigh = i + direction[0];
            int yNeigh = j + direction[1];

            if(xNeigh < 0 || yNeigh <0 || xNeigh >=m || yNeigh >= n){
                continue;
            }
            if(matrix[i][j] <= matrix[xNeigh][yNeigh]){
                continue;
            }

            currentLength = Math.max(currentLength,1 + dfs(xNeigh,yNeigh,matrix,m,n,cache));

        }
        cache[i][j] = currentLength;

        return currentLength;
    }
}
