package com.tarun.leetcode;

public class HouseRobber {
    // #leetcode - 198
    public static void main(String[] args) {

        int[] nums = {1,2,3,1};
        int amount = rob(nums);
        System.out.println(amount);
    }

    private static int rob(int[] nums) {
        int length = nums.length;
        if(length == 1){
            return nums[0];
        }
        if(length == 2){
            return Math.max(nums[0],nums[1]);
        }
        int[] dp = new int[nums.length];
        int maxAmount = 0;
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = dp[0] + nums[2];
        maxAmount = Math.max(dp[0],Math.max(dp[1],dp[2]));
        for(int i = 3  ; i < length ; i++){
            dp[i] = Math.max(dp[i-2],dp[i-3]) + nums[i];
            maxAmount = Math.max(maxAmount,dp[i]);
        }
        return maxAmount;
    }


}
