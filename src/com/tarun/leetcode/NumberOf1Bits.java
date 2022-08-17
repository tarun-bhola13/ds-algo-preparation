package com.tarun.leetcode;

public class NumberOf1Bits {
// #leetcode-191
    public static void main(String[] args) {

        int n = -3;
        int result = hammingWeight(n);
        System.out.println(result);
        System.out.println(hammingWeightOptimized(n));
    }

    private static int hammingWeight(int n) {
        int count = 0;
        for(int i = 0 ; i < 32 ; i++){
            if((n&1) == 1){
                count++;
            }
            n=n>>1;
        }
        return count;
    }

    private static int hammingWeightOptimized(int n) {
        int count = 0;
        while(n != 0){
            n= n & (n-1);
            count++;
        }
        return count;
    }
}
