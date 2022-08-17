package com.tarun.leetcode;

public class RunningSumOf1dArray {

    public static void main(String[] args) {
        int[] nums = {3,1,2,10,1};

        int output[] = runningSum(nums);
        for(int num : output){
            System.out.println(num+ ",");
        }
    }

    private static int[] runningSum(int[] nums) {

        int[] output = new int[nums.length];
        int sum = 0;
        for(int i = 0 ; i < nums.length ; i++){
            sum = sum + nums[i];
            output[i] = sum;
        }
        return output;
    }
}
