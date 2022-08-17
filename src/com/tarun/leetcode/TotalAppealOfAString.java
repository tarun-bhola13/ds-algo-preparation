package com.tarun.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class TotalAppealOfAString {
    public static void main(String[] args) {

        String s = "abbca";
//        long result = appealSum(s);
        long result = appealSumDp(s);
        System.out.println(result);
    }

    private static long appealSum(String s) {
        int[] characters = new int[26];
        long finalSum = 0;
        for (int i = 0; i < s.length(); i++) {
            long sum = 0;
            Arrays.fill(characters, 0);
            for (int j = i; j < s.length(); j++) {
                int index = s.charAt(j) - 'a';
                if (characters[index] == 0) {
                    characters[index] = 1;
                    sum = sum + 1;
                }
                finalSum = finalSum + sum;
            }
        }
        return finalSum;
    }

    private static long appealSumDp(String s) {
        int n = s.length();
        long[] dp = new long[n + 1];
        int[] lastIndex = new int[26];
        Arrays.fill(lastIndex, -1);
        long ans = 0l;

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            dp[i + 1] = dp[i] + i - lastIndex[c];
            ans = ans + dp[i + 1];
            lastIndex[c] = i;
        }
        return ans;
    }


}
