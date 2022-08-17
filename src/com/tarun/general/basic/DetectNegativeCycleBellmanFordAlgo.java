package com.tarun.general.basic;

import java.util.Arrays;

public class DetectNegativeCycleBellmanFordAlgo {

    public static void main(String[] args) {

       int[][] edges = {{0,1,-1},{1,2,-2},
            {2,0,-2}};
       int V = 3;
       int isNegativeCycle = isNegativeCycleExist(edges,V);
        System.out.println(isNegativeCycle);
    }

    private static int isNegativeCycleExist(int[][] edges, int v) {
        int[] shortestPaths = new int[v];
        Arrays.fill(shortestPaths,Integer.MAX_VALUE);
        shortestPaths[0]  = 0;
        for(int i = 1 ; i < v ; i++){
            for(int j = 0 ; j < v ; j++){
                int vertex = edges[j][0];
                int neighbour = edges[j][1];
                int weight = edges[j][2];
                if(shortestPaths[vertex] != Integer.MAX_VALUE && shortestPaths[neighbour] > shortestPaths[vertex] + weight){
                    shortestPaths[neighbour]  = shortestPaths[vertex] + weight;
                }
            }
        }

        for(int j = 0 ; j < v ; j++){
            int vertex = edges[j][0];
            int neighbour = edges[j][1];
            int weight = edges[j][2];
            if(shortestPaths[vertex] != Integer.MAX_VALUE && shortestPaths[neighbour] > shortestPaths[vertex] + weight){
                return 1;
            }
        }
        return 0;
    }


}
