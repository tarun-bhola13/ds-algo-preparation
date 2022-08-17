package com.tarun.leetcode;

import java.util.Stack;

public class OneThreeTwoPattern {
// #leetcode -
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};

        boolean result = find132Pattern(nums);

        System.out.println(result);
    }

    private static boolean find132Pattern(int[] nums) {
        int length = nums.length;
        if(length < 3){
            return false;
        }
        for(int i = 0 ; i < length-2 ;i++){
            for(int j = i+1; j < length-1 ;j++){
                for(int k = j+1; k < length ;k++){
                    if(nums[i] < nums[k] && nums[k] < nums[j]){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean find132PatternOptimized(int[] nums){

        int secondMax = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for(int i = nums.length-1 ; i >= 0 ; i--){
            if(nums[i] < secondMax){
                return true;
            }
            while (!stack.isEmpty() && stack.peek()< nums[i]){
                secondMax = Math.max(secondMax,stack.pop());
            }
            stack.push(nums[i]);
        }

        return false;
    }
}
