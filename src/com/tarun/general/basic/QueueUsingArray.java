package com.tarun.general.basic;

import java.util.NoSuchElementException;

public class QueueUsingArray {

    private int[] queue;
    private int capacity;
    private int rear = -1;
    QueueUsingArray(int capacity){
        queue = new int[capacity];
        this.capacity = capacity;
    }
    public static void main(String[] args) {

    }



    // Normal Array
    void enqueue(int data){

        if (rear == capacity -1){
            throw new OutOfMemoryError();
        }
        rear++;
        queue[rear] = data;
    }

    int dequeue(){
        if (rear == -1){
            throw new NoSuchElementException();
        }
        int element = queue[0];
        if (rear == 1){
            queue[0] = -1;
            rear--;
            return element;
        }

        for (int i = 1 ; i <= rear ; i++){
            queue[i-1] = queue[i];
        }
        rear--;

        return element;
    }

    int getFront(){
        if (rear == 0){
            throw new NoSuchElementException();
        }
        rear--;
        return queue[0];
    }


}
