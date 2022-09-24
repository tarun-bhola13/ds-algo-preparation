package com.tarun.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    // #leetcode - 94
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null,new TreeNode(2, new TreeNode(3),null));
        System.out.println(inorderTraversal(root));
    }

    private static List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        prepareInOrderTraversal(root,list);
        return list;

    }

    private static void prepareInOrderTraversal(TreeNode root, List<Integer> list) {
        prepareInOrderTraversal(root.left,list);
        list.add(root.val);
        prepareInOrderTraversal(root.right,list);
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
