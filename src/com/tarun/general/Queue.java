package com.tarun.general;

import java.util.NoSuchElementException;

public class Queue {

    private Node head;
    private Node tail;
    int size;

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        System.out.println(queue.size());
    }

    public int size(){
        return size;
    }

    public void enqueue(int data){
        if (head == null){
            head = new Node(data);
            tail = head;
        }else {
            tail.next = new Node(data);
            tail = tail.next;
        }
        size++;
    }

    public int dequeue(){
        if (size == 0){
            throw new NoSuchElementException();
        }else {
            int element = head.data;
            head = head.next;
            size--;
            return element;
        }
    }

    private static class Node{
        private int data;
        private Node next;
        private Node(int data){
            this.data = data;
        }
    }
}
