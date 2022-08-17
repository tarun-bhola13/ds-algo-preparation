package com.tarun.general.basic;


public class DuplicateLinkedListWithRandomPointer {

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next;
        head.next.next.next.random = head.next;
        head.next.next.next.next.random = head.next.next.next;

//        duplicateLinkedList(head);
        printNewList(head);
        System.out.println("------------------------");
        printNewList(duplicateLinkedList(head));

    }

    private static void printNewList(Node head) {
        Node curr = head;
        while (curr != null){
            System.out.print("Node data : "+curr.data + " random pointer : "+ curr.random.data );
            curr = curr.next;
            System.out.println();
        }

    }

    private static Node duplicateLinkedList(Node head) {

        Node curr = head;
        while (curr != null) {
            Node temp = curr.next;
            Node duplicateNode = new Node(curr.data);
            curr.next = duplicateNode;
            duplicateNode.next = temp;
            curr = temp;
        }

        curr = head;
        while (curr != null) {

            curr.next.random = curr.random.next;
            curr = curr.next.next;
        }

        Node duplicateHead = head.next;
        curr = head;
        Node newCurr = duplicateHead;
        while (curr != null) {

            curr.next = curr.next.next;
            if (newCurr.next != null) {
                newCurr.next = curr.next.next;
            }
            curr = curr.next;
            newCurr = newCurr.next;
        }

        return duplicateHead;
    }

    private static class Node {
        int data;
        Node next;
        Node random;

        private Node(int data) {
            this.data = data;
        }
    }
}
