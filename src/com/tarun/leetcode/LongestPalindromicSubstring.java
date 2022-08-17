package com.tarun.leetcode;

public class LongestPalindromicSubstring {
    // #leetcode - 5

    static int startIndex;
    static int maxLength;
    public static void main(String[] args) {
        String s  = "mississippi";
        System.out.println(longestPalindrome(s));
    }

    private static String longestPalindrome(String s) {

        if(s.length() <= 1){
            return s;
        }

        for(int i = 0 ; i < s.length() ; i++){
            checkLongestPalindrome(s, i , i);
            checkLongestPalindrome(s,i, i+1);
        }

        return s.substring(startIndex, startIndex+ maxLength);
    }

    private static void checkLongestPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            if(maxLength < right-left+1){
                maxLength = right-left +1;
                startIndex = left;
            }
            left--;
            right++;
        }
    }
}
