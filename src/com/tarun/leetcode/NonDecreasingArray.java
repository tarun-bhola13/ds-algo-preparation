package com.tarun.leetcode;

public class NonDecreasingArray {
    // #leetcode - 665
    public static void main(String[] args) {
        int[] nums = {3,4,2,3};
        System.out.println(checkPossibility(nums));
    }

    private static boolean checkPossibility(int[] nums) {
        int count = 0;
        for(int i = 1 ; i < nums.length ; i++){

            if(nums[i] < nums[i-1]){
                count++;
                if(i >= 2 && nums[i-2] > nums[i]){
                    nums[i] = nums[i-1];
                }else{
                    nums[i-1] = nums[i];
                }
            }
        }
        return count <= 1;
    }
}
