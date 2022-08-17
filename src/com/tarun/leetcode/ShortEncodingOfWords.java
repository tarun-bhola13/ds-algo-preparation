package com.tarun.leetcode;

import java.util.*;

public class ShortEncodingOfWords {
    // #leetcode - 820
    public static void main(String[] args) {

        String[] words = {"me","bell","me","time"};
        System.out.println(minimumLengthEncoding(words));
    }

    private static int minimumLengthEncoding(String[] words) {

        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        List<String> wordList = new ArrayList<>(wordSet);
        Set<String> set = new HashSet<>();

        for(int i = 0 ; i < wordList.size() ; i++){
            for(int j = 0 ; j < wordList.size() ; j++){
                if(i != j){
                    if(wordList.get(i).endsWith(wordList.get(j))){
                        set.add(wordList.get(j));
                    }
                }
            }
        }
        int count = 0;
        for(String word : wordList){
            if(!set.contains(word)){
                count = count + word.length() + 1;
            }
        }
        return count;
    }
}
