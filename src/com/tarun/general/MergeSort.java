package com.tarun.general;

public class MergeSort {

    public static void main(String[] args) {

        int[] input = {4,6,2,5,7,9,1,3,8};

        sortElementsWithMergeSort(input);
        for(int i : input){
            System.out.print(i);
        }
    }

    private static void sortElementsWithMergeSort(int[] input) {

        mergeSort(input,0, input.length-1);
    }

    private static void mergeSort(int[] input, int l, int h) {

        if (l < h){
            int mid = (l+h)/2;

            mergeSort(input,l,mid);
            mergeSort(input,mid+1,h);
            merge(input,l,mid,h);
        }

    }

    private static void merge(int[] input, int l, int mid, int h) {

        int i = l;
        int j = mid+1;
        int k = l;
        int[] output = new int[input.length];
        while ( i <= mid && j <= h){

            if (input[i] > input[j]){
                output[k++] = input[j++];

            }else
                output[k++] = input[i++];
        }
        if (i > mid){
            while (j <= h){
                output[k++] = input[j++];
            }
        }else {
            while (i <= mid) {
                output[k++] = input[i++];
            }
        }

        System.arraycopy(output,l,input,l,h-l+1);
    }

}
