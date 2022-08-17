package com.tarun.general.basic;

import java.util.Scanner;

public class BinaryTreeBasics {
    static Scanner sc = null;
    public static void main(String[] args) {

        sc = new Scanner(System.in);
        Node root = createTree();
        System.out.println(binaryTreeHeight(root));

        System.out.println(sizeOfBinaryTree(root));

        System.out.println(maximumInBinaryTree(root));

        System.out.println(minimumInBinaryTree(root));

    }

    static int maximumInBinaryTree(Node root){

        if (root == null){
            return Integer.MIN_VALUE;
        }

        return Math.max(root.data, Math.max(maximumInBinaryTree(root.left),maximumInBinaryTree(root.right)));
    }

    static int minimumInBinaryTree(Node root){

        if (root == null){
            return Integer.MAX_VALUE;
        }

        return Math.min(root.data, Math.min(maximumInBinaryTree(root.left),maximumInBinaryTree(root.right)));
    }


    static int binaryTreeHeight(Node root){

        if (root == null){
            return 0;
        }
        return Math.max(binaryTreeHeight(root.left),binaryTreeHeight(root.right)) + 1;
    }


    static int sizeOfBinaryTree(Node root){

        if (root == null){
            return 0;
        }

        return 1 + sizeOfBinaryTree(root.right) + sizeOfBinaryTree(root.left);
    }
    static Node createTree(){
        Node root = null;

        System.out.println("Enter data : ");
        int data = sc.nextInt();
        if (data == -1){
            return null;
        }
        root = new Node(data);

        System.out.println("Enter Left Node data for "+ data);
        root.left = createTree();

        System.out.println("Enter Right Node data for "+ data);
        root.right = createTree();

        return root;

    }


    static class Node {
        Node left, right;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }
}
