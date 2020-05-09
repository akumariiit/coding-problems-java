package com.dogacoder.www.leetcode.recursion;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * https://leetcode.com/explore/featured/card/recursion-i/251/scenario-i-recurrence-relation/2378/
 * Reverse a singly linked list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 *
 * Follow up:
 *
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 *
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nxt = head.next;
        ListNode curr = head;

        ListNode listNode = reverseList(null, curr, nxt);
        return listNode;
    }

    private ListNode reverseList(ListNode prev, ListNode curr, ListNode nxt) {
        if (null == nxt) {
            curr.next = prev;
            return curr;
        }
        ListNode tmp = nxt.next;
        curr.next = prev;
        prev = curr;
        curr = nxt;
        nxt = tmp;
        return reverseList(prev, curr, nxt);
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode listNode = reverseList(head);
        assertTrue(listNode.val == 3);
        ListNode temp = listNode;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        assertTrue(count == 3);
        ListNode.print(listNode);
    }
}
