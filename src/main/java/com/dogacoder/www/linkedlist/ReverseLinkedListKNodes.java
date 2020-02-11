package com.dogacoder.www.linkedlist;

import org.junit.Test;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;

/**
 *
 */
public class ReverseLinkedListKNodes {

    public LinkedList.Node reverse(LinkedList.Node node, int k) {
        LinkedList.Node prev = null;
        LinkedList.Node current = node;
        LinkedList.Node next = null;
        int count = 1;
        while (current != null && count <= k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
        if (next != null) {
            node.next = reverse(next, k);
        }
        return prev;
    }

    @Test
    public void testReverseKNodes() {
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

        llist.head = reverse(llist.head, 3);

        System.out.println("Reversed list");
        llist.printList();
    }
}
