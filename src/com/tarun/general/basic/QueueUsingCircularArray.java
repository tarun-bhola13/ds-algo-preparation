package com.tarun.general.basic;

import java.util.NoSuchElementException;

public class QueueUsingCircularArray {

    private int[] queue;
    private int front;
    private int rear;
    private int capacity;
    QueueUsingCircularArray(int capacity){
        this.capacity = capacity;
        queue = new int[capacity];
        front = -1;
        rear = -1;
    }
    public static void main(String[] args) {

        QueueUsingCircularArray queue = new QueueUsingCircularArray(5);
        queue.enqueue(10);
        System.out.println(queue.isEmpty());
        queue.enqueue(15);
        queue.enqueue(20);
        queue.enqueue(25);
        queue.enqueue(30);
//        queue.enqueue(35);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.getFront());
        queue.enqueue(25);
        queue.enqueue(30);
        queue.enqueue(35);
        System.out.println(queue.getFront());
        System.out.println(queue.isEmpty());
        System.out.println(queue.isFull());
    }

    public boolean isEmpty(){
        return rear == -1 && front == -1;
    }

    public boolean isFull(){
        return (rear + 1)%capacity == front;
    }

    public void enqueue(int element){
        if (isFull()){
            throw new StackOverflowError();
        }
        rear = (rear + 1) % capacity;
        if (front == -1) front = 0;
        queue[rear] = element;
    }

    public int dequeue(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        int element = queue[front];
        if (front == rear){
            front = -1;
            rear = -1;
        }else
        front = (front + 1) % capacity;

        return element;

    }

    public int getFront(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return queue[front];
    }
}
