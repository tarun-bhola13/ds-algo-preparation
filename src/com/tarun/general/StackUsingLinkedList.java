package com.tarun.general;


public class StackUsingLinkedList {

    private Node head;
    private int top = 0;

    public static void main(String[] args) {

        StackUsingLinkedList myStack = new StackUsingLinkedList();
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

    public int pop(){
        if (head == null){
            return -1;
        }
        int element = head.data;
        head = head.next;
        top--;
        return element;
    }

    public int peek(){

        return head == null? -1: head.data;

    }

    public void push(int element){
        Node newNode = new Node(element);
        Node temp = head;
        head = newNode;
        head.next = temp;
        top++;
    }

    public int size(){
        return top;
    }

    private static class Node{

        int data;
        Node next;
        private Node(int data){
            this.data = data;
        }
    }
}
