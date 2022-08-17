package com.tarun.general.basic;

import java.util.ArrayList;
import java.util.List;

public class DFS {

    public static void main(String[] args) {

        List<List<Integer>> adj = new ArrayList<>();
        adj.add(List.of(0,1,2));
        adj.add(List.of(1,2,3,0));
        adj.add(List.of(2,1,0));
        adj.add(List.of(3,1));
        adj.add(List.of(4,5));
        adj.add(List.of(5,4));
        boolean[] visited = new boolean[adj.size()];
        List<Integer> dfs = new ArrayList<>();
        int v = 0;

        for (int i = 0 ; i < visited.length ;i++){
            if(!visited[i]){
                dfs(i,adj,visited,dfs);
            }
        }

        dfs.forEach(System.out::println);

    }

    private static void dfs(int v, List<List<Integer>> adj, boolean[] visited, List<Integer> dfs) {
        visited[v] = true;
        dfs.add(v);
        List<Integer> neighbours = adj.get(v);

        for(Integer neighbour : adj.get(v)){
            if(!visited[neighbour]){
                dfs(neighbour,adj,visited,dfs);
            }
        }
    }

}
