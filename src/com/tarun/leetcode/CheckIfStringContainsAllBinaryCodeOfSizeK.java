package com.tarun.leetcode;

import java.util.HashSet;
import java.util.Set;

public class CheckIfStringContainsAllBinaryCodeOfSizeK {

    // #leetcode - 1461
    public static void main(String[] args) {
        String s = "00110";
        int k = 2;
        System.out.println(hasAllCodes(s, k));
    }

    private static boolean hasAllCodes(String s, int k) {
        if(s.length() <= k){
            return false;
        }
        Set<String> set = new HashSet<>();
        generateSubstrings(s,k,set);

        return set.size() == (int)Math.pow(2,k);

    }

    private static void generateSubstrings(String s, int k, Set<String> set) {

        for(int i = 0 ; i <= s.length() - k ; i++){
            set.add(s.substring(i,i+k));
        }
    }
}
