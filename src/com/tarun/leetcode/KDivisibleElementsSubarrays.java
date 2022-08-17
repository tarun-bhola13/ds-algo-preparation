package com.tarun.leetcode;

import java.util.HashSet;
import java.util.Set;

public class KDivisibleElementsSubarrays {
// #leetcode 2261
    public static void main(String[] args) {
        int[] nums = {2,3,3,2,2};
        int k = 2 , p = 2;
        System.out.println(countSubarraysWithAtmostKElementsDivisibleByP(nums,k,p));
    }

    private static int countSubarraysWithAtmostKElementsDivisibleByP(int[] nums, int k, int p) {
        Set<String> set = new HashSet<>();
        for(int i = 0 ; i < nums.length ;i++){
            int count = 0;
            StringBuilder sb = new StringBuilder();
            for(int j = i ; j < nums.length ;j++){
                if(nums[j] %2 == 0){
                    count++;
                }
                if(count > k){
                    break;
                }
                sb.append(nums[j] +"_");
                set.add(sb.toString());
            }
        }

        return set.size();
    }
}
