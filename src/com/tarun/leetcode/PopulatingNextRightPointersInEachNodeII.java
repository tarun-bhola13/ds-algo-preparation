package com.tarun.leetcode;

import org.w3c.dom.Node;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNodeII {

    public static void main(String[] args) {
        Node root = new Node(1);
        Node result = connect(root);
    }

    private static Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();

        if(root == null){
            return null;
        }
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            Node nextRight = null;
            while (size-- >0) {
                Node node = queue.poll();
                node.right = nextRight;
                nextRight = node;

                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }

            }
        }

        return root;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int val) {
            val = val;
        }

        public Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }
}
