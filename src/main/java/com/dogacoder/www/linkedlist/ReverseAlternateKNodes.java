package com.dogacoder.www.linkedlist;


import org.junit.Test;

/**
 *
 Reverse alternate K nodes in a Singly Linked List

 Given a linked list, write a function to reverse every alternate k nodes (where k is an input to the function) in an efficient way. Give the complexity of your algorithm.

 Example:

 Inputs:   1->2->3->4->5->6->7->8->9->NULL and k = 3
 Output:   3->2->1->4->5->6->9->8->7->NULL.

 */
public class ReverseAlternateKNodes {

    public LinkedList.Node reverse(LinkedList.Node head, int k) {
        return reverseAlternate(head, k, true);
    }

    private LinkedList.Node reverseAlternate(LinkedList.Node head, int k, boolean allowed) {
        LinkedList.Node current = head;
        LinkedList.Node next = null;
        LinkedList.Node prev = null;

        int count = 0;
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        count = 0;
        while (count < k && current != null) {
            head.next = next;
            head = next;
            next = next.next;
            current = next;
            count++;
        }

        if (current != null) {
            head.next = reverseAlternate(next, k, !allowed);
        }
        return prev;
    }


    LinkedList.Node _kAltReverse(LinkedList.Node node, int k, boolean b) {
        if (node == null) {
            return null;
        }

        int count = 1;
        LinkedList.Node prev = null;
        LinkedList.Node current = node;
        LinkedList.Node next = null;

        /* The loop serves two purposes
         1) If b is true, then it reverses the k nodes
         2) If b is false, then it moves the current pointer */
        while (current != null && count <= k) {
            next = current.next;

            /* Reverse the nodes only if b is true*/
            if (b == true) {
                current.next = prev;
            }

            prev = current;
            current = next;
            count++;
        }

        /* 3) If b is true, then node is the kth node.
         So attach rest of the list after node.
         4) After attaching, return the new head */
        if (b == true) {
            node.next = _kAltReverse(current, k, !b);
            return prev;
        } /* If b is not true, then attach rest of the list after prev.
         So attach rest of the list after prev */ else {
            prev.next = _kAltReverse(current, k, !b);
            return node;
        }
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
