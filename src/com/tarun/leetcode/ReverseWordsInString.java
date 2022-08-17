package com.tarun.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseWordsInString {
    // leetcode 151

    public static void main(String[] args) {

        String input = "the sky is blue";
        input = "  the      sky    hello world  ";

        String output = reverseWordsInString(input);

        System.out.println(output);

        System.out.println(output.length());
    }

    private static String reverseWordsInString(String input) {

        char[] charArray = input.toCharArray();

        Deque<String> stack = new ArrayDeque<>();

        int i = 0;
        while (i < charArray.length){

            if (charArray[i] == ' '){
                i++;
                continue;
            }
            String word = "";
            while (i < charArray.length && charArray[i] != ' '){

                word += charArray[i++];
            }
            stack.push(word);

        }

        String reverseString = "";
        int count = stack.size()-1;
        while (!stack.isEmpty()){

            reverseString += stack.pop();
            reverseString = count != 0 ? reverseString + " ": reverseString;
            count--;
        }

        return reverseString;
    }


}
