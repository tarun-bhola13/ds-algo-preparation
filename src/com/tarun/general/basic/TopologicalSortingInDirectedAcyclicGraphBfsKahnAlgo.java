package com.tarun.general.basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSortingInDirectedAcyclicGraphBfsKahnAlgo {

    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        adj.add(List.of(0, 2, 3));
        adj.add(List.of(1, 4));
        adj.add(List.of(2, 3, 1));
        adj.add(List.of(3, 1));
        adj.add(List.of(4));
        adj.add(List.of(5, 1, 4));
        int V = 6;
        int[] inDegree = new int[V];
        for (int i = 0; i < adj.size(); i++) {
            for (int j = 1; j < adj.get(i).size(); j++) {
                int k = adj.get(i).get(j);
                inDegree[k]++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        topoSort(adj, inDegree, ans);
        ans.forEach(System.out::println);
    }

    private static void topoSort(List<List<Integer>> adj, int[] inDegree, List<Integer> ans) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int element = queue.poll();
            ans.add(element);
            List<Integer> neighbours = adj.get(element);
            for (int i = 1; i < neighbours.size(); i++) {
                int neighbour = neighbours.get(i);
                if (--inDegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }

    }
}
