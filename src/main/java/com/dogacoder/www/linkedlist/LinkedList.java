package com.dogacoder.www.linkedlist;

public class LinkedList {
    Node head;

    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void push(int new_data)
    {
        Node temp = new Node(new_data);
        temp.next = head;
        head = temp;
    }

    void printList()
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
}
