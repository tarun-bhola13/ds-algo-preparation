package com.tarun.general.basic;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleInUndirectedGraph {

    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        adj.add(List.of(1,2));
        adj.add(List.of(2,3,0));
        adj.add(List.of(1,0));
        adj.add(List.of(1));
        adj.add(List.of(5));
        adj.add(List.of(4));
//        adj.add(List.of(1,2));
//        adj.add(List.of(0));
//        adj.add(List.of(3,0));
//        adj.add(List.of(4,2));
//        adj.add(List.of(3));
        boolean[] visited = new boolean[adj.size()];
        int v = 0;
        for (int i = 0 ; i < visited.length ; i++){
            if(!visited[i]){
                if(dfs(i,adj,visited,-1)){
                    System.out.println("Cycle is present in graph");
                    break;
                }
            }
        }
    }

    private static boolean dfs(int v, List<List<Integer>> adj, boolean[] visited, int parent) {
        visited[v] = true;
        for(int neighbour : adj.get(v)){
            if(!visited[neighbour]) {

                if (dfs(neighbour, adj, visited, v)) {
                    return true;
                }
            }else if(parent != neighbour){
                    return true;
            }
        }
        return false;
    }

}
