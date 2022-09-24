package com.tarun.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    // #leetcode - 113
    private static List<List<Integer>> pathSumList = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null), new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1))));
        int targetSum = 22;
        System.out.println(pathSum(root, targetSum));
    }

    private static List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return pathSumList;
        }
        iterateTree(root, 0, targetSum, new ArrayList<>());

        return pathSumList;
    }

    private static void iterateTree(TreeNode root, int currentSum, int targetSum, ArrayList<Integer> pathList) {
        if (root == null) return;

        int sum = currentSum + root.val;

        if (sum == targetSum && root.left == null && root.right == null) {
            pathList.add(root.val);
            pathSumList.add(pathList);
            return;
        }
        pathList.add(root.val);
        iterateTree(root.left, sum, targetSum, new ArrayList<>(pathList));
        iterateTree(root.right, sum, targetSum, new ArrayList<>(pathList));

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
