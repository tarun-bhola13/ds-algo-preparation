package com.tarun.general.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumSpanningTreePrimAlgo {
//Prim's Algorithm
    public static void main(String[] args) {
        List<List<List<Integer>>> adj = new ArrayList<>();
        adj.add(List.of(List.of(1,2), List.of(3,7),List.of(4,6)));
        adj.add(List.of(List.of(0,2),List.of(2,1),List.of(4,4)));
        adj.add(List.of(List.of(3,3),List.of( 4,2)));
        adj.add(List.of(List.of(2,3), List.of(0,7),List.of(4,5)));
        adj.add(List.of(List.of(1,4),List.of(3,5),List.of(0,6),List.of(2,2)));
        int V = 5;
        boolean[] visited = new boolean[V];
        int minimumSpanning = minimumSpanningDistance(adj,visited);
        System.out.println(minimumSpanning);
    }

    private static int minimumSpanningDistance(List<List<List<Integer>>> adj, boolean[] visited) {

        int ans = 0;
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>();

        queue.add(new Pair(0,0));
        while (!queue.isEmpty()){
            Pair pair = queue.poll();
            if(!visited[pair.v]) {
                List<List<Integer>> neighbours = adj.get(pair.v);
                for (List<Integer> list : neighbours) {
                    queue.add(new Pair(list.get(0), list.get(1)));
                }
                visited[pair.v] = true;
                ans = ans + pair.wt;
            }
        }
        return ans;
    }

    private static class Pair implements Comparable<Pair>{
        int v;
        int wt;

        public Pair(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }

        @Override
        public int compareTo(Pair that) {
            return this.wt - that.wt;
        }
    }


}
