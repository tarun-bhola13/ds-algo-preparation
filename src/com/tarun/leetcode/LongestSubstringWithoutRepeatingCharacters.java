package com.tarun.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }

    private static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if(length < 2){
            return length;
        }
        Set<Character> set = new HashSet<>();
        int maxCount = 0;
        int j = 0;
        for(int i = 0 ; i < length ;i++){
            char c = s.charAt(i);
            while (set.contains(c)){
                set.remove(s.charAt(j));
                j++;
            }
                set.add(c);
                maxCount = Math.max(maxCount, set.size());

        }
        return maxCount;
    }


}
