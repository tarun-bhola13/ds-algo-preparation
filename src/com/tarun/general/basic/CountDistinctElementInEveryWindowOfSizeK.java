package com.tarun.general.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CountDistinctElementInEveryWindowOfSizeK {

    // Sliding window concept
    public static void main(String[] args) {

        int[] input = {1, 2, 2, 1, 3, 1, 1, 3};
        int size = 4;
        List<Integer> output = findDistinctCountOfEveryWindow(input, size);

        output.forEach(System.out::println);
    }

    private static List<Integer> findDistinctCountOfEveryWindow(int[] input, int size) {

        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int length = input.length;

        for (int i = 0; i < size; i++) {
           map.put(input[i], map.getOrDefault(input[i],0)+1);

        }
        list.add(map.size());

        for (int i = size; i < length; i++) {

            int valueToBeRemoved = input[i - size];

            if (map.get(valueToBeRemoved) == 1) {
                map.remove(input[i - size]);
            } else {
               map.put(valueToBeRemoved, map.get(valueToBeRemoved)-1);
            }

            map.put(input[i], map.getOrDefault(input[i],0)+1);

            list.add(map.size());

        }

        return list;

    }
}



