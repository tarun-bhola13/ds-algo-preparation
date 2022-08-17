package com.tarun.leetcode;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords {
    // #leetcode - 804
    private static String[] morseCodes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

    public static void main(String[] args) {
        String[] words = {"a"};
        System.out.println(uniqueMorseRepresentations(words));

    }

    private static int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        for(String word : words){
            String s = "";
            for(char c : word.toCharArray()){
                s += morseCodes[c-'a'];
            }
            set.add(s);
        }
        return set.size();
    }
}
