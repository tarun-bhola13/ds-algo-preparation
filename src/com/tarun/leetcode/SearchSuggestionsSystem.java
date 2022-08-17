package com.tarun.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SearchSuggestionsSystem {
    // #leetcode - 1268
    public static void main(String[] args) {
        String[] products = {"bags","baggage","banner","box","cloths"};
        String searchWord = "bags";
        List<List<String>> output = suggestedProducts(products,searchWord);
        output.stream().forEach(System.out::println);
    }

    private static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products, Comparator.naturalOrder());
        List<List<String>> searchList = new ArrayList<>();
        int searchIndex = 0;
        String currentString = "";
        for (int i = 0; i < searchWord.length(); i++) {
            currentString = currentString + searchWord.charAt(i);
            List<String> currentList = new ArrayList<>();
            for (int j = searchIndex; j < products.length; j++) {
                if (currentList.size() < 3) {
                    if (products[j].length() >= currentString.length()) {
                        if (currentString.equals(products[j].substring(0, currentString.length()))) {
                            currentList.add(products[j]);
                            searchIndex = j;
                        }
                    }
                } else {
                    break;
                }
            }
            searchIndex = searchIndex - currentList.size() + 1;
            searchList.add(currentList);
        }
        return searchList;
    }
}
