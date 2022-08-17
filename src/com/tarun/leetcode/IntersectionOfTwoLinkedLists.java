package com.tarun.leetcode;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedLists {
    // #leetcode - 160

    public static void main(String[] args) {

        ListNode headA = new ListNode(1);
        headA.next = new ListNode(1);
        ListNode intersection = new ListNode(8);
        headA.next.next = intersection;
        ListNode headB = new ListNode(1);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = intersection;
        System.out.println(getIntersectionNode(headA,headB).val);
    }

    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA!= null){
            set.add(headA);
            headA = headA.next;
        }
        while (headB!= null){
            if(set.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
