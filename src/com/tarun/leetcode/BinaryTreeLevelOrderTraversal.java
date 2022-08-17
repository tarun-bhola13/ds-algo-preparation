package com.tarun.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    // #leetcode - 102

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.right = new TreeNode(20);
        root.left = new TreeNode(9);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(15);

        List<List<Integer>> traversal = levelOrder(root);
        traversal.stream().forEach(System.out::println);

    }

    private static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> traversalList = new ArrayList<>();
        if (root == null){
            return traversalList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        List<Integer> levelList = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node == null){
                if(queue.isEmpty()){
                    traversalList.add(levelList);
                    return traversalList;
                }
                queue.add(null);
                traversalList.add(levelList);
                levelList = new ArrayList<>();
                continue;
            }
            levelList.add(node.val);
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
        return traversalList;
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
