package com.tarun.general.basic;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestAreaSubmatrix {

    public static void main(String[] args) {

        int[][] matrix = {{1,1,0,1,1},
                          {1,1,1,1,1},
                          {0,1,1,1,1},
                          {1,1,1,1,1},
                          {1,0,1,1,1},
                          {1,1,1,1,0}};

        int maxArea = findLargestAreaSubmatrix(matrix);
        System.out.println(maxArea);

    }

    private static int findLargestAreaSubmatrix(int[][] matrix) {

        
        int [] area = matrix[0];
        int maxArea = findAreaOfBuildings(area);
        for (int i = 1; i < matrix.length ; i++){
            for (int j = 0 ; j < area.length ; j++){

                if (matrix[i][j] == 0){
                    area[j] = 0;
                }else {
                    area[j] = area[j] + 1;
                }
            }
            maxArea = Math.max(maxArea,findAreaOfBuildings(area));
        }

        return maxArea;
    }

    private static int findAreaOfBuildings(int[] area) {

        int[] previousMin = findPreviousMinIndex(area);
        int[] nextMin = findNextMinIndex(area);

        int maxArea = 0;

        for (int i = 0 ; i < area.length ; i++){

            int tempArea = (nextMin[i] - previousMin[i] - 1) * area[i];
            maxArea = Math.max(maxArea, tempArea);

        }

        return maxArea;
    }

    private static int[] findNextMinIndex(int[] area) {

        Deque<Integer> stack = new ArrayDeque<>();
        int[] answer = new int[area.length];
        for (int i = area.length -1 ; i >= 0 ; i--){

            while (!stack.isEmpty() && area[stack.peek()] >= area[i]){
                stack.pop();
            }
            if (stack.isEmpty()){
                answer[i] = area.length;
            }else if (area[stack.peek()] < area[i]){
                answer[i] = stack.peek();
            }

            stack.push(i);
        }
        return answer;
    }

    private static int[] findPreviousMinIndex(int[] area) {

        Deque<Integer> stack = new ArrayDeque<>();
        int[] answer = new int[area.length];
        for (int i = 0 ; i < area.length ; i++){

            while (!stack.isEmpty() && area[stack.peek()] >= area[i]){
                stack.pop();
            }
            if (stack.isEmpty()){
                answer[i] = -1;
            }else if (area[stack.peek()] < area[i]){
                answer[i] = stack.peek();
            }

            stack.push(i);
        }

        return answer;
    }


}
