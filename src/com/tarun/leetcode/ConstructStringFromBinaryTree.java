package com.tarun.leetcode;

public class ConstructStringFromBinaryTree {
    // #leetcode - 606
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, null,new TreeNode(4)), new TreeNode(3));
        System.out.println(tree2str(root));
    }

    private static String tree2str(TreeNode root) {
        if (root == null) {
            return null;
        }
        String s = "" + root.val;
        String left = tree2str(root.left);
        String right = tree2str(root.right);
        if (left == null && right != null) {
            return s + "()" + "(" + right + ")";
        } else if (left != null && right == null) {
            return s + "(" + left + ")";
        } else if (left != null && right != null) {
            return s + "(" + left + ")" + "(" + right + ")";
        }
        return s;
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
