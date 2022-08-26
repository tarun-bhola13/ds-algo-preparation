package com.tarun.leetcode;

public class RansomNote {
    // #leetcode - 383
    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";
        System.out.println(canConstruct(ransomNote, magazine));
    }

    private static boolean canConstruct(String ransomNote, String magazine) {
        int[] frequency = new int[26];
        for (char c : magazine.toCharArray()) {
            frequency[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (frequency[c - 'a'] > 0) {
                frequency[c - 'a']--;
            } else {
                return false;
            }
        }
        return true;
    }
}
