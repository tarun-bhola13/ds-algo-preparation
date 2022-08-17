package com.tarun.leetcode;

import java.util.*;

public class SortCharactersByFrequency {
    // leetcode - 451

    public static void main(String[] args) {

        String input = "cbcaebcaeed";

        String output = sortString(input);
        System.out.println(output);

        output = sortStringEfficiently(input);
        System.out.println(output);
    }

    private static String sortString(String input) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            map.put(input.charAt(i), map.getOrDefault(input.charAt(i), 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        queue.addAll(map.entrySet());

        String output = "";
        while (!queue.isEmpty()) {
            Map.Entry<Character, Integer> kV = queue.poll();
            int count = kV.getValue();

            while (count-- > 0) {
                output += kV.getKey();
            }
        }


        return output;
    }

    private static String sortStringEfficiently(String input) {

        Map<Character, Integer> map = new HashMap<>();

        int max = 0;
        for (int i = 0; i < input.length(); i++) {

            char c = input.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
                max = Math.max(max, map.get(c));
            }
        }

        List<Character>[] array = new List[max + 1];

        map.forEach((key, value) -> {
            if (array[value] == null) {
                array[value] = new ArrayList<>(key);
                array[value].add(key);
            } else {
                array[value].add(key);
            }
        });

        return buildOutputString(array);
    }

    private static String buildOutputString(List<Character>[] array) {

        StringBuilder sb = new StringBuilder();
        for (int i = array.length - 1; i >= 0; i--) {

            if (array[i] != null) {
                List<Character> list = array[i];
                if (list != null) {
                    for (Character c : list) {
                        for (int j = 0; j < i; j++) {
                            sb.append(c);
                        }
                    }
                }
            }
        }

        return sb.toString();
    }


}
