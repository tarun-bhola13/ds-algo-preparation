package com.tarun.leetcode;

public class CountVowelsPermutation {

    private static long[][] dp ;
    private static int mod = (int)1000000007;
    public static void main(String[] args) {
        int n = 2;

        System.out.println(countVowelPermutation(n));
    }

    private static int countVowelPermutation(int n) {
        if(n == 1){
            return 5;
        }
        dp = new long[6][n+1];
        for(int i = 0 ; i < 5 ; i++){
            dp[i][0] = 1;
        }

        helper(n,'x');
        return (int)dp[5][n];

    }

    private static long helper(int n, char vowel) {

        long ans = 0;
        if(n == 0){
            return 1;
        }

        if(vowel == 'x'){
            ans = (ans + helper(n-1,'a') + helper(n-1,'e')+helper(n-1,'i') + helper(n-1,'o') + helper(n-1,'u'))%mod;
            dp[5][n] = ans;
        } else if (vowel == 'a') {
            if (dp[0][n] != 0) return dp[0][n];
            ans = (ans + helper(n-1, 'e'))%mod;
            ans = dp[0][n];
        }else if (vowel == 'e') {
            if (dp[1][n] != 0) return dp[1][n];
            ans = (ans + helper(n-1, 'i') + helper(n-1, 'a'))%mod;
            ans = dp[1][n];
        }
        else if (vowel == 'i') {
            if (dp[2][n] != 0) return dp[2][n];
            ans = (ans + helper(n-1,'a') + helper(n-1,'e')+ helper(n-1,'o') + helper(n-1,'u'))%mod;
            ans = dp[2][n];
        }else if (vowel == 'o') {
            if (dp[3][n] != 0) return dp[3][n];
            ans = (ans + helper(n-1, 'i') + helper(n-1, 'u'))%mod;
            ans = dp[3][n];
        }else{
            if (dp[4][n] != 0) return dp[4][n];
            ans = (ans + helper(n-1, 'a'))%mod;
            ans = dp[4][n];
        }

        return ans;
    }
}
