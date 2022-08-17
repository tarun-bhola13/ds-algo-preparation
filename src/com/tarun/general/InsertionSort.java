package com.tarun.general;

public class InsertionSort {

    public static void main(String[] args) {

        int[] input = {8,4,1,5,9,2};

        for(int i : sortElementsWithInsertionSort(input)){
            System.out.print(i);
        }
    }

    private static int[] sortElementsWithInsertionSort(int[] input) {

        for (int i = 1 ; i < input.length ; i++){

            int temp = input[i];

            for (int j = i-1 ; j >= 0 ; j--){

                if (temp < input[j]){
                    input[j+1] = input[j];
                    input[j] = temp;
                    temp = input[j];

                }else
                    break;
            }
        }
        return input;
    }



}
