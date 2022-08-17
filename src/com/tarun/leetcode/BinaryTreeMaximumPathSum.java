package com.tarun.leetcode;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeMaximumPathSum {
    // #leetcode - 124
    static int maxPathSum = Integer.MIN_VALUE;
    public static void main(String[] args) {

        TreeNode root = new TreeNode(-10,new TreeNode(9),new TreeNode(20));
        root.right.left = new TreeNode(15,new TreeNode(9),new TreeNode(8));
        root.right.right = new TreeNode(7,new TreeNode(-2),new TreeNode(3));
        System.out.println(maxPathSum(root));
    }

    private static int maxPathSum(TreeNode root) {
        Map<TreeNode,Integer> map = new HashMap<>();
        dfs(root,map);
        return maxPathSum;
    }

    private static int dfs(TreeNode root, Map<TreeNode, Integer> map) {
        if(root == null){
            return 0;
        }
        int leftMaxSum = 0;
        int rightMaxSum = 0;
        if(root.left != null && map.containsKey(root.left)){
            leftMaxSum = map.get(root.left);
        }else {
            leftMaxSum = Math.max(0,dfs(root.left,map));
        }

        if(root.right != null && map.containsKey(root.right)){
            rightMaxSum = map.get(root.right);
        }else{
            rightMaxSum = Math.max(0,dfs(root.right,map));
        }

        maxPathSum = Math.max(maxPathSum,leftMaxSum + rightMaxSum + root.val);
        map.put(root,maxPathSum);

        return Math.max(leftMaxSum,rightMaxSum) + root.val;
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
