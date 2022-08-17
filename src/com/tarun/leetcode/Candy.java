package com.tarun.leetcode;

import java.util.Arrays;

public class Candy {
    // #leetcode - 135

    public static void main(String[] args) {
        int[] ratings = {1,2,2};
        System.out.println(candy(ratings));
    }

    private static int candy(int[] ratings) {
        int[] distributions = new int[ratings.length];
        Arrays.fill(distributions,1);

        for(int i = 0 ; i < ratings.length -1 ; i++){
            if(ratings[i+1] > ratings[i]){
                distributions[i+1] = distributions[i] + 1;
            }
        }

        for(int i = ratings.length - 1; i > 0 ; i--){
            if(ratings[i-1] > ratings[i] && distributions[i-1] <= distributions[i]){
                distributions[i-1] = distributions[i] + 1;
            }
        }
        int count = 0;
        for(int distribution : distributions){
            count += distribution;
        }
        return count;
    }


}
