package com.tarun.leetcode;

public class ConvertSortedArrayToBST {

    // #leetcode - 108
    public static void main(String[] args) {

        int[] nums = {-10,-3,0,5,9};
        TreeNode node = sortedArrayToBST(nums);


    }

    private static TreeNode sortedArrayToBST(int[] nums) {
        int length = nums.length;
        if(length == 1){
            return new TreeNode(nums[0]);
        }

        return generateBST(nums,0,length-1);
    }

    private static TreeNode generateBST(int[] nums, int startIndex, int endIndex) {
        if(startIndex > endIndex){
            return null;
        }
        if(startIndex == endIndex){
            return new TreeNode(nums[startIndex]);
        }

        int mid = (endIndex + startIndex)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.right = generateBST(nums,startIndex,mid-1);
        root.left = generateBST(nums,mid+1,endIndex);

        return root;
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
