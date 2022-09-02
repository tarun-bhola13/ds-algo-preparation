package com.tarun.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {
    // #leetcode - 637
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        List<Double> averageList = averageOfLevels(root);
        System.out.println(averageList);
    }

    private static List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> averageList = new ArrayList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()){
            double sum = 0.0;
            int size = 0;
            while (queue.peek() != null){
                TreeNode node = queue.poll();
                sum += node.val;
                size++;
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            averageList.add(sum/size);
            queue.poll();
            if(queue.size() > 0) {
                queue.add(null);
            }
        }
    return averageList;
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
