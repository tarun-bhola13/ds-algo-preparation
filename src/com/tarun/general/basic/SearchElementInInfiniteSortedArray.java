package com.tarun.general.basic;

import java.util.Arrays;

public class SearchElementInInfiniteSortedArray {

    public static void main(String[] args) {

        int[] input = {1,2,3,10,11,23,45,56,78,98,101,223,1211,4454,54543,645343};

        int element = 98;

        int output = searchElement(input, element);
        System.out.println(output);
    }

    private static int searchElement(int[] input, int element) {

        int low = 0;
        int high = 1;

        while (high < input.length && input[high] < element){
            low = high;
            high *= 2;
        }
        return Arrays.binarySearch(input,low,high,element);
    }
}
