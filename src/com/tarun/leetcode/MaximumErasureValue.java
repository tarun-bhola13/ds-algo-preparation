package com.tarun.leetcode;

import java.util.HashSet;
import java.util.Set;

public class MaximumErasureValue {
// #leetcode - 1695
    public static void main(String[] args) {
        int[] nums = {5,2,1,2,5,2,1,2,5};
        System.out.println(maximumUniqueSubarray(nums));
    }

    private static int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int setSum = 0;
        int maxSum = 0;
        int j = 0;
        for(int i = 0 ; i < nums.length ;i++){
            while(set.contains(nums[i])){
                set.remove(nums[j]);
                setSum -= nums[j];
                j++;
            }
            set.add(nums[i]);
            setSum += nums[i];
            maxSum = Math.max(maxSum,setSum);
        }

        return maxSum;
    }


}
