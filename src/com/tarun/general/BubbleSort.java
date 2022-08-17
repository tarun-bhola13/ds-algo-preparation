package com.tarun.general;

public class BubbleSort {

    public static void main(String[] args) {
        int[] input = {4,3,7,1,5};

        for(int i : sortElementsWithBubbleSort(input)){
            System.out.print(i);
        }
    }

    private static int[] sortElementsWithBubbleSort(int[] input) {
        boolean isSwapped = false;
        for(int i = 0; i< input.length ; i++){

            for(int j = 0 ; j < input.length - i-1 ; j++){

                if (input[j] > input[j+1]){

                    swap(input, j , j+1);
                    isSwapped = true;
                }
            }

            if (!isSwapped){
                break;
            }
        }

        return input;
    }

    private static void swap(int[] input , int i , int j){

        input[i] = input[i] ^ input[j];
        input[j] = input[i] ^ input[j];
        input[i] = input[i] ^ input[j];
    }


}
