package com.tarun.general.basic;

import java.util.HashSet;
import java.util.Set;

public class PairWithGivenSumInBST {
    public static void main(String[] args) {
        Node root;  // Inorder traversal (1,2,3,4,5,6,7)
        root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(7);
        root.left.left = new Node(2);
        root.left.left.right = new Node(3);
        root.right.left = new Node(6);
        root.left.left.left = new Node(1);
        System.out.println(pairWithGivenSum(root,12));

    }

    private static boolean pairWithGivenSum(Node node, int sum) {
        Set<Integer> set = new HashSet<>();
//        return pairWithGivenSumUtil(node, sum, set);
        return pairWithGivenSumUtil(node,sum);
    }

    private static boolean pairWithGivenSumUtil(Node node, int sum, Set<Integer> set) {
        if (node == null) return false;
        if (pairWithGivenSumUtil(node.left, sum, set) == true)
            return true;
        if (set.contains(sum - node.data)) {
            return true;
        }
        set.add(node.data);
        return pairWithGivenSumUtil(node.right, sum, set);
    }

    private static boolean pairWithGivenSumUtil(Node node , int sum){
        if(node == null) return false;
        Set<Integer> set = new HashSet<>();
        while (node != null){
            if(node.data < sum){
                if(set.contains(sum- node.data)){
                    return true;
                }else{
                    set.add(node.data);
                    if(sum- node.data < node.data){
                        if(node.left != null){
                            node = node.left;
                        }
                    }else{
                            node = node.right;
                    }
                }
            }else {
                node = node.left;
            }
        }
        return false;
    }

    private static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
