package com.tarun.leetcode;

public class FibonacciNumber {

    // #leetcode - 509
    public static void main(String[] args) {
        int n = 20;
        System.out.println(fib(n));
    }

    private static int fib(int n) {
        if(n <= 1){
            return n;
        }
        int prev = 1;
        int beforePrev = 0;
        int number= 0;
        for(int i = 2 ; i <= n ; i++){
            number = prev + beforePrev;
            beforePrev = prev;
            prev = number;
        }
        return number;
    }
}
