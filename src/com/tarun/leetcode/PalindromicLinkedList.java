package com.tarun.leetcode;

public class PalindromicLinkedList {
    // #leetcode - 234
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1))));
        System.out.println(isPalindrome(head));

    }

    private static boolean isPalindrome(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while (fastPointer.next != null && fastPointer.next.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        ListNode curr = slowPointer;
        ListNode tail = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = tail;
            tail = curr;
            curr = temp;
        }
        while (head.next != null && tail.next != null){
            if(tail.val == head.val){
                tail = tail.next;
                head = head.next;
            }else{
                return false;
            }
        }

        return head.val == tail.val;
    }


    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
