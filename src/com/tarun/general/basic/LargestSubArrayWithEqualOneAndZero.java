package com.tarun.general.basic;

import java.util.HashMap;

public class LargestSubArrayWithEqualOneAndZero {

    public static void main(String[] args) {

        int[] input = {1,1,0,1,1,0,0,1,0,1,1,0};

        int[] refinedInput = new int[input.length];

        for (int i = 0 ; i < input.length ; i++){
            if (input[i] == 0){
                refinedInput[i] = -1;
            }else {
                refinedInput[i] = input[i];
            }
        }
        findLargestSubArrayWithEqualOneAndZero(refinedInput, 0);
    }

    private static void findLargestSubArrayWithEqualOneAndZero(int[] input, int sum) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int start = 0;
        int end = -1;
        int currSum = 0;

        for (int i = 0 ; i< input.length ; i++){

            currSum = currSum + input[i];

            if (currSum == sum){
                end = i;
            }
            if (map.containsKey(currSum - sum)){
                start = map.get(currSum-sum) + 1;
                end = i;
            }else {
                map.put(currSum,i);
            }
        }

        System.out.println(start + " "+ end);

    }


}
