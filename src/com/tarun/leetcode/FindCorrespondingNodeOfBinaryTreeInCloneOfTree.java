package com.tarun.leetcode;

public class FindCorrespondingNodeOfBinaryTreeInCloneOfTree {

    public static void main(String[] args) {

        TreeNode node = new TreeNode(7);
        node.left = new TreeNode(4);
        node.right = new TreeNode(3);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(19);
        TreeNode clone = new TreeNode(7);
        clone.left = new TreeNode(4);
        clone.right = new TreeNode(3);
        clone.right.left = new TreeNode(6);
        clone.right.right = new TreeNode(19);
        TreeNode target = new TreeNode(3);

        TreeNode result = getTargetCopy(node,clone,node.right);
        System.out.println(result.val);
    }

    private static TreeNode getTargetCopy(TreeNode node, TreeNode clone, TreeNode target) {

        if(clone == null){
            return null;
        }
        if(node == target){
            return clone;
        }
        TreeNode left = getTargetCopy(node.left,clone.left,target);
        if(left != null){
            return left;
        }
        TreeNode right = getTargetCopy(node.right,clone.right,target);
        if(right != null){
            return right;
        }
        return null;

    }


    public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
}
