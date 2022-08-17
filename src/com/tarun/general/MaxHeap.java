package com.tarun.general;

public class MaxHeap {

    private int[] heap;
    private int size;

    MaxHeap(int size) {
        heap = new int[size+1];
    }

    public void insert(int element){
        if (size < heap.length){
            heap[++size] = element;
            heapify(heap, size,true);
        }

    }

    public int remove(){
        int element = -1;
        if (size > 0){
            element = heap[1];
            heap[1] = heap[size--];

            heapify(heap, 1,false);
        }

        return element;

    }

    public int peek(){
       return size > 0 ? heap[1] : -1;
    }

    public void print(){
        for (int i = 1; i <= size ; i++){
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    private void heapify(int[] heap , int index, boolean isChild){
        if (isChild) {
            int parent = index / 2;
            if (parent > 0 && (heap[index] > heap[parent])) {
                swap(heap, index, parent);
                heapify(heap, parent, true);
            }
        }else {
            int lChild = 2* index;
            int rChild = 2*index + 1;

            if (lChild < heap.length && heap[lChild] > heap[index]){
                swap(heap,lChild,index);
                heapify(heap,lChild,false);
            }
            if (rChild < heap.length && heap[rChild] > heap[index]){
                swap(heap, rChild,index);
                heapify(heap,rChild,false);
            }
        }


    }

    private void swap(int[] heap, int child, int parent) {
        int temp = heap[child];
        heap[child] = heap[parent];
        heap[parent] = temp;
    }


    public static void main(String[] args) {

        MaxHeap heap = new MaxHeap(10);
        heap.insert(10);
        heap.insert(20);
        heap.print();
        heap.insert(15);
        System.out.println(heap.remove());
        heap.insert(30);
        heap.print();
        heap.insert(5);
        heap.print();
        System.out.println(heap.peek());
        System.out.println(heap.remove());
        heap.print();
    }


}
