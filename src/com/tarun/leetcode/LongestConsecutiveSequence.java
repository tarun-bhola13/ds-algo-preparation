package com.tarun.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    // #leetcode - 128

    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(longestConsecutive(nums));
    }

    private static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }
        int maxCount = 0;
        for(int num : nums){
            int count = 1;
            int leftElement = num -1;
            int rightElement = num+1;
            for(int i = 0 ; i < nums.length ; i++){
                if(set.contains(rightElement)){
                    count++;
                    set.remove(rightElement);
                    rightElement++;
                }else{
                    break;
                }
            }
            for(int i = 0 ; i < nums.length ; i++){
                if(set.contains(leftElement)){
                    count++;
                    set.remove(leftElement);
                    leftElement--;
                }else{
                    break;
                }
            }

            maxCount = Math.max(maxCount,count);
        }

        return maxCount;
    }


}
