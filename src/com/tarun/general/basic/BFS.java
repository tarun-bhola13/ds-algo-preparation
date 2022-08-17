package com.tarun.general.basic;

import java.util.ArrayList;
import java.util.LinkedList;

public class BFS {

    public static void main(String[] args) {

        int v = 6;
        int e = 8;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] pred = new int[v+1];
        int[] dist = new int[v+1];

        boolean isReached = bfs(adj,1,6,v,pred,dist);
    }

    private static boolean bfs(ArrayList<ArrayList<Integer>> adj , int source, int destination, int v,
                               int[] pred, int[] dist){
        boolean visited[] = new boolean[v+1];
        for (int i = 0 ; i < v+1 ; i++){
            visited[i] = false;
            dist[i] = Integer.MAX_VALUE;
            pred[i] = -1;
        }
        LinkedList<Integer> queue = new LinkedList();
        queue.add(source);
        while (!queue.isEmpty()){
            int curr = queue.poll();
            ArrayList<Integer> list = adj.get(curr);
            for (int i = 0 ; i < list.size() ; i++){
                int neighbour = list.get(i);
                if(visited[neighbour] == false){
                    visited[neighbour] = true;
                    dist[neighbour] = dist[curr] + 1;
                    pred[neighbour] = curr;
                    queue.add(neighbour);

                    if(neighbour == destination){
                        return true;
                    }
                }
            }
        }
        return false;
    }


}
