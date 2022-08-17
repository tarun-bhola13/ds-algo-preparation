package com.tarun.leetcode;

public class DeepestLeavesSum {
    // #leetcode - 1302
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);
        int sum = deepestLeavesSum(root);
        System.out.println(sum);

    }

    private static int deepestLeavesSum(TreeNode root) {
        int heightOfTree = findHeight(root);
        return calculateDeepestSum(root,heightOfTree);
    }

    private static int calculateDeepestSum(TreeNode root, int currentHeight) {
        if(root == null){
            return 0;
        }
        if(currentHeight == 1){
            return root.val;
        }

        return calculateDeepestSum(root.left,currentHeight -1) + calculateDeepestSum(root.right,currentHeight-1);
    }

    private static int findHeight(TreeNode root) {
        if(root == null){
            return 0;
        }
        return 1 + Math.max(findHeight(root.left),findHeight(root.right));
    }


    public static class TreeNode {
        int val;
        DeepestLeavesSum.TreeNode left;
        DeepestLeavesSum.TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, DeepestLeavesSum.TreeNode left, DeepestLeavesSum.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
