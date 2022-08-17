package com.tarun.leetcode;

public class MaximumProductOfWordLengths {

    public static void main(String[] args) {

        String[] words = {"a","aa","aaa","aaaa"};
        System.out.println(maxProduct(words));
    }

    private static int maxProduct(String[] words) {

        int maxProduct = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 1; j < words.length; j++) {
                int wordsProduct = getProduct(words[i], words[j]);
                maxProduct = Math.max(maxProduct, wordsProduct);
            }
        }
        return maxProduct;

    }

    private static int getProduct(String word, String word1) {
        int[] chars = new int[26];
        int wordLength1 = word.length();
        int wordLength2 = word1.length();
        for(int i = 0 ; i < wordLength1 ; i++){
            chars[word.charAt(i) - 'a']++;
        }

        for(int j = 0 ; j < wordLength2 ; j++){
            if(chars[word1.charAt(j)-'a'] != 0){
                return 0;
            }
        }
        return wordLength1*wordLength2;
    }


}
