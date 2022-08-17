package com.tarun.general;

public class LinkedList {

    // reverse a linked list
    //1->2->3->4->5
    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);

        Node reversed = reverseListRecursively(node,null);


        while (reversed != null){

            System.out.print(reversed.data+ " ->");
            reversed = reversed.next;
        }
        System.out.print("null");




    }

    private static Node reverseList(Node head) {
    // iteratively
        Node curr = head;
        Node prev = null;

        while (curr != null){
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;

        }

        return prev;
    }

    private static Node reverseListRecursively(Node head, Node prev) {
        // iteratively

        if (head == null){
            return prev;
        }
        Node temp = head.next;
        head.next = prev;
        prev = head;
        return reverseListRecursively(temp,prev);
    }


    private static class Node{
        int data;
        Node next;

        private Node(int data) {
            this.data = data;
        }
    }
}
