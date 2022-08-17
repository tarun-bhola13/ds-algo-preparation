package com.tarun.general.basic;

public class MinimizeMaximumPagesReadByStudent {

    public static void main(String[] args) {
        int [] books = {10,5,23,13,30,42};
        int k = 3;
        int minimumPages = minimizeMaximumPagesRead(books, k);
        System.out.println(minimumPages);

    }

    private static int minimizeMaximumPagesRead(int[] books, int k) {

        int minimum = maxOf(books);
        int maximum = sumOf(books);

        int mid = 0;
        int result = 0;

        while (minimum <= maximum){
            mid = (minimum + maximum) / 2;
            if (isFeasible(books, k, mid)){
                maximum = mid-1;
                result = mid;

            }else {
                minimum = mid + 1;
            }
        }
        return result;
    }

    private static boolean isFeasible(int[] books, int k, int res) {

        int sum = 0;
        int numStudent = 1;

        for (int i = 0 ; i < books.length ; i++){

            if (sum + books[i] <= res){
                sum += books[i];
            }else {
                numStudent++;
                sum = books[i];
            }
        }

        return numStudent <= k;
    }

    private static int sumOf(int[] books) {
        int sum = 0;
        for (int book : books){
            sum += book;
        }

        return sum;
    }

    private static int maxOf(int[] books) {

        int max = 0;
        for(int book : books){
            if (max < book){
                max = book;
            }
        }

        return max;
    }


}
