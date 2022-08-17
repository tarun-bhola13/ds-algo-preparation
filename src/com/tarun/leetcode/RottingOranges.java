package com.tarun.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    // leetcode 994

    public static void main(String[] args) {

        int[][] grid = {{2,1,1},{0,1,1},{1,0,1}};

        int result = findTimeForRotting(grid);
        System.out.println(result);

    }

    static class Point{
        int x;
        int y;

        Point(int x , int y){
            this.x = x;
            this.y = y;
        }
    }

    private static int findTimeForRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        if (n == 0 && m == 0){
            return 0;
        }

        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < n ; i++){
            for(int j =0 ; j < m ; j++){
                if (grid[i][j] == 2){
                    queue.offer(new Point(i,j));
                }
            }
        }
        int level = 0;
        if (!queue.isEmpty()){
            while (!queue.isEmpty()){
                int size = queue.size();
                while (size-- > 0){

                    Point head = queue.poll();
                    int i = head.x;
                    int j = head.y;

                    if (i >= n || i < 0 || j >= m || j < 0 || grid[i][j] == 0){
                        continue;
                    }

                    if (i >= 1 && grid[i-1][j] == 1){
                        grid[i-1][j] = 3;
                        queue.offer(new Point(i-1,j));
                    }

                    if (i < n-1 && grid[i+1][j] == 1){
                        grid[i+1][j] = 3;
                        queue.offer(new Point(i+1,j));
                    }

                    if (j >= 1 && grid[i][j-1] == 1){
                        grid[i][j-1] = 3;
                        queue.offer(new Point(i,j-1));
                    }

                    if (j < m-1 && grid[i][j+1] == 1){
                        grid[i][j+1] = 3;
                        queue.offer(new Point(i,j+1));
                    }
                }
                level++;
            }
        }

        for (int i = 0; i < n ; i++){
            for (int j = 0 ; j < m ;j++){
                if (grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return level > 0 ? level-1 : 0;
    }


}
