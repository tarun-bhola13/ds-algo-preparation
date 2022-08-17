package com.tarun.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumDeletionsToMakeCharacterFrequenciesUnique {
    // #leetcode - 1647
    public static void main(String[] args) {
        String s = "aabbcc";
        System.out.println(minDeletions("aaabbbcc"));
    }

    private static int minDeletions(String s) {
        int[] chars = new int[26];
        for(int i = 0 ; i < s.length() ; i++){
            chars[s.charAt(i) -'a']++;
        }
        Set<Integer> set = new HashSet<>();
        List<Integer> similarFrequency = new ArrayList<>();

        for(int i = 0 ; i < chars.length ;i++){

            if(chars[i] != 0) {
                if (set.contains(chars[i])) {
                    similarFrequency.add(chars[i]);
                } else {
                        set.add(chars[i]);
                }
            }
        }
        int count = 0;
        if(similarFrequency.size() > 0){
            for(int element : similarFrequency){
                while (element > 0){
                    if(set.contains(element)){
                      element--;
                      count++;
                    }else{
                        set.add(element);
                        break;
                    }
                }
            }
        }

        return count;
    }
}
