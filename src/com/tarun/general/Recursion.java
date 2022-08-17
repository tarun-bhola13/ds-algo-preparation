package com.tarun.general;

import java.util.Arrays;

public class Recursion {

    // find sum of n natural numbers using recursion
    // find pow(a,b) using recursion
    // find the number of ways in an n*m matrix only 2 directions are allowed right and down
    // Josephus problem(n friends are sitting in a circle and playing a game to shoot a person who is
    // sitting on kth position from his/her position and transfer the gun to the person sitting next to
    // that person. find out the person left at the end of the game)

    public static void main(String[] args) {
        System.out.println(findSum(10));
        System.out.println(findPower(5,3));
        System.out.println(count(2,3));
        System.out.println(josephus(5,4));
        System.out.println(isPalindrome("racecar", 0,6));
        printPowerSet("abc",0,"");
        printAllPermutation("abc",0,2);
    }

    private static int findSum(int n) {

        if (n == 1){
            return 1;
        }
        return n + findSum(n-1);
    }

    static int findPower(int a , int b){
        if (b == 0){
            return 1;
        }
        if ((b & 1) == 0){
            a = a*a;
            b = b/2;
        }
        return a*findPower(a,b-1);
    }

    static int count(int n, int m){
        if (n== 1 || m == 1){
            return 1;
        }
        return count(n,m-1) + count(n-1,m);
    }

    static int josephus(int n , int k){

        if (n == 1 ){
            return 0;
        }
        return (josephus(n-1,k) + k)%n;
    }

    // String recursion
    // check palindrome
    static boolean isPalindrome(String input, int i , int j){
        if (i == j){
            return true;
        }
        if (input.charAt(i) != input.charAt(j)){
           return false;
        }

        return isPalindrome(input,i+1,j-1);
    }

    // find PowerSet or Subsequence of a given string

    static void printPowerSet(String input, int index, String current){
        if (index == input.length()){
            System.out.println("set "+ current);
            return;
        }
        printPowerSet(input,index+1,current+ input.charAt(index));
        printPowerSet(input,index+1, current);
    }

    // print all permutations of a given string

    static void printAllPermutation(String input, int left, int right){

        if (left == right){
            System.out.println(input);
            return;
        }

        for (int i = left ; i <= right ; i++){
            input = swap(input, left, i);
            printAllPermutation(input,left + 1, right);
            input = swap(input, left,i);
        }

    }

    private static String swap(String input, int l, int r) {

        char[] inputArray = input.toCharArray();
        char c = inputArray[l];
        inputArray[l] = inputArray[r];
        inputArray[r] = c;

        return String.valueOf(inputArray);
    }


}
