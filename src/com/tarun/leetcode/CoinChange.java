package com.tarun.leetcode;

import java.util.Arrays;

public class CoinChange {
// #leetcode - 322
    public static void main(String[] args) {
        int[] coins = {2,1,5};
        int amount = 11;
        int count = coinChange(coins,amount);
        System.out.println(count);
    }

    private static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i= 1; i <= amount ;i++){
            for(int element : coins){
                if(i-element >= 0 && dp[i-element] != -1) {
                    dp[i] = Math.min(dp[i], dp[i - element] + 1);
                }
            }
        }
        return dp[amount];
    }
}
