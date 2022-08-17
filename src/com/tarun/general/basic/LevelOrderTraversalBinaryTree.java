package com.tarun.general.basic;

import java.net.Inet4Address;
import java.util.*;

public class LevelOrderTraversalBinaryTree {

    static Scanner sc = null;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Node root; //= createTree();
        root = new Node(5);
        root.left = new Node(1);
        root.right = new Node(7);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.left.right.left = new Node(3);
        root.left.right.right = new Node(6);
        printInOrderTraversal(root);
        printLevelOrder(root, 1);
        System.out.println();
        printLevelOrderTraversalOptimized(root);
        System.out.println();
        printLevelOrderTraversalLevelWise(root);
        System.out.println("====================");
        printLevelOrderTraversalUsingHashmap(root);
        System.out.println("***********Left View Of Binary Tree*******");
        printLeftViewOfBinaryTree(root);
        System.out.println("***********Right View Of Binary Tree*******");
        printRightViewOfBinaryTree(root);
        System.out.println("**********Top View Of Binary Tree*******");
        printTopViewOfBinaryTree(root);
        System.out.println("**********Bottom View Of Binary Tree*******");
        printBottomViewOfBinaryTree(root);
    }
    private static void printInOrderTraversal(Node root) {

        if (root == null) {
            return;
        }
        printInOrderTraversal(root.left);
        System.out.println(root.data);
        printInOrderTraversal(root.right);
    }

    private static void printLevelOrder(Node root, int level) {
        int height = heightOfTree(root);
        while (level <= height) {
            printLevelOrderHelper(root, level++);
        }
    }

    private static void printLevelOrderHelper(Node root, int level) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            System.out.print(root.data + " ");
        } else if (level > 1) {
            printLevelOrderHelper(root.left, level - 1);
            printLevelOrderHelper(root.right, level - 1);
        }

    }

    private static void printLevelOrderTraversalOptimized(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.data + " ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    private static void printLevelOrderTraversalLevelWise(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node == null) {
                if (queue.isEmpty()) {
                    return;
                }
                queue.add(null);
                System.out.println();
                continue;
            }
            System.out.print(node.data + " ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    /**
     * Print level order traversal
     *
     * @param root
     */
    private static void printLevelOrderTraversalUsingHashmap(Node root) {
        Node node = root;
        Map<Integer, Integer[]> levelMap = new LinkedHashMap<>();
        printLevelOrderUsingMapUtil(root, levelMap, 0);
        for (Map.Entry<Integer, Integer[]> entry : levelMap.entrySet()) {
            System.out.print(entry.getValue()[0] + "," + entry.getValue()[1]);
            System.out.println();
        }
    }

    private static void printLevelOrderUsingMapUtil(Node root, Map<Integer, Integer[]> levelMap, int level) {

        if (root == null) return;
        Integer[] value;
        if (levelMap.containsKey(level)) {
            value = levelMap.get(level);
            value[1] = root.data;
        } else {
            value = new Integer[2];
            value[0] = root.data;
        }
        levelMap.put(level, value);
        printLevelOrderUsingMapUtil(root.left, levelMap, level + 1);
        printLevelOrderUsingMapUtil(root.right, levelMap, level + 1);


    }

    private static void printLeftViewOfBinaryTree(Node root) {
        if (root == null) return;
        List<Integer> list = new ArrayList<>();
        generateLeftViewOfBinaryTree(root, list, 0);
        list.forEach(System.out::println);
    }

    private static void generateLeftViewOfBinaryTree(Node root, List<Integer> list, int level) {
        if (root == null) return;
        if (level == list.size()) {
            list.add(root.data);
        }
        generateLeftViewOfBinaryTree(root.left, list, level + 1);
        generateLeftViewOfBinaryTree(root.right, list, level + 1);
    }

    private static void printRightViewOfBinaryTree(Node root) {
        if (root == null) return;
        List<Integer> list = new ArrayList<>();
        generateRightViewOfBinaryTree(root, list, 0);
        list.forEach(System.out::println);
    }

    private static void generateRightViewOfBinaryTree(Node root, List<Integer> list, int level) {
        if (root == null) return;
        if (level == list.size()) {
            list.add(root.data);
        }
        generateRightViewOfBinaryTree(root.right, list, level + 1);
        generateRightViewOfBinaryTree(root.left, list, level + 1);
    }

    private static void printTopViewOfBinaryTree(Node root) {
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        queue.add(new Pair(0, root));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            if (!map.containsKey(pair.hd)) {
                map.put(pair.hd, pair.node.data);
            }
            if (pair.node.right != null) {
                queue.add(new Pair(pair.hd + 1, pair.node.right));
            }
            if (pair.node.left != null) {
                queue.add(new Pair(pair.hd - 1, pair.node.left));
            }
        }

        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(entry.getValue());
        }
        list.forEach(System.out::println);
    }

    private static void printBottomViewOfBinaryTree(Node root) {
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        queue.add(new Pair(0, root));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            map.put(pair.hd, pair.node.data);
            if (pair.node.right != null) {
                queue.add(new Pair(pair.hd + 1, pair.node.right));
            }
            if (pair.node.left != null) {
                queue.add(new Pair(pair.hd - 1, pair.node.left));
            }
        }

        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(entry.getValue());
        }
        list.forEach(System.out::println);
    }

    private static int heightOfTree(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(heightOfTree(root.left), heightOfTree(root.right));
    }

    private static Node createTree() {
        Node root = null;
        System.out.println("Enter data : ");
        int data = sc.nextInt();
        if (data == -1) {
            return null;
        }
        root = new Node(data);

        System.out.println("Enter Left Child For : " + root.data);
        root.left = createTree();
        System.out.println("Enter Right Child For " + root.data);
        root.right = createTree();

        return root;
    }


    private static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    private static class Pair {
        int hd; // horizontal distance
        Node node; // Node at that distance

        public Pair(int hd, Node node) {
            this.hd = hd;
            this.node = node;
        }
    }
}
