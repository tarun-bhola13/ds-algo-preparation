package com.tarun.general.basic;

public class CheckGivenTreeBST {
    private static int prev = 0;
    public static void main(String[] args) {
        Node root;  // Inorder traversal (2,1,3,4,6,5,7)
        root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(7);
        root.left.left = new Node(2);
        root.left.left.right = new Node(3);
        root.right.left = new Node(6);
        root.left.left.left = new Node(1);
        System.out.println(isBST(root));
    }

    private static boolean isBST(Node root) {
//        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return isBSTUtilPrevValueTracking(root);
    }

    /**
     * Checking BST with range
     * @param root - root
     * @param minValue - min Value
     * @param maxValue - max Value
     * @return - Boolean
     */
    private static boolean isBSTUtil(Node root, int minValue, int maxValue) {
        if(root == null) return true;
        if(root.data < minValue || root.data > maxValue) return false;

        return isBSTUtil(root.left,minValue, root.data-1)
                && isBSTUtil(root.right, root.data+1, maxValue);
    }

    private static boolean isBSTUtilPrevValueTracking(Node root){

        if(root == null) return true;
        if(root.left != null){
            isBSTUtilPrevValueTracking(root.left);
        }
        if(prev > root.data) return false;
        prev = root.data;
        if(root.right != null){
            isBSTUtilPrevValueTracking(root.right);
        }
        return true;
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
