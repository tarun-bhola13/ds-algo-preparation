package com.tarun.leetcode;

import java.util.TreeSet;

public class LongestIncreasingSubsequence {
    // #leetcode - 300
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,118};
        System.out.println(lengthOfLIS(nums));
    }

    private static int lengthOfLIS(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();

        for(int num : nums){
            Integer higherOfEqual = set.ceiling(num);
            if(higherOfEqual == null){
                set.add(num);
            }else{
                set.remove(higherOfEqual);
                set.add(num);
            }
        }

        return set.size();
    }
}
