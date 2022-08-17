package com.tarun.leetcode;

import java.util.*;


public class PermutationsII {
    // #leetcode - 47
    public static void main(String[] args) {
    int[] nums = {1,2,3};
        List<List<Integer>> output = permuteUnique(nums);
        System.out.println(output);
    }

    private static List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        Integer[] numsArray = new Integer[nums.length];
        for(int i = 0 ; i < numsArray.length;i++){
            numsArray[i] = nums[i];
        }
        permuteHelper(numsArray,ans,0);
        return new ArrayList<>(ans);
    }

    private static void permuteHelper(Integer[] nums, Set<List<Integer>> ans, int index) {
        if(index == nums.length){
            ans.add(List.of(nums));
            return;
        }

        for(int i = index ;i<nums.length ;i++){
            swap(nums,index,i);
            permuteHelper(nums,ans,index + 1);
            swap(nums,index,i);
        }

    }

    private static void swap(Integer[] nums, int index, int i) {
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }

}
