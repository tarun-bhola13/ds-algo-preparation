package com.tarun.general.basic;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleInDirectedGraph {

    public static void main(String[] args) {

        List<List<Integer>> adj = new ArrayList<>();
        adj.add(List.of(0,1));
        adj.add(List.of(1));
        adj.add(List.of(2,1,3));
        adj.add(List.of(3,4));
        adj.add(List.of(4,2));
        int V = 5;
        boolean[] visited = new boolean[V];
        boolean[] recS = new boolean[V];

        for (int i = 0 ; i < V ; i++){
            if(!visited[i]){
                if(dfs(i,adj,visited,recS)){
                    System.out.println("Cycle in present in this graph");
                }
            }
        }
    }

    private static boolean dfs(int v, List<List<Integer>> adj, boolean[] visited, boolean[] recS) {
        visited[v] = true;
        recS[v] = true;

        List<Integer> neighbours = adj.get(v);
        for (int i = 1 ; i < neighbours.size() ;i++){
            if(!visited[neighbours.get(i)]){
                if(dfs(neighbours.get(i),adj,visited,recS)){
                    return true;
                }
            }else if(recS[neighbours.get(i)]){
                return true;
            }
        }
        recS[v] = false;
        return false;
    }


}
