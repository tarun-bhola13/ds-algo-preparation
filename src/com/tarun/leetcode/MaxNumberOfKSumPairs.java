package com.tarun.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxNumberOfKSumPairs {
    public static void main(String[] args) {

        int[] nums = {3, 1, 3, 4,3};
        int k = 6;
        int result = maxOperations(nums, k);
        System.out.println(result);

    }

    static int maxOperations(int[] nums, int k) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        int countOperations = 0;
        for (int i = 0; i < nums.length; i++) {
            int remainingSum = k - nums[i];
            if (map.containsKey(remainingSum)) {
                if (map.get(remainingSum).size() == 1) {
                    map.remove(remainingSum);
                } else {
                    ArrayList<Integer> list = map.get(remainingSum);
                    list.remove(list.size() - 1);
                    map.put(remainingSum, list);

                }
                countOperations++;
            } else {
                if (map.containsKey(nums[i])) {
                    ArrayList<Integer> list = map.get(nums[i]);
                    list.add(i);
                    map.put(nums[i], list);
                } else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(nums[i],list);
                }
            }
        }
        return countOperations;
    }
}
