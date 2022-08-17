package com.tarun.general.basic;

public class LowestCommonAncestorInBinaryTree {

    public static void main(String[] args) {
        Node root;  // Inorder traversal (2,1,3,4,6,5,7)
        root = new Node(5);
        root.left = new Node(1);
        root.right = new Node(7);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.left.right.left = new Node(3);
        root.left.right.right = new Node(6);
        int a = 2; int b = 4;
        System.out.println(lowestCommonAncestor(root, a,b));
    }

    private static Integer lowestCommonAncestor(Node root, int a , int b) {
        if(root == null) return null;
        if(root.data == a || root.data == b) return root.data;

        Integer  left = lowestCommonAncestor(root.left,a,b);
        Integer right = lowestCommonAncestor(root.right,a,b);
        if(left == null) return right;
        if(right == null) return left;
        return root.data;
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
