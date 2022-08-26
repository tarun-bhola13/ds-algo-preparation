package com.tarun.leetcode;

public class PowerOfFour {
    // #leetcode - 342
    public static void main(String[] args) {
        int n = 16;
        System.out.println(isPowerOfFour(n));
    }

    private static boolean isPowerOfFour(int n) {
        if(n == 1 || n ==4){
            return true;
        }
        while (n > 4){
            if(n % 4 != 0){
                return false;
            }
            n = n >>2;
            if(n == 4){
                return true;
            }
        }
        return false;
    }
}
