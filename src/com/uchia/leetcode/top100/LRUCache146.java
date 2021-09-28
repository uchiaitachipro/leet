package com.uchia.leetcode.top100;

import java.util.HashMap;
import java.util.Map;

public class LRUCache146 {
    private Map<Integer, Node> map = new HashMap<>();
    private DoubleList list = new DoubleList();
    private int capacity;
    private int count;

    // amazon microsoft facebook bytedance
    public LRUCache146(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            updateRecently(key, node.value);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            updateRecently(key, value);
            return;
        }

        if (count < capacity) {
            addNormally(key, value);
        } else {
            while (count >= capacity) {
                removeEarly();
            }
            addNormally(key, value);
        }
    }

    private void addNormally(int key, int value) {
        Node node = list.addLast(key, value);
        map.put(key, node);
        count++;
    }

    private void updateRecently(int key, int value) {
        Node node = map.getOrDefault(key, null);
        if (node == null) {
            return;
        }

        map.remove(node);
        list.remove(node);
        Node newNode = list.addLast(key, value);
        map.put(key, newNode);
    }

    private void removeEarly() {
        Node head = list.getHead();
        if (head != null) {
            list.removeFirst();
            map.remove(head.key);
        }
        count--;
    }


    static final class DoubleList {
        private Node head;
        private Node tail;


        public Node addLast(int key, int value) {
            Node node = new Node();
            node.value = value;
            node.key = key;

            if (head == tail && head == null) {
                tail = head = node;
                return node;
            }

            tail.next = node;
            node.prev = tail;
            tail = node;

            return node;
        }

        public void removeFirst() {
            if (head == null) {
                return;
            }

            if (head == tail) {
                head = tail = null;
                return;
            }

            Node next = head.next;
            head.next = null;
            next.prev = null;

            head = next;
        }

        public void remove(Node node) {
            if (node == null) {
                return;
            }

            if (head == tail && node == head) {
                tail = head = null;
                return;
            }

            Node prev = node.prev;
            Node next = node.next;

            if (prev != null) {
                prev.next = next;
            } else {
                if (head == node) {
                    head = next;
                    head.prev = null;
                }
            }

            if (next != null) {
                next.prev = prev;
            } else {
                if (tail == node) {
                    tail = prev;
                    tail.next = null;
                }
            }
            node.prev = node.next = null;
        }

        public Node getHead() {
            return head;
        }
    }

    static final class Node {
        public Node prev;
        public Node next;
        public int value;
        public int key;
    }

    public static void main(String[] args) {
        DoubleList doubleList = new DoubleList();
        Node n1 = doubleList.addLast(-1, 1);
        Node n2 = doubleList.addLast(-2, 2);
        Node n3 = doubleList.addLast(-3, 3);
        Node n4 = doubleList.addLast(-4, 4);
        printDoubleList(doubleList);

        doubleList.remove(n2);
        printDoubleList(doubleList);

        doubleList.remove(n1);
        printDoubleList(doubleList);

        doubleList.remove(n4);
        printDoubleList(doubleList);

        doubleList.remove(n3);
        printDoubleList(doubleList);
    }

    private static void printDoubleList(DoubleList list) {
        Node n = list.head;
        StringBuilder sb = new StringBuilder();
        while (n != null) {
            sb.append(n.value).append("->");
            n = n.next;
        }
        System.out.println("list: " + sb.toString());
    }
}
