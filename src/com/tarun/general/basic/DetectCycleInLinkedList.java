package com.tarun.general.basic;

import org.w3c.dom.Node;

public class DetectCycleInLinkedList {


    public static void main(String[] args) {

        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
//        head.next.next.next.next = new Node(50);
        head.next.next.next.next = head.next;

//        System.out.println(detectCycle(head));
        System.out.println(findCyclePoint(head));

    }

    private static Node detectCycle(Node head) {

        Node fastPointer = head;
        Node slowPointer = head;

        while (fastPointer != null && fastPointer.next != null){
//            if (fastPointer.next.next != null) {
                fastPointer = fastPointer.next.next;
                slowPointer = slowPointer.next;
//            }
            if (slowPointer == fastPointer){
                return slowPointer;
            }
        }

        return null;
    }

    static Node findCyclePoint(Node head){
        Node meetingNode = detectCycle(head);
        Node curr = head;
        while (meetingNode != null){
            if (curr == meetingNode){
                return curr;
            }
            curr = curr.next;
            meetingNode = meetingNode.next;

        }
        return null;
    }

    private static class Node{
        int data;
        Node next;

        private Node(int data){
            this.data = data;
        }
    }
}
