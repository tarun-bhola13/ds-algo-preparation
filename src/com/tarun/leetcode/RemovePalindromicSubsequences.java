package com.tarun.leetcode;

public class RemovePalindromicSubsequences {

    public static void main(String[] args) {
        String s = "abb";
        System.out.println(removePalindromeSub(s));
    }

    private static int removePalindromeSub(String s) {
        if(isPalindrome(s))
            return 1;
        return 2;
    }

    private static boolean isPalindrome(String s) {
        if(s.length() == 1){
            return true;
        }
        int front = 0;
        int rear = s.length() -1;

        while (front < rear){
            if(s.charAt(front) != s.charAt(rear)){
                return false;
            }else{
                front++; rear--;
            }
        }
        return true;
    }


}
