package com.tarun.leetcode;

import java.util.*;

public class NetworkDelayTime {
    // #leetcode - 743
    public static void main(String[] args) {

        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4, k = 2;
        int result = networkDelayTime(times, n, k);
        System.out.println(result);

    }

    private static int networkDelayTime(int[][] times, int n, int k) {

        PriorityQueue<Node> pq = new PriorityQueue<Node>((node1,node2)-> node1.distance-node2.distance);
        Map<Integer, Set<Node>> map = buildGraph(times);
        Set<Integer> visited = new HashSet<>();
        pq.offer(new Node(k,0));
        int totalTime = 0;

        while (!pq.isEmpty()){
            Node head = pq.poll();
            if(visited.contains(head.target)){
               continue;
            }
            visited.add(head.target);
            totalTime = Math.max(totalTime, head.distance);
            if(visited.size() == n){
                return totalTime;
            }

            if(map.containsKey(head.target)){
                for(Node children : map.get(head.target)){
                    pq.offer(new Node(children.target, children.distance+ head.distance));
                }
            }

        }
        return -1;
    }

    private static Map<Integer, Set<Node>> buildGraph(int[][] times) {

        Map<Integer,Set<Node>> map = new HashMap<>();
        for(int[] item : times){
            map.putIfAbsent(item[0],new HashSet<>());
            map.get(item[0]).add(new Node(item[1],item[2]));
        }
        return map;
    }

    private static class Node {
        public int target;
        public int distance;

        public Node(int target, int distance) {
            this.target = target;
            this.distance = distance;
        }
    }
}
