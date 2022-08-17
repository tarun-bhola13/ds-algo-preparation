package com.tarun.leetcode;

public class PalindromicSubstrings {
// #leetcode - 647
    public static void main(String[] args) {
        String s = "abcabsbc";
        int count = countSubstrings(s);
        System.out.println(count);
    }

    private static int countSubstrings(String s) {

        int length = s.length();
        int count = 0;
        for(int i = 0 ; i < length ; i++){
            for(int j = i ; j < length ;j++){
                if(palindrome(s,i,j)){
                    count++;
                }
            }
        }
    return count;
    }

    private static boolean palindrome(String s, int i, int j) {

        while (i<= j){
            if(s.charAt(i) == s.charAt(j)){
                i++; j--;
            }else{
                return false;
            }
        }
        return true;
    }
}
