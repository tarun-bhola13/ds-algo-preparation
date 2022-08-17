package com.tarun.general.basic;

public class SearchElementInSortedAndRotatedArray {

    public static void main(String[] args) {

        int[] input = {10,20,30,40,50,60,5};
        int k = 5;

        int index = searchInSortedAndRotatedArray(input,k);
        System.out.println(index);
    }

    private static int searchInSortedAndRotatedArray(int[] input, int k) {

        int low = 0; int high = input.length-1;

        while (low <= high){
            int mid = (low + high) / 2;

            if (input[mid] == k) return mid;
            if (input[mid] > input[low] ){
                if (k < input[mid] && k >= input[low]){
                    high = mid -1;
                }else {
                    low = mid +1;
                }
            }else {
                if (k > input[mid] && k <= input[high]){
                    low = mid +1;
                }else {
                    high = mid -1;
                }
            }
        }
        return -1;
    }


}
