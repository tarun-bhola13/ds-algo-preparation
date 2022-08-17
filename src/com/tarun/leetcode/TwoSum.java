package com.tarun.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    // #leetcode 1
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] ans = twoSum(nums,target);
    }

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] ans = new int[2];

        for(int i = 0; i < nums.length ; i++){
            int remainingSum = target-nums[i];
            if(map.containsKey(remainingSum)){
                ans[0] = i;
                ans[1] = map.get(remainingSum);
            }else{
                map.put(nums[i],i);
            }
        }
        return ans;
    }
}
