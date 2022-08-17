package com.tarun.general;

public class Stack {

    private int[] array;
    private int capacity;
    private int top = -1;

    public Stack(int capacity){
        array = new int[capacity];
        this.capacity = capacity;
    }
    public static void main(String[] args) {

        Stack myStack = new Stack(10);
        System.out.println(myStack.pop());
        System.out.println(myStack.size());
        System.out.println(myStack.peek());
        myStack.push(10);
        myStack.push(30);
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());

        myStack.push(30);
        myStack.push(20);
        myStack.push(14);
        myStack.push(12);
        System.out.println(myStack.peek());
        myStack.push(32);
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());

    }

    public void push(int element){
        if (top == capacity-1){
            System.out.println("Stack is full");
        }
        array[++top] = element;
    }

    public int pop(){
        if (top == -1){
            System.out.println("Stack is empty");
            return -1;
        }
        return array[top--];
    }

    public int peek(){

        if (top == -1){
            System.out.println("stack is empty");
            return -1;
        }
        return array[top];
    }

    public int size(){
        return top + 1;
    }
}
