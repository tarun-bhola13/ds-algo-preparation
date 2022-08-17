package com.tarun.general.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ShortestPathDijkstraAlgo {
    //Dijkstra's Algorithm

    public static void main(String[] args) {

        List<List<List<Integer>>> adj = new ArrayList<>();
        adj.add(List.of(List.of(1,2), List.of(3,7),List.of(4,6)));
        adj.add(List.of(List.of(0,2),List.of(2,1),List.of(4,4)));
        adj.add(List.of(List.of(3,3),List.of( 4,2)));
        adj.add(List.of(List.of(2,3), List.of(0,7),List.of(4,5)));
        adj.add(List.of(List.of(1,4),List.of(3,5),List.of(0,6),List.of(2,2)));
        int V = 5;
        int[] shortestPath = new int[V];
        boolean[] visited = new boolean[V];
        Arrays.fill(shortestPath,Integer.MAX_VALUE);
        shortestPathFromGivenVertex(shortestPath,adj,0,visited);
        IntStream.of(shortestPath).forEach(System.out::println);
    }

    private static void shortestPathFromGivenVertex(int[] shortestPath, List<List<List<Integer>>> adj, int v, boolean[] visited) {

        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(v,0));
        shortestPath[v] = 0;

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            if (!visited[p.v]) {
                List<List<Integer>> neighbours = adj.get(p.v);
                visited[p.v] = true;
                for (List<Integer> neighbour : neighbours) {
                    int wt = neighbour.get(1);
                    int vertex = neighbour.get(0);
                    if (shortestPath[vertex] > shortestPath[p.v] + wt) {
                        shortestPath[vertex] = shortestPath[p.v] + wt;
                        queue.add(new Pair(vertex, shortestPath[vertex]));
                    }
                }
            }
        }
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
