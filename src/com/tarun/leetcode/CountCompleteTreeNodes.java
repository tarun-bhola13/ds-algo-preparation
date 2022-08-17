package com.tarun.leetcode;


public class CountCompleteTreeNodes {
// leetcode 222
    public static void main(String[] args) {
        TreeNode node = new TreeNode(10,
                new TreeNode(8,new TreeNode(4,new TreeNode(3),new TreeNode(5)),
                        new TreeNode(9)),new TreeNode(12,new TreeNode(11),new TreeNode(13))
                );

        int count = countNumberOfNodes(node);
        count = countNumberOfNodesOptimized(node);

        System.out.println(count);
    }

    private static int countNumberOfNodes(TreeNode node) {

        if (node == null){
            return 0;
        }
        return 1 + countNumberOfNodes(node.left) + countNumberOfNodes(node.right);
    }

    private static int countNumberOfNodesOptimized(TreeNode node){
        if (node == null){
            return 0;
        }
        int height = 1;
        TreeNode left = node.left; TreeNode right = node.right;
         while (left != null && right != null){
             left = left.left;
             right = right.right;
             height++;
         }

         return right== null & left==null?
                 (int)Math.pow(2,height) - 1 :
                 1 + countNumberOfNodesOptimized(node.left) + countNumberOfNodesOptimized(node.right);
    }

    private static class TreeNode{
        int data;
        TreeNode right;
        TreeNode left;
        TreeNode(int data){
            this.data = data;
        }
        TreeNode(int data, TreeNode left , TreeNode right){
            this.data = data;
            this.right = right;
            this.left = left;
        }

    }
}
