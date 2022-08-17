package com.tarun.general.basic;

public class ConvertArrayIntoHeap {

    public static void main(String[] args) {

        int[] input = {0,40,10,30,50,60,15};

        buildHeap(input);
        for (int i : input){
            System.out.print(i+" ");
        }
    }

    private static void buildHeap(int[] input) {

        int length = input.length-1;
        for (int i = length/2 ; i > 0 ; i--){
            heapify(input, i);
        }
    }

    private static void heapify(int[] input, int i) {
        int lChild = 2*i;
        int rChild = 2 * i +1;
        if ( lChild < input.length  && input[i] < input[lChild]){
            swap(input, i , lChild);
            heapify(input,lChild);
        }
        if (rChild < input.length && input[i] < input[rChild]){
            swap(input, i , rChild);
            heapify(input, rChild);
        }
    }

    private static void swap(int[] input, int child, int parent) {

        int temp = input[child];
        input[child] = input[parent];
        input[parent] = temp;
    }


}
