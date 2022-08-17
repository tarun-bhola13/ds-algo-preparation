package com.tarun.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSumIII {

    public static void main(String[] args) {

        int k = 3;
        int n = 20;

        List<List<Integer>> result = combinationSum3(n, k);

       result.forEach(list->list.forEach(System.out::println));
    }

    private static List<List<Integer>> combinationSum3(int n, int k) {
        Set<List<Integer>> ans = new HashSet<>();
        helper(n,k,new HashSet<>(),ans);
       return new ArrayList<>(ans);

    }

    private static void helper(int currentSum, int noOfElements, Set<Integer> runningSet, Set<List<Integer>>  ans) {
       if(noOfElements == 0){
           if(currentSum == 0){
               ans.add(new ArrayList<>(runningSet));
           }
           return;
       }
       if(currentSum < 0){
           return;
       }
        for(int i = 1 ;i <=9 ; i++){
            if(!runningSet.contains(i)) {
                runningSet.add(i);
                helper(currentSum - i, noOfElements - 1, runningSet, ans);
                runningSet.remove(i);
            }
        }
    }
}
