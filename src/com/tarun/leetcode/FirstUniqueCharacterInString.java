package com.tarun.leetcode;

public class FirstUniqueCharacterInString {
    // #leetcode - 387
    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
    }

    private static int firstUniqChar(String s) {
        int[] alphabets = new int[26];

        for(int i = 0 ;i < s.length() ; i++){
            alphabets[s.charAt(i)-'a']++;
        }
        for(int i = 0 ; i < s.length();i++){
            if(alphabets[s.charAt(i)-'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}
