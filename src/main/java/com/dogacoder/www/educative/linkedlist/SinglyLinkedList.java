package com.dogacoder.www.educative.linkedlist;

public class SinglyLinkedList<T> {

    class Node<T> {
        T val;
        Node next;

        public Node(T val) {
            this.val = val;
            this.next = null;
        }
    }

    Node head;
    int size;

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insertAtHead(T val) {
        Node<T> node = new Node<>(val);
        node.val = val;
        node.next = head;
        head = node;
        size++;
    }

    public void insertAtEnd(T val) {
        if (head == null) {
            head = new Node(val);
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            Node newNode = new Node(val);
            temp.next = newNode;
        }
        size++;
    }

    public void insertAfter(T data, T val) {
        if (head == null) {
            System.out.println("input is not present in list");
        } else {
            Node<T> temp = head;
            while (temp != null && !temp.val.equals(val)) {
                temp = temp.next;
            }
            if (temp != null) {
                Node<T> newNode = new Node<>(data);
                newNode.next = temp.next;
                temp.next = newNode;
                size++;
            }
        }
    }

    public boolean search(T val) {
        Node temp = head;
        while (temp != null) {
            if (temp.val.equals(val)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void deleteAtHead() {
        if (!isEmpty()) {
            head = head.next;
            size--;
        }
    }

    public void deleteByValue(T val) {
        if (isEmpty()) {
            return;
        }
        Node temp = head;
        Node prev = head;
        while (temp != null && !temp.val.equals(val)) {
            prev = temp;
            temp = temp.next;
        }
        if (temp != null) {
            prev.next = temp.next;
            size--;
        } else {
            System.out.println("Not found");
        }

    }

    public void print() {
        if (head == null) {
            System.out.println("list is null");
        } else {
            Node temp = head;
            while (temp.next != null) {
                System.out.println(temp.val);
                temp = temp.next;
            }
        }
    }
}
