package com.tarun.leetcode;

public class SortColors {

    // leetcode - 75

    public static void main(String[] args) {

        int[] input = {2,0,2,1,1,0,0,1,1,2,2};

        sortColors(input);
        for (int i : input){
            System.out.print(i + " ->");
        }
    }

    private static void sortColors(int[] input) {
        int redPointer = 0;
        int bluePointer = input.length -1 ;
        int whitePointer = 1;

        while(whitePointer <= bluePointer){

            if (input[redPointer] == 0){
                redPointer++;
            }

            if (input[bluePointer] == 2){
                bluePointer--;
            }

            if (input[redPointer] != 0 && input[whitePointer] == 0){
                swap(input, whitePointer, redPointer);
                redPointer++;
            }else if (input[bluePointer] != 2 && input[whitePointer] == 2){
                swap(input, bluePointer, whitePointer);
                bluePointer--;
            }else
                whitePointer++;

        }

    }

    private static void swap(int[] input, int index1, int index2) {

        int element = input[index1];
        input[index1] = input[index2];
        input[index2] = element;
    }


}
