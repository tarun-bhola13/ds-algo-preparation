package com.tarun.general.basic;

public class BurnBinaryTreeStartingFromLeafNode {

    public static void main(String[] args) {
        Node root;  // Inorder traversal (2,1,3,4,6,5,7)
        root = new Node(5);
        root.left = new Node(1);
        root.right = new Node(7);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.left.right.left = new Node(3);
        root.left.right.right = new Node(6);
        Depth depth = new Depth(-1);
        int element = 2;
        minTimeToBurnBinaryTree(root, depth, element);

        System.out.println(ans);
    }

    static int ans = 0;

    private static int minTimeToBurnBinaryTree(Node root, Depth depth, int element) {
        if (root == null) return 0;
        if (root.data == element) {
            depth.d = 1;
            return 1;
        }

        Depth ld = new Depth(-1);
        Depth rd = new Depth(-1);
        int rh = minTimeToBurnBinaryTree(root.right, rd, element);
        int lh = minTimeToBurnBinaryTree(root.left, ld, element);

        if (ld.d != -1) {
            ans = Math.max(ans, ld.d + 1 + rh);
            ld.d = ld.d + 1;
        } else if (rd.d != -1) {
            ans = Math.max(ans, rd.d + 1 + lh);
            rd.d = rd.d + 1;
        }
        return Math.max(lh, rh) + 1;
    }

    private static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    private static class Depth {
        int d;

        public Depth(int d) {
            this.d = d;
        }
    }
}
