package com.tarun.leetcode;

public class CountSortedVowelStrings {
// #leetcode - 1641
    static int count = 0;
    public static void main(String[] args) {

        int n = 33;
        int output = countVowelStrings(n);
        System.out.println(output);
    }

    private static int countVowelStrings(int n) {
        char[] vowels = {'a','e','i','o','u'};
        helper(vowels,n,0,"");
        return count;
    }

    private static void helper(char[] vowels, int n, int index, String currentString) {
        if(index >= vowels.length){
            return;
        }
        if(currentString.length() == n){
            count++;
            return;
        }

        for(int i = index ; i < vowels.length ;i++){
            helper(vowels,n,i,currentString+vowels[i]);
        }
    }

}
