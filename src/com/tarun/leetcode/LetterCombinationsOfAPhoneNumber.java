package com.tarun.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        String digits = "";

        letterCombinations(digits);
    }

    static List<String> letterCombinations(String digits){
        List<String> ans = new ArrayList<>();
        String[] set = new String[10];
        set[2] = "abc";
        set[3] = "def";
        set[4] = "ghi";
        set[5] = "jkl";
        set[6] = "mno";
        set[7] = "pqrs";
        set[8] = "tuv";
        set[9] = "wxyz";
        if(digits == null || digits.length()==0){
            return ans;
        }

        helper(ans,digits,set,0,"");

        ans.forEach(System.out::println);
    return ans;
    }

    private static void helper(List<String> ans, String digits, String[] set, int index, String currentString) {

        if(index == digits.length()){
            ans.add(currentString);
            return;
        }

        String possibleChars = set[digits.charAt(index) - '0'];
        for(char c: possibleChars.toCharArray()){
            helper(ans,digits,set,index+1,currentString + c);
        }

    }
}
