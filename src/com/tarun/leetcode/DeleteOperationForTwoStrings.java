package com.tarun.leetcode;

public class DeleteOperationForTwoStrings {
    // #leetcode - 583

    public static void main(String[] args) {
        String word1 = "sucess";
        String word2 = "srskuccmefsks";
        System.out.println(minDistance(word1,word2));
    }

    private static int minDistance(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length();
       int[][] dp = new int[l1 +1][l2 + 1];

       for(int i = 0 ; i < l1 ;i++){
           for(int j = 0 ; j < l2 ; j++){
               if(word1.charAt(i) == word2.charAt(j)){
                   dp[i+1][j+1] = 1 + dp[i][j];
               }else{
                   dp[i+1][j+1] = Math.max(dp[i+1][j],dp[i][j+1]);
               }
           }
       }

       return l1 + l2 - 2 *dp[l1][l2];
    }
}
