package com.tarun.general.basic;

import com.tarun.general.LinkedList;

import java.util.*;

public class VerticalTraversalOfBinaryTree {

    public static void main(String[] args) {

        Node root;  // Inorder traversal (1,2,3,4,5,6,7)
        root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(7);
        root.left.left = new Node(2);
        root.left.left.right = new Node(3);
        root.right.left = new Node(6);
        root.left.left.left = new Node(1);
        printVerticalTraversal(root);
        ans.forEach(System.out::println );

    }
    private static List<Integer> ans = new ArrayList<>();
    private static void printVerticalTraversal(Node root) {
        Queue<Pair> queue = new ArrayDeque<>();
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        queue.add(new Pair(0,root));
        while (!queue.isEmpty()){
            Pair p = queue.poll();
            if(p.node!= null){
                if(map.containsKey(p.hd)){
                    map.get(p.hd).add(p.node.data);
                }else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(p.node.data);
                    map.put(p.hd,list);
                }
            }
            if(p.node.left != null){
                queue.add(new Pair(p.hd-1,p.node.left));
            }

            if(p.node.right != null){
                queue.add(new Pair(p.hd+1,p.node.right));
            }
        }

        for (Map.Entry<Integer,ArrayList<Integer>> entry : map.entrySet()){
            ans.addAll(entry.getValue());
        }
    }

    private static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    private static class Pair{
        int hd;
        Node node;

        public Pair(int hd, Node node) {
            this.hd = hd;
            this.node = node;
        }
    }
}
