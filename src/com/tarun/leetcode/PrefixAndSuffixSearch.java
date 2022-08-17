package com.tarun.leetcode;

import java.util.*;

public class PrefixAndSuffixSearch {
    // #leetcode - 745
    //{"cabaabaaaa","ccbcababac","bacaabccba","bcbbcbacaa","abcaccbcaa","accabaccaa","cabcbbbcca","ababccabcb","caccbbcbab","bccbacbcba"},["bccbacbcba","a"],["ab","abcaccbcaa"],["a","aa"],["cabaaba","abaaaa"],["cacc","accbbcbab"],["ccbcab","bac"],["bac","cba"],["ac","accabaccaa"],["bcbb","aa"],["ccbca","cbcababac"]]
    Map<String, Map<String,Integer>> map;
    public static void main(String[] args) {

        PrefixAndSuffixSearch search = new PrefixAndSuffixSearch(new String[]{"cabaabaaaa","ccbcababac","bacaabccba","bcbbcbacaa","abcaccbcaa","accabaccaa","cabcbbbcca","ababccabcb","caccbbcbab","bccbacbcba"});
        System.out.println(search.f("a","aa"));
    }
    public PrefixAndSuffixSearch(String[] words) {
        initializeMap(words);
    }

    private void initializeMap(String[] words) {
        map = new HashMap<>();
        for(int i = 0 ; i < words.length; i++){
            String key = "";
            if(words[i].length() > 1) {
                key = key + words[i].charAt(0) + words[i].charAt(words[i].length() - 1);
            }else{
                key = words[i];
            }
            Map<String,Integer> wordMap;
            if(map.containsKey(key)){
                wordMap = map.get(key) ;
            }else{
                wordMap = new LinkedHashMap<>();
            }
            wordMap.put(words[i], i);
            map.put(key,wordMap);

        }

}
    public int f(String prefix, String suffix) {
        int wordIndex = -1;
        int prefixLength = prefix.length();
        int suffixLength = suffix.length();
        List<String> keyList = new ArrayList<>();
        keyList.add(""+prefix.charAt(0)+suffix.charAt(suffixLength-1));
        if(prefix.equals(suffix)){
            keyList.add(prefix);
        }
        for(String key : keyList) {
            if (map.containsKey(key)) {
                for (Map.Entry<String,Integer> entry : map.get(key).entrySet()) {
                    int length = entry.getKey().length();
                    if (prefixLength <= length && suffixLength <= length) {
                        if (prefix.equals(entry.getKey().substring(0, prefixLength))
                                && suffix.equals(entry.getKey().substring(length - suffixLength, length))) {
                            wordIndex = entry.getValue();
                        }
                    }
                }
            }
        }
        return wordIndex;
    }

}
