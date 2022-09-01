package com.tarun.leetcode;

public class CountGoodNodesInBinaryTree {
    // #leetcode - 1448
    private static int count = 0;

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1, new TreeNode(3), null);
        root.right = new TreeNode(4, new TreeNode(1), new TreeNode(5));
        System.out.println(goodNodes(root));

    }

    private static int goodNodes(TreeNode root) {

        if (root == null) {
            return 1;
        }
        count++;
        return findGoodNodes(root, root.val);
    }

    private static int findGoodNodes(TreeNode root, int currentMax) {
        if (root.left != null) {
            if (root.left.val >= currentMax) {
                count++;
            }
            findGoodNodes(root.left, Math.max(currentMax, root.left.val));
        }
        if (root.right != null) {
            if (root.right.val >= currentMax) {
                count++;
            }
            findGoodNodes(root.right, Math.max(currentMax, root.right.val));
        }

        return count;
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
