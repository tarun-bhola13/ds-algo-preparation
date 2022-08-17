package com.tarun.general;

public class BinarySearchTree {
    public static void main(String[] args) {
        Node root;  // Inorder traversal (2,1,3,4,6,5,7)
        root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(7);
        root.left.left = new Node(2);
        root.left.left.right = new Node(3);
        root.right.left = new Node(6);
        root.left.left.right = new Node(1);

        System.out.println(search(root, 2));
    }

    private static boolean search(Node root, int element) {
        if (root == null) return false;
        if (root.data == element) return true;

        if (element > root.data) {
            return search(root.right, element);
        }

        return search(root.left, element);
    }

    private Node insert(Node root, int element) { // TC : O(log(n)) SC : O(log(n))
        if (root == null) {
            return new Node(element);
        }
        if (root.data > element) {
            root.left = insert(root.left, element);
        } else {
            root.right = insert(root.right, element);
        }

        return root;
    }

    private Node insertIteratively(Node root, int element) { // TC : O(log(n)) SC : O(1)
        if (root == null) return new Node(element);
        Node curr = root;
        Node parent = null;

        while (curr != null) {
            parent = curr;
            if (element > curr.data) {
                curr = curr.right;
            } else
                curr = curr.left;
        }

        if (parent.data > element) {
            parent.left = new Node(element);
        } else {
            parent.right = new Node(element);
        }

        return root;
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
