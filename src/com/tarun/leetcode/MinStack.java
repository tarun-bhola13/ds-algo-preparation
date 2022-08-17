package com.tarun.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public class MinStack {

    private Deque<int[]> stack;

    MinStack(){
        stack = new ArrayDeque<>();
    }
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(10);
        stack.push(5);
        stack.push(15);
        stack.push(20);
        stack.push(4);
        stack.push(3);
        System.out.println(stack.top());
        System.out.println(stack.getMin());
        System.out.println(stack.pop());
        System.out.println(stack.getMin());
        System.out.println(stack.top());
        System.out.println(stack.getMin());
        System.out.println(stack.pop());
        System.out.println(stack.getMin());System.out.println(stack.top());
        System.out.println(stack.getMin());
        System.out.println(stack.pop());
        System.out.println(stack.getMin());System.out.println(stack.top());
        System.out.println(stack.getMin());
        System.out.println(stack.pop());
        System.out.println(stack.getMin());

    }

    public int top(){
        if (stack.size() == 0){
            throw new NoSuchElementException();
        }else {
            return stack.peek()[0];
        }
    }

    public int pop(){
        if (stack.size() == 0){
            throw new NoSuchElementException();
        }else {
            return stack.pop()[0];
        }
    }

    public void push(int element){
        if(stack.size() == 0){
            stack.push(new int[]{element, element});
        }else {
            int min = stack.peek()[1];
            min = Math.min(min,element);
            stack.push(new int[]{element,min});
        }
    }

    public int getMin(){
        if (stack.size() == 0){
            throw new NoSuchElementException();
        }else {
            return stack.peek()[1];
        }
    }
}
