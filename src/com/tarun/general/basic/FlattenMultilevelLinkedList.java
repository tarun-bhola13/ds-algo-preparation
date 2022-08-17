package com.tarun.general.basic;

import org.w3c.dom.Node;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class FlattenMultilevelLinkedList {

    public static void main(String[] args) {

        Node head = new Node(1,new Node(2, new Node(3, new Node(4,new Node(5),
                                new Node(9, new Node(10),
                                        new Node(13,new Node(14),
                                                new Node(16,new Node(17),null)))),null),null),
                new Node(6,new Node(7,new Node(8,null,
                        new Node(12,null,
                                new Node(15))),
                        new Node(11)),null));

//        head = flattenLinkedList(head);
        head = flattenLinkedListOptimized(head);

        while (head != null){
            System.out.print(head.data+ "->");
            head = head.next;
        }
    }

    private static Node flattenLinkedList(Node head) {
        // TC: O(N) SC: O(N)
        if (head == null){
            return null;
        }
        Node curr = head;
        Node nextLink = curr;
        Queue<Node> queue = new LinkedList<>();
            while (curr != null){

                if (curr.next == null){
                    curr.next = queue.poll();
                }
                if (curr.down != null){
                    queue.add(curr.down);
                }
                curr = curr.next;
            }


        return head;
    }

    private static Node flattenLinkedListOptimized(Node head) {
        // TC: O(N) SC: O(1)

        Node curr = head;
        Node last = head;

        while (last != null){

            while (curr.down == null){
                if (curr.next != null) {
                    curr = curr.next;
                }else
                    break;
            }

            if (last.next == null){
                last.next = curr.down;
                curr = curr.next;

            }
            last = last.next;

        }

        return head;


    }

    private static class Node{
        int data;
        Node next;
        Node down;

        public Node(int data) {
            this.data = data;
        }
        public Node(int data, Node next,Node down){
            this.data = data;
            this.next = next;
            this.down = down;
        }

    }
}
