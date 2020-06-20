package com.dogacoder.www.educative.linkedlist;

public class DoublyLinkedList<T> {

    Node head;
    Node tail;
    int size;
    class Node<T> {
        T val;
        Node previous;
        Node next;

        public Node(T val) {
            this.val = val;
            this.next = null;
            this.previous = null;
        }
    }

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null && tail == null;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getSize() {
        return size;
    }

    public void  insertAtHead(T val) {
        if (isEmpty()) {
            head = new Node(val);
            tail = head;
        } else {
            Node temp = new Node(val);
            temp.next = head;
            temp.previous = null;
            head.previous = temp;
            head = temp;
        }
        size++;
    }
}
