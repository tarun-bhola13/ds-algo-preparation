package com.tarun.general.basic;

public class DiameterOfBinaryTree {
    static int ans = 0;
    public static void main(String[] args) {

        Node root;  // Inorder traversal (2,1,3,4,6,5,7)
        root = new Node(5);
        root.left = new Node(1);
        root.right = new Node(7);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.left.right.left = new Node(3);
        root.left.right.right = new Node(6);
        System.out.println(diameterOfBinaryTree(root));
    }

    // O(N2)
    private static int diameterOfBinaryTree(Node root){
       if(root == null) return 0;

       int dl =  diameterOfBinaryTree(root.left);
       int dr = diameterOfBinaryTree(root.right);
      int height = height(root.left) + height(root.right) + 1;

//      return height;
       return Math.max(height, Math.max(dl,dr));
    }

    private static int height(Node node) {
        if(node == null) return 0;
        return 1 + Math.max(height(node.left) , height(node.right));
    }

    // O(N)
    private static int diameterOfBinaryTreeOptimized(Node root){
        if(root == null) return 0;
        int ld = diameterOfBinaryTreeOptimized(root.left);
        int rd = diameterOfBinaryTreeOptimized(root.right);
        ans = Math.max(ans,1 + rd+ld);
        return 1 + Math.max(ld, rd); 
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
