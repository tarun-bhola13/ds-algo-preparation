package com.tarun.general.basic;

public class DisjointSetUnionFind {
// make friends and are friends union find
static int numOfPeople = 8;
static int[] parent = new int[numOfPeople];
static int[] rank = new int[numOfPeople];
    public static void main(String[] args) {

        for(int i = 0 ; i < numOfPeople ; i++){
            parent[i] = i;
        }
        union(0,1);
        union(1,2);
    }

    private static int find(int i) {
        if(parent[i] != i){
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    private static void union(int a, int b) {
        int x = find(a);
        int y = find(b);
        if(x == y){
            return;
        }

        if(rank[x] > rank[y]){
            parent[y] = x;
        } else if (rank[y] > rank[x]) {
            parent[x] = y;
        }else{
            parent[y] = x;
            rank[x] = rank[x]+1;
        }
    }


}
