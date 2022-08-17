package com.tarun.leetcode;

public class DivideTwoIntegers {

    public static void main(String[] args) {
        int dividend = -2147483648;
        int divisor = -1;

        System.out.println(divide(dividend,divisor));
    }

    private static int divide(int dividend, int divisor) {
        boolean negative = false;
       if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)){
           negative = true;
       }
       long lDividend = Math.abs((long)dividend);
       long lDivisor = Math.abs((long)divisor);
       long count = longDivide(lDividend,lDivisor);
       if(count > Integer.MAX_VALUE){
            if(negative){
                return Integer.MIN_VALUE;
            }else{
                return Integer.MAX_VALUE;
            }
       }else{
           if(negative){
               return (int)(-count);
           }else{
               return (int)count;
           }
       }
    }

    private static long longDivide(long lDividend, long lDivisor) {

        if(lDividend < lDivisor){
            return 0;
        }
        long count = 1;
        long sum = lDivisor;

        while ((2*sum) <= lDividend){
            sum *= 2;
            count *= 2;
        }
        return count + longDivide(lDividend-sum,lDivisor);
    }
}
