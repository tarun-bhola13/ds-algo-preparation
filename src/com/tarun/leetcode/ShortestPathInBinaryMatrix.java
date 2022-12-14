package com.tarun.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {

    public static void main(String[] args) {
        int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};
        int output = shortestPathBinaryMatrix(grid);
        System.out.println(output);
    }

    private static int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length-1;
        if(grid[0][0] == 1 || grid[n][n] == 1){
            return -1;
        }
        int level = 0;
        Queue<Point> qu = new LinkedList<>();
        qu.offer(new Point(0,0));
        while (!qu.isEmpty()){
            int size = qu.size();
            while (size-- > 0){
                Point point = qu.poll();
                int x = point.x;
                int y = point.y;
                if(x == n && y == n){
                    return level+1;
                }
                if(x > n || y > n || x < 0 || y <0 || grid[x][y] >= 1){
                    continue;
                }
                grid[x][y] = 2;
                qu.offer(new Point(x+1,y));
                qu.offer(new Point(x+1,y+1));
                qu.offer(new Point(x+1,y-1));
                qu.offer(new Point(x,y+1));
                qu.offer(new Point(x,y-1));
                qu.offer(new Point(x-1,y+1));
                qu.offer(new Point(x-1,y-1));
                qu.offer(new Point(x-1,y));

            }
            level++;
        }
        return -1;
    }

    public static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
