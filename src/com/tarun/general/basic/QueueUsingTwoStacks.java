package com.tarun.general.basic;


import java.util.NoSuchElementException;
import java.util.Stack;

public class QueueUsingTwoStacks {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    private int top;

    public QueueUsingTwoStacks() {

        stack1 = new Stack();
        stack2 = new Stack();
        top = -1;
    }

    public static void main(String[] args) {

        QueueUsingTwoStacks queue = new QueueUsingTwoStacks();

        queue.enqueue(10);
        System.out.println(queue.peek());
        queue.enqueue(15);
        queue.enqueue(20);
        queue.enqueue(25);
        System.out.println(queue.size());
        System.out.println(queue.peek());
        queue.enqueue(30);
        System.out.println(queue.dequeue());
        queue.enqueue(35);
        System.out.println(queue.peek());
    }

    public void enqueue(int element){

        if (stack1.isEmpty()){
            top = element;
        }
        stack1.push(element);

    }

    public int dequeue(){

        if (stack1.isEmpty()){
            throw new NoSuchElementException();
        }
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int element = stack2.pop();
        top = stack2.peek();
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return element;
    }

    public int peek(){
        return top;
    }

    public int size(){
        return stack1.size();
    }
}
