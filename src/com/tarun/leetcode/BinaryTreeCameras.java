package com.tarun.leetcode;

public class BinaryTreeCameras {
    // #leetcode - 968

    private static int count;

    public static void main(String[] args) {
        TreeNode node = new TreeNode(0,new TreeNode(0,new TreeNode(0),new TreeNode(0)),null);

        System.out.println(minCameraCover(node));
    }

    private static int minCameraCover(TreeNode root) {
        count = calculateCount(root) == 0 ? count + 1 : count;
        return count;
    }
    private static int calculateCount(TreeNode node) {
        if(node == null){
             return -1;
        }
        if(node.left == null && node.right== null){
            return 0;
        }
        int lCount = calculateCount(node.left);
        int rCount = calculateCount(node.right);

        if(lCount == 0 || rCount == 0){
            count++;
            return 1;
        }
        if(lCount == 1 || rCount == 1){
            return 1;
        }
        return 0;
    }


    private static  class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }
}
