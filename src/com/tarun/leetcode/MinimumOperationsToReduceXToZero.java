package com.tarun.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumOperationsToReduceXToZero {
// #leecode - 1658
    public static void main(String[] args) {
        int[] nums = {1,2};
        int x = 1;
        System.out.println(minOperations(nums,x));
    }

    private static int minOperations(int[] nums, int x) {
        int sum = 0;
        Map<Integer,Integer> map = new HashMap();
        for(int i = 0 ; i < nums.length ; i++){
            sum += nums[i];
            map.put(sum,i);
        }
        if(x > sum){
            return -1;
        }
        int findSum = sum - x;
        map.put(0,0);
        int val = 0;
        int count = 0;
        for(int i = 0  ; i < nums.length ; i++){
            val += nums[i];
            if(map.containsKey(val - findSum)){
                if(findSum - val == 0){
                    count = Math.max(count,i - map.get(val - findSum) +1);
                }else {
                    count = Math.max(count, i - map.get(val - findSum));
                }
            }
        }

        return count == 0 ? findSum == 0 ? nums.length : -1 : nums.length - count;
    }
}
