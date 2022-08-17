package com.tarun.leetcode;

public class MirrorReflection {
    // #leetcode - 858
    public static void main(String[] args) {
        int p = 2;
        int q = 1;
        System.out.println(mirrorReflection(p,q));
    }

    private static int mirrorReflection(int p, int q) {
        while (p %2 == 0 && q %2 == 0){
            p /= 2;
            q /= 2;
        }

        if(p %2 ==0 && q %2 != 0){
            return 2;
        } else if (p %2 != 0 && q %2 == 0) {
            return 1;
        } else if (p % 2 != 0 && q %2 != 0) {
            return 0;
        }
            return -1;
    }
}
