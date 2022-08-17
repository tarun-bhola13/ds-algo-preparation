package com.tarun.general.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSortingInDirectedAcyclicGraphDfs {

    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        adj.add(List.of(0,2,3));
        adj.add(List.of(1,4));
        adj.add(List.of(2,3,1));
        adj.add(List.of(3,1));
        adj.add(List.of(4));
        adj.add(List.of(5,1,4));
        int V = 6;
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0 ; i < V ; i++){
            if(!visited[i]){
                dfs(i,adj,visited,stack);
            }
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    private static void dfs(int v, List<List<Integer>> adj, boolean[] visited, Stack<Integer> stack) {

        visited[v] = true;
        List<Integer> neighbours = adj.get(v);
        for(int i =1 ; i < neighbours.size() ; i++){
            int neighbour = neighbours.get(i);
            if(!visited[neighbour]){
                dfs(neighbour,adj,visited,stack);
            }
        }
        stack.push(v);
    }
}
