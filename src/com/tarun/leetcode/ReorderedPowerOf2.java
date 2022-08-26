package com.tarun.leetcode;

public class ReorderedPowerOf2 {
    // #leetcode - 869
    public static void main(String[] args) {

        int n = 128;
        System.out.println(reorderedPowerOf2(n));
    }

    private static boolean reorderedPowerOf2(int n) {

       int[] digitFreq = getDigitsOfNumber(n);
       for(int i = 0 ; i < 31 ;i++){
           int digitPowerOf2 = (int)Math.pow(2,i);
           int[] digitPowerOf2Freq = getDigitsOfNumber(digitPowerOf2);
           if(compareFreqArray(digitFreq,digitPowerOf2Freq)){
               return true;
           }
       }
       return false;
    }

    private static boolean compareFreqArray(int[] digitFreq, int[] digitPowerOf2Freq){
        for(int i = 0 ; i < 10 ; i++){
            if(digitFreq[i] != digitPowerOf2Freq[i]){
                return false;
            }
        }
        return true;
    }

    private static int[] getDigitsOfNumber(int n) {
        int[] digitFreq = new int[10];
        while (n > 0){
            digitFreq[n%10]++;
            n /= 10;
        }
        return digitFreq;
    }
}
