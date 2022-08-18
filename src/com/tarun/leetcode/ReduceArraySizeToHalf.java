package com.tarun.leetcode;

import java.util.*;

public class ReduceArraySizeToHalf {
    // #leetcode - 1338
    public static void main(String[] args) {
        int[] arr = {7,7,7,7,7,7};
        System.out.println(minSetSize(arr));
    }

    private static int minSetSize(int[] arr) {
        int expectedSize = arr.length/2;
        Map<Integer,Integer> map = new TreeMap<>();
        for(int element : arr){
            map.put(element,map.getOrDefault(element,0)+1);
        }

        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list,Comparator.reverseOrder());
        int size = arr.length;
        int count = 0;
        int i = 0;
        while (size > expectedSize){
            size -= list.get(i);
            i++;
            count++;
        }

        return count;
    }

}
