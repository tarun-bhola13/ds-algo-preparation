package com.tarun.leetcode;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SubsequenceOfLengthK {

    public static void main(String[] args) {

        int[] nums = {-1,-2,3,4};
        int k = 3;

        int[] output = findSubsequenceOfLengthK(nums,k);

        for (int i : output){
            System.out.print(i+ " ");
        }

    }

    private static int[] findSubsequenceOfLengthK(int[] nums, int k) {

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[] output = new int[k];

        for (int i = 0 ; i < nums.length ; i++){
            queue.add(new int[]{nums[i],i});
            if (queue.size() > k){
                queue.poll();
            }
        }

        Set<Integer> set = new HashSet<>();
        while (!queue.isEmpty()){
            int[] top = queue.poll();
            set.add(top[1]);
        }
        int p = 0;
        for (int i = 0 ; i < nums.length ; i++){
            if (set.contains(i)) {
                output[p++] = nums[i];
            }
        }
        return output;
    }


}
