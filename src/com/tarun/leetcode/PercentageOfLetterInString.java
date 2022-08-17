package com.tarun.leetcode;

public class PercentageOfLetterInString {
// #leetcode-2278
    public static void main(String[] args) {

        String s = "jjjj";
        char letter = 'j';
        System.out.println(percentageLetter(s,letter));
    }

    private static int percentageLetter(String s, char letter) {
        int letterCount = 0;
        int length = s.length();

        for(int i = 0 ; i < length ; i++){
            if(s.charAt(i) == letter){
                letterCount++;
            }
        }
        return (letterCount * 100)/length;
    }

}
