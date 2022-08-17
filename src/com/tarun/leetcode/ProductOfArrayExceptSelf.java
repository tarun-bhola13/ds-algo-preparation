package com.tarun.leetcode;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] nums = {-1, 1, 0, -3,3};
        int[] output = productExceptSelf(nums);
        for (int num : output){
            System.out.print(num + " ,");
        }
    }

    private static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] output = new int[length];
        output[0] = nums[0];
        for (int i = 1; i < length; i++) {
            output[i] = output[i - 1] * nums[i];
        }
        int rightProduct = 1;
        for (int i = length - 1; i >= 0; i--) {
            if (i - 1 >= 0) {
                output[i] = output[i - 1] * rightProduct;
                rightProduct = nums[i] * rightProduct;
            } else {
                output[i] = rightProduct;
            }
        }
        return output;

    }
}
