package com.tarun.general.basic;

public class PalindromeLinkedList {

    public static void main(String[] args) {
        Node head = new Node('A');
        head.next = new Node('B');
        head.next.next = new Node('C');
        head.next.next.next = new Node('C');
        head.next.next.next.next = new Node('B');
        head.next.next.next.next.next = new Node('A');

        System.out.println(checkPalindrome(head,reverseList(findMiddleNode(head))));
    }

    static Node findMiddleNode(Node head){

        Node fastNode = head;
        Node slowNode = head;

        while (fastNode.next != null){
            if (fastNode.next.next != null){
                fastNode = fastNode.next.next;
                slowNode = slowNode.next;
            }else {
                break;
            }
        }
        return slowNode;
    }

    static Node reverseList(Node head){

        Node curr = head;
        Node prev = null;

        while (curr!= null){
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;

    }

    private static boolean checkPalindrome(Node head, Node tail){

        while (tail.next != head){
            if (head.data == tail.data){
                head = head.next;
                tail = tail.next;
            }else {
                return false;
            }
        }

        return true;

    }


    private static class Node{
        char data;
        Node next;

        private Node(char data){
            this.data = data;
        }

    }

}
