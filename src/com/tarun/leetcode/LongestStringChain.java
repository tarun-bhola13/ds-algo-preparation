package com.tarun.leetcode;

import java.util.*;

public class LongestStringChain {
    // #leetcode - 1048

    public static void main(String[] args) {
        String[] words = {"a","b","ba","bca","bda","bdca"};
        System.out.println(longestStrChain(words));
    }

    private static int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)-> a.length()-b.length());
        Map<String,Integer> map = new HashMap<>();

        int ans = 0;
        for(String word : words) {
            int maxCount = 0;
            for (int i = 0; i < word.length(); i++) {
                String predecessor = word.substring(0, i) + word.substring(i + 1);
                maxCount = Math.max(maxCount,map.getOrDefault(predecessor,0)+1);
            }
            map.put(word,maxCount);
            ans = Math.max(ans,maxCount);
        }

        return ans;
    }
}
