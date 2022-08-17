package com.tarun.leetcode;

import java.util.Stack;

public class ShortestUnsortedContinuousSubarray {
// #leetcode - 581
    public static void main(String[] args) {
        int[] nums = /*{2,6,4,8,10,9,15};*/{1,3,2,2,2};

//        int result = findUnsortedSubarray(nums);
        int result = findUnsortedSubarrayOptimized(nums);

        System.out.println(result);
    }

    static int findUnsortedSubarrayOptimized(int[] nums){

        int n = nums.length;
        int lowIndex = n;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < n ;){
            if(stack.isEmpty()){
                stack.push(i);
                i++;
            }else{
                if(nums[stack.peek()] > nums[i]) {
                        lowIndex = Math.min(lowIndex, stack.peek());
                        stack.pop();
                    }else{
                    stack.push(i);
                    i++;
                }
            }
        }
        stack.clear();
        int highIndex = 0;
        for(int i = n -1 ;i>=0 ;i--){
            if(stack.isEmpty()){
                stack.push(i);
                i--;
            }else{
                if(nums[stack.peek()] < nums[i]) {
                        lowIndex = Math.max(highIndex, stack.peek());

                }else{
                    stack.push(i);
                    i--;
                }
            }
        }

        return lowIndex>=highIndex ? 0:highIndex-lowIndex+1;

    }

    static class Pair{
        int value;
        int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
    static int findUnsortedSubarray(int[] nums) {
        int min = 0;
        int max = nums.length - 1;
        int count = 0;
        while (min < max) {
            count = findMinMax(nums, min, max);
            if(count == 0){
                min++;max--;
            }else if(count == 1){
                max--;
            }else if(count == 2){
                min++;
            }else {
                break;
            }
        }
        return min == max ? 0 : max - min + 1;
    }

    private static int findMinMax(int[] nums, int min, int max) {
        int maxValue = nums[max];
        int minValue = nums[min];
        int count = 0;// 1- min,2-max, 3-both
        for (int i = min; i <= max; i++) {
            if (maxValue < nums[i]) {
                if (count == 1) {
                    return 3;
                } else {
                    count = 2;
                }
            }
            if (minValue > nums[i]) {
                if (count == 2) {
                    return 3;
                } else {
                    count = 1;
                }
            }
        }
        return count;
    }
}

