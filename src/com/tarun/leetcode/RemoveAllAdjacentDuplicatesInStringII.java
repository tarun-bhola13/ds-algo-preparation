package com.tarun.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInStringII {

    public static void main(String[] args) {

        String s = "abcd";
        int k = 3;
        System.out.println(removeDuplicates(s,k));
    }

    public static String removeDuplicates(String s, int k){

        Deque<Pair> stack = new ArrayDeque<>();

        for(int i = 0 ; i < s.length() ;i++){
            if(stack.isEmpty()){
                stack.push(new Pair(s.charAt(i),1));
            }else{
                if(stack.peek().c == s.charAt(i)){
                    Pair pair = stack.pop();
                    int freq = pair.f + 1;
                    if(freq == k){
                        continue;
                    }else{
                        pair.f = freq;
                        stack.push(pair);
                    }
                }else{
                    stack.push(new Pair(s.charAt(i),1));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            Pair p = stack.pollLast();
            String rs = "";
            for(int i = 1;i<=p.f ;i++){
                rs = rs+p.c;
            }
            sb.append(rs);
        }
        return sb.toString();
    }

    static class Pair{
        char c;
        int f;

        public Pair(char c, int f) {
            this.c = c;
            this.f = f;
        }
    }
}
