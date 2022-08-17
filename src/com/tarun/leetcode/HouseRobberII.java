package com.tarun.leetcode;

public class HouseRobberII {
    // #leetcode - 213
    static int maxAmount = 0;
    public static void main(String[] args) {
        int[] nums = {2,3,2};
        System.out.println(rob(nums));
    }

    private static int rob(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        dfs(nums,visited,0);
        return maxAmount;
    }

    private static int dfs(int[] nums, boolean[] visited, int index) {
            return 0;
    }
}
