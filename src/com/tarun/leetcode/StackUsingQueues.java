package com.tarun.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {

    // #leetcode - 225
    private Queue<Integer> queue = new LinkedList<>();
    private Queue<Integer> tempQueue = new LinkedList<>();
    int top;

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.empty());

    }

    public void push(int x) {
        top = x;
        queue.offer(x);
    }

//    public int pop() {
//        while (queue.size() > 1) {
//            tempQueue.add(queue.poll());
//        }
//        int element = queue.poll();
//        while (!tempQueue.isEmpty()) {
//            push(tempQueue.poll());
//        }
//        return element;
//    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public int pop(){
        int size = queue.size();
        while (size > 1){
            push(queue.poll());
            size--;
        }
        return queue.poll();
    }
}
