package com.tarun.general;

public class QuickSort {

    public static void main(String[] args) {
        int[] input = {4,6,2,5,7,9,1,3};

        for(int i : sortElementsWithQuickSort(input)){
            System.out.print(i);
        }

    }

    private static int[] sortElementsWithQuickSort(int[] input) {


        return quickSort(input,0, input.length-1);
    }

    private static int[] quickSort(int[] input, int l, int h) {

        if (l < h){
            int pivot = partitionElement(input,l,h);
            quickSort(input,l,pivot-1);
            quickSort(input,pivot+1,h);
        }

        return input;

    }

    private static int partitionElement(int[] input ,int l, int h) {

        int pivot = input[l];
        int i = l;
        int j = h;
        while (i < j){

            while (input[i] <= pivot)
                i++;
            while (input[j] > pivot)
                j--;
            if (i < j){
                swap(input,i,j);
            }else {
                swap(input,j,l);
            }

        }

        return j;
    }


    private static void swap(int[] input , int i , int j){

        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;

    }
}
