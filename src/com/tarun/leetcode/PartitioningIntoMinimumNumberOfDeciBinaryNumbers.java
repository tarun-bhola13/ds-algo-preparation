package com.tarun.leetcode;

public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers {
    // #leetcode - 1689
    public static void main(String[] args) {
        String n = "27346209830709182346";
        System.out.println(minPartitions(n));
    }

    private static int minPartitions(String n) {
        int maxNumber = 0;
        for(int i = 0 ; i < n.length() ;i++){
            maxNumber = Math.max(maxNumber,n.charAt(i)-48);
        }
        return maxNumber==0?1:maxNumber;
    }
}
