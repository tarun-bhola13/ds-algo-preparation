package com.tarun.leetcode;

public class SortArrayByParity {
    // #leetcode - 905

    public static void main(String[] args) {

        int[] nums = {0,2};

//        sortByParity(nums);
        sortArrayByParityOptimized(nums);
        for(int num : nums){
            System.out.println(num + " ");
        }

    }

    private static void sortByParity(int[] nums) {
        int even = 0; int odd = nums.length-1;
        while (even < odd){

            while(even < odd && nums[odd] % 2 != 0){
               odd--;
            }
            while(even < odd && nums[even] %2 == 0){
                even++;
            }
            if(even < odd){
                swap(even,odd,nums);
            }
        }
    }

    private static void swap(int even, int odd, int[] nums) {
        int temp = nums[odd];
        nums[odd] = nums[even];
        nums[even] = temp;
    }

    private static void sortArrayByParityOptimized(int[] nums){
        int start = 0;
        int end = nums.length-1;
        int[] sortedArray = new int[nums.length];

        for(int element : nums){
            if(element %2 == 0){
                sortedArray[start] = element;
                start++;
            }else{
                sortedArray[end] = element;
                end--;
            }
        }
    }

}
