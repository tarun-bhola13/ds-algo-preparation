package com.tarun.general;

    public class Solution {
        public static void main(String[] args) {
            System.out.println(solve(1000000000));
        }
        public static int solve(int A) {
            long count = 0;
            int n = 1000000007;
            int value;
            for(int i = 1 ; i <= A ; i++) {
                value = i;
                while (value != 0) {
                    value = value & (value - 1);
                    count++;
                }
                count= count%n;

            }

            return (int)count;
        }
    }

