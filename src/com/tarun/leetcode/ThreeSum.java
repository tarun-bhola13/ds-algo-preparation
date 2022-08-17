package com.tarun.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
    //leetcode - 15

    public static void main(String[] args) {

        int[] input = {-1,0,1,2,-1,-4};

        findUniqueTriplets(input);
    }

    private static void findUniqueTriplets(int[] input) {

        Set<List<Integer>> answer = new HashSet<>();

        Arrays.sort(input);

        for (int i = 0 ; i < input.length ; i++){

            int target = input[i] * -1;
            int j = i + 1;
            int k = input.length-1;

            while (j < k){
                int result = input[j] + input[k];
                if (result > target){
                    k--;
                }else if (result < target){
                    j++;
                }else {
                    List<Integer> list = Arrays.asList(input[j],input[k], input[i]);
                    answer.add(list);
                    j++;
                    k--;
                }
            }

        }

        answer.forEach(list -> System.out.println(list));

    }


}
