package com.tarun.general;

public class BinarySearch {

    public static void main(String[] args) {
        int[] input = {-4, -1, 3, 7, 10, 11};
        int k = 12;

        int index = findUsingBinarySearch(input, 0, input.length - 1, k);
        System.out.println(index);
        System.out.println(findUsingBinarySearchIterative(input, k));
    }

    // recursive way
    private static int findUsingBinarySearch(int[] input, int low, int high, int k) {

        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;

        if (input[mid] == k) {
            return mid;
        } else if (input[mid] > k) {
            return findUsingBinarySearch(input, low, mid - 1, k);
        } else
            return findUsingBinarySearch(input, mid + 1, high, k);


    }

    // iterative way

    static int findUsingBinarySearchIterative(int[] input, int k) {

        int low = 0;
        int high = input.length - 1;
        int mid = -1;

        while (low <= high) {
            mid = (low + high) / 2;
            if (input[mid] == k) {
                return mid;
            } else if (input[mid] > k) {
                high = mid - 1;
            } else
                low = mid + 1;
        }

        return -1;
    }
}
