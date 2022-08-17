package com.tarun.general.basic;

public class DeleteElementInBST {

    public static void main(String[] args) {
        Node root;  // Inorder traversal (2,1,3,4,6,5,7)
        root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(7);
        root.left.left = new Node(2);
        root.left.left.right = new Node(3);
        root.right.left = new Node(6);
        root.left.left.right = new Node(1);
        deleteFromBST(root, 2);
    }

    private static Node deleteFromBST(Node root, int element) {

        if(root == null) return root;
        if (root.data > element){
            root.left = deleteFromBST(root.left,element);
        }else if(root.data < element){
            root.right = deleteFromBST(root.right,element);
        }else{
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }else {
                root.data = getRightPredecessorValue(root.right);
                root.right = deleteFromBST(root.right,root.data);
            }
        }
        return root;
    }

    private static int getRightPredecessorValue(Node root) {
        int predeccessor = root.data;
        while (root.left != null){
           root = root.left;
           predeccessor = root.data;
        }
        return predeccessor;
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
