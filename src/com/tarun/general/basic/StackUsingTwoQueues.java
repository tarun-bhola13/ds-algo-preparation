package com.tarun.general.basic;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueues {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    private int top;

    public StackUsingTwoQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();

    }

    public static void main(String[] args) {
        StackUsingTwoQueues stack = new StackUsingTwoQueues();

        stack.push(10);
        stack.push(20);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        stack.push(30);

        System.out.println(stack.peek());
        stack.push(40);
        stack.push(50);

    }

    public void push(int element){

        while (!queue1.isEmpty()){
            queue2.add(queue1.poll());
        }
        queue1.add(element);
        while (!queue2.isEmpty()){
            queue1.add(queue2.poll());
        }
    }

    public int pop(){
        return queue1.poll();
    }

    public int peek(){
        return queue1.peek();
    }
}
