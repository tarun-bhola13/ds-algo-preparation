package com.tarun.leetcode;

public class MissingNumber {
    //#leetcode - 268
    public static void main(String[] args) {

        int[] nums = {1};
        System.out.println(missingNumber(nums));

    }

    private static int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = (n*(n+1))/2;

        for(int i = 0 ; i < n ;i++){
            sum = sum - nums[i];
        }
        return sum;
    }
}
