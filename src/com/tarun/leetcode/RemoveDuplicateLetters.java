package com.tarun.leetcode;

import java.util.Stack;

public class RemoveDuplicateLetters {

    public static void main(String[] args) {

        String s  = "abacb";
        String result = removeDuplicateLetters(s);
        System.out.println(result);
    }

    private static String removeDuplicateLetters(String s) {
        char[] charArray = s.toCharArray();
        int[] freq = new int[26];
        boolean[] visited = new boolean[26];
        for(int i = 0 ; i < charArray.length ; i++){
            freq[charArray[i] -'a'] = i;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0 ; i< charArray.length ; i++){
            int index = charArray[i]- 'a';

            if(visited[index]) continue;

            visited[index] = true;
                while (!stack.isEmpty() && stack.peek() > charArray[i] && freq[stack.peek()-'a'] > i){
                 visited[stack.pop()-'a'] = false;
                }
                stack.push(charArray[i]);
        }

        String result = "";
        while (!stack.isEmpty()){
            result = stack.pop()+result;
        }

        return result;
    }
}
