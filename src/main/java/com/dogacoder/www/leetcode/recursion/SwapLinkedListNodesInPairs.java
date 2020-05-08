package com.dogacoder.www.leetcode.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SwapLinkedListNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        return swapRecur(head);
    }

    private ListNode swapRecur(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode t1 = head.next;
        ListNode t2 = head.next.next;

        head.next.next = head;
        head.next = swapRecur(t2);
        return t1;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        assertTrue(swapPairs(head).val == 2);
    }
}
