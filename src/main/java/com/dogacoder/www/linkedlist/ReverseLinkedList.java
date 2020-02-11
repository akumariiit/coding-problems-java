package com.dogacoder.www.linkedlist;

import org.junit.Test;

/**
 * Given pointer to the head node of a linked list, the task is to reverse the linked list. We need to reverse the list by changing links between nodes.
 *
 * Examples:
 *
 *     Input: Head of following linked list
 *     1->2->3->4->NULL
 *     Output: Linked list should be changed to,
 *     4->3->2->1->NULL
 *
 *     Input: Head of following linked list
 *     1->2->3->4->5->NULL
 *     Output: Linked list should be changed to,
 *     5->4->3->2->1->NULL
 *
 *     Input: NULL
 *     Output: NULL
 *
 *     Input: 1->NULL
 *     Output: 1->NULL
 */
public class ReverseLinkedList {

    public LinkedList.Node reverse(LinkedList.Node node) {

        LinkedList.Node prev = null;
        LinkedList.Node current = node;
        LinkedList.Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    @Test
    public void testReverse() {
        LinkedList llist = new LinkedList();

        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        llist.push(9);
        llist.push(8);
        llist.push(7);
        llist.push(6);
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        System.out.println("Given Linked List");
        llist.printList();

        llist.head = reverse(llist.head);

        System.out.println("Reversed list");
        llist.printList();
    }
}
