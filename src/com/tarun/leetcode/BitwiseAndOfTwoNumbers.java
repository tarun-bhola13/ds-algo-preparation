package com.tarun.leetcode;

public class BitwiseAndOfTwoNumbers {

    public static void main(String[] args) {

        int right = 7; int left = 5;

        int output = bitwiseAndOfTwoNumbers(right,left);
        System.out.println(output);
    }

    private static int bitwiseAndOfTwoNumbers(int right, int left) {

        int shiftCount = 0;

        while (right != left){
            right = right>>1;
            left = left>>1;
            shiftCount++;
        }
        return right<<shiftCount;
    }


}
