package com.tarun.general;

import java.util.ArrayList;

public class Graphs {

    public static void main(String[] args) {

        int v = 5; // vertexes
        int e = 10; // edges
        int a[][] = new int[v+1][v+1];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    }

    // Adjacency matrix representation
    static void addEdge(int[][] a,int source, int destination){
        a[source][destination] = 1;
        a[destination][source] = 1;
    }
    // Adjacency List representation
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int source, int destination){
        adj.get(source).add(destination);
        adj.get(destination).add(source);
    }
}
