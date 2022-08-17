package com.tarun.general.basic;

import java.util.Scanner;

public class FlattenBinaryTreeToDoublyLinkedList {
    static Scanner sc = null;
    static Node head = null; static Node previous = null;
    public static void main(String[] args) {

        sc = new Scanner(System.in);
        Node root;  // Inorder traversal (2,1,3,4,6,5,7)
        root = new Node(5);
        root.left = new Node(1);
        root.right = new Node(7);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.left.right.left = new Node(3);
        root.left.right.right = new Node(6);
        Node head = flattenTreeToLinkedList(root);
        while (head != null){
            System.out.print(head.data+" ");
            head = head.right;
        }

    }

    private static Node flattenTreeToLinkedList(Node root){

       if(root == null){
           return null;
       }
       flattenTreeToLinkedList(root.left);
       if(previous == null) head = root;
       else{
           root.left = previous;
           previous.right = root;
       }
       previous = root;
        flattenTreeToLinkedList(root.right);

        return head;
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
