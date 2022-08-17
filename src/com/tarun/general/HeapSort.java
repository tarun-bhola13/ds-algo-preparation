package com.tarun.general;

public class HeapSort {

    public static void main(String[] args) {
        int[] input = {0,40,10,30,50,60,15};

        sortUsingHeapSort(input);

        for (int i : input){
            System.out.println(i + " ");
        }
    }

    private static void sortUsingHeapSort(int[] input) {

        buildHeap(input);
        int length = input.length -1;
        for (int i = 1 ; length > 0 ; ){
            swap(input, i,length--);
            heapify(input,i,length);
        }
    }

    private static void buildHeap(int[] input) {

        int length = input.length-1;
        for (int i = length / 2 ; i > 0 ; i--){

            heapify(input, i, length);
        }

    }

    private static void heapify(int[] input, int i, int length) {

        int lChild = 2 * i ;
        int rChild = 2 * i + 1;

        if (lChild <= length && input[lChild] > input[i]){
            swap(input, i, lChild);
            heapify(input, lChild, length);
        }

        if (rChild <= length && input[rChild] > input[i]){
            swap(input, i, rChild);
            heapify(input, rChild, length);
        }
    }

    private static void swap(int[] input, int parent, int lChild) {

        int temp = input[lChild];
        input[lChild] = input[parent];
        input[parent] = temp;
    }


}
