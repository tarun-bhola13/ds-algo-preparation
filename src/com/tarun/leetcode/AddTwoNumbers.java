package com.tarun.leetcode;

public class AddTwoNumbers {
    // #leetcode 2
    public static void main(String[] args) {
//        ListNode node1 = new ListNode(2, new ListNode(4,new ListNode(3)));
//        ListNode node2 = new ListNode(5, new ListNode(6,new ListNode(4)));
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(0);

        ListNode node3 = addTwoNumbers(node1, node2);
    }

    private static ListNode addTwoNumbers(ListNode node1, ListNode node2) {

        int carry = 0;
        int value = 0;
        String number = "";
        while (node1 != null && node2 != null){
            value = node1.val + node2.val + carry;
            if(value >= 10){
                value = value - 10;
                carry = 1;
            }else{
                carry = 0;
            }
            node1 = node1.next;
            node2 = node2.next;
            number = number + value;
        }
        while (node1!= null){
            value = node1.val + carry;
            node1 = node1.next;
            if(value >= 10){
                value = value - 10;
                carry = 1;
            }else{
                carry = 0;
            }
            number = number + value;

        }
        while (node2 != null){
            value = node2.val + carry;
            node2 = node2.next;
            if(value >= 10){
                value = value - 10;
                carry = 1;
            }else{
                carry = 0;
            }
            number = number + value;
        }

        if(carry == 1){
            number = number + carry;
        }
        ListNode root = null;
        ListNode node3 = null;
        for(int i = 0 ; i < number.length() ;i++){
            if(node3 == null){
                node3 = new ListNode(number.charAt(i) - 48);
                root = node3;
            }else{
                node3.next = new ListNode(number.charAt(i)-48);
                node3 = node3.next;
            }
        }
        return root;
    }

    // Definition for singly-linked list.
     public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

}
