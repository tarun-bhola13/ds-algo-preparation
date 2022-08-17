package com.tarun.leetcode;

import java.util.*;

public class RussianDollEnvelopes {

    public static void main(String[] args) {

//        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        int[][] envelopes = {{2, 100}, {3, 200}, {4, 300}, {5, 500}, {5, 400}, {5, 250}, {6, 370}, {6, 360}, {7, 380}};

        int result = new RussianDollEnvelopes().maxEnvelopes(envelopes);
        System.out.println(result);
    }

    private int maxEnvelopes(int[][] envelopes) {
        int length = envelopes.length;
        if (envelopes.length == 1) {
            return 1;
        }
        Arrays.sort(envelopes,(a,b)-> {
            if(a[0] > b[0]){
                return 1;
            }else if(a[0] < b[0]){
                return -1;
            } else {
                if(a[1] > b[1]){
                    return 1;
                }else if(a[1] < b[1]){
                    return -1;
                }
            }
            return 0;
        });
        int[] lis = new int[length];
        Arrays.fill(lis, 1);
        int maxLength = 1;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (lis[i] <= lis[j]) {
                    if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                        lis[i] = 1 + lis[j];
                        maxLength = Math.max(maxLength, lis[i]);
                    }
                }
            }
        }
        return maxLength;
    }
}