package com.tarun.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SplitArrayIntoConsecutiveSubsequences {
    // #leetcode - 659
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 4, 5};
        System.out.println(isPossible(nums));
    }

    private static boolean isPossible(int[] nums) {

        Map<Integer, Integer> availMap = new HashMap<>();
        Map<Integer, Integer> vacancyMap = new HashMap<>();
        for (int num : nums) {
            availMap.put(num, availMap.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < nums.length; i++) {

            if (availMap.get(nums[i]) <= 0) {
                continue;
            } else if (vacancyMap.getOrDefault(nums[i], 0) > 0) {
                vacancyMap.put(nums[i], vacancyMap.getOrDefault(nums[i], 0) - 1);
                availMap.put(nums[i], availMap.getOrDefault(nums[i], 0) - 1);
                vacancyMap.put(nums[i] + 1, vacancyMap.getOrDefault(nums[i] + 1, 0) + 1);
            } else if ((availMap.getOrDefault(nums[i], 0)) > 0 &&
                    (availMap.getOrDefault(nums[i] + 1, 0) > 0) &&
                    (availMap.getOrDefault(nums[i] + 2, 0)) > 0) {
                availMap.put(nums[i], availMap.getOrDefault(nums[i], 0) - 1);
                availMap.put(nums[i] + 1, availMap.getOrDefault(nums[i] + 1, 0) - 1);
                availMap.put(nums[i] + 2, availMap.getOrDefault(nums[i] + 2, 0) - 1);
                vacancyMap.put(nums[i] + 3, vacancyMap.getOrDefault(nums[i] + 3, 0) + 1);
            } else {
                return false;
            }
        }

        return true;
    }
}
