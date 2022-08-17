package com.tarun.general.basic;

public class FloorAndCeilValueInBST {

    public static void main(String[] args) {

        Node root;  // Inorder traversal (1,2,3,4,5,6,7)
        root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(7);
        root.left.left = new Node(2);
        root.left.left.right = new Node(3);
        root.right.left = new Node(6);
        root.left.left.left = new Node(1);

        System.out.println(findFloor(root, 5));
        System.out.println(findCeil(root,1));
    }

    private static int findFloor(Node root, int element) {
        if (root == null) return Integer.MIN_VALUE;
        int floor = Integer.MIN_VALUE;
        while (root != null) {
            if (root.data < element) {
                floor = Math.max(floor, root.data);
                root = root.right;
            }
            if (root != null && root.data >= element) {
                root = root.left;
            }
        }

        return floor;
    }

    private static int findCeil(Node root, int element){

        if (root == null) return Integer.MAX_VALUE;
        int ceil = Integer.MAX_VALUE;
        while (root != null) {
            if (root.data > element) {
                ceil = Math.min(ceil, root.data);
                root = root.left;
            }
            if (root != null && root.data < element) {
                root = root.right;
            }
            if(root != null && root.data == element){
                root = root.right;
            }
        }

        return ceil;
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
