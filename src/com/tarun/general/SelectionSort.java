package com.tarun.general;

public class SelectionSort {

    public static void main(String[] args) {


        int[] input = {8,4,1,5,9,2};

        for(int i : sortElementsWithSelectionSort(input)){
            System.out.print(i);
        }
    }

    private static int[] sortElementsWithSelectionSort(int[] input) {


        for (int i = 0 ; i < input.length ; i++){
            int minIndex = i;
            for(int j = i+1 ; j < input.length ; j++){
                if (input[j] < input[minIndex]){
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                swap(input, minIndex, i);
            }
        }

        return input;
    }
    private static void swap(int[] input , int i , int j){

        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;

    }


}
