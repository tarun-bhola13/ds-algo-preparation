package com.tarun.leetcode;

public class ValidateBinarySearchTree {

    // #leetcode - 98
    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(3);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);
        System.out.println(isValidBST(root));
    }

    private static boolean isValidBST(TreeNode root) {

        if(root == null){
            return true;
        }
        return helper(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private static boolean helper(TreeNode root, long minValue, long maxValue) {

            if(root == null){
                return true;
            }
            int val = root.val;
            if(val >= maxValue || val<= minValue){
                return false;
            }
            return helper(root.left,minValue,val) && helper(root.right,val,maxValue);
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
