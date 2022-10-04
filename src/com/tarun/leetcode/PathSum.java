package com.tarun.leetcode;

public class PathSum {
    // #leetcode-112
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null), new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1))));
        int targetSum = 22;
        System.out.println(hasPathSum(root, targetSum));
    }

    private static boolean hasPathSum(TreeNode root, int targetSum) {
        return iterateTreeForPathSum(root, targetSum, 0);
    }

    private static boolean iterateTreeForPathSum(TreeNode root, int targetSum, int currentSum) {

        if (root == null) return false;

        currentSum += root.val;
        if (currentSum == targetSum && (root.left == null && root.right == null)) {
            return true;
        }
        return iterateTreeForPathSum(root.left, targetSum, currentSum) ||
                iterateTreeForPathSum(root.right, targetSum, currentSum);
    }

    private static class TreeNode {
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
