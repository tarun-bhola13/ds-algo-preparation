package com.tarun.general.basic;

import java.util.HashMap;

public class SubArrayWithGivenSum {

    public static void main(String[] args) {

        int[] input = {10, 15, -5, 15, -10, 5};
        int sum = 5;

        int[] output = findSubArrayWithSum(input, sum);

        for (int i : output){
            System.out.print(i+" ");
        }
    }

    private static int[] findSubArrayWithSum(int[] input, int sum) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int start = 0;
        int end = -1;
        int currSum = 0;
        int[] resultArray = new int[input.length];

        for (int i = 0; i < input.length; i++) {

            currSum = currSum + input[i];
            if (currSum - sum == 0) {
                start = 0;end = i;
                break;
            }

            if (map.containsKey(currSum - sum)) {
                start = map.get(currSum - sum) + 1;
                end = i;
                break;
            } else {
                map.put(currSum, i);
            }
        }

        if (start <= end){

            int i = 0;
            while (start <= end){
                resultArray[i++] = input[start++];
            }
        }else {
            System.out.println("No subarray exist with given sum");
        }

        return resultArray;
    }
}
