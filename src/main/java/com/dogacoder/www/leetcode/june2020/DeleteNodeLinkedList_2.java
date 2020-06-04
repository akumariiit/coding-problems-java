package com.dogacoder.www.leetcode.june2020;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3348/
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 *
 * Given linked list -- head = [4,5,1,9], which looks like following:
 *
 *
 *
 * Example 1:
 *
 * Input: head = [4,5,1,9], node = 5
 * Output: [4,1,9]
 * Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
 *
 * Example 2:
 *
 * Input: head = [4,5,1,9], node = 1
 * Output: [4,5,9]
 * Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
 *
 *
 *
 * Note:
 *
 *     The linked list will have at least two elements.
 *     All of the nodes' values will be unique.
 *     The given node will not be the tail and it will always be a valid node of the linked list.
 *     Do not return anything from your function.
 *
 */
public class DeleteNodeLinkedList_2 {

    public void deleteNode(ListNode node) {
        if (node.next != null) {
            while (node.next != null) {
                node.val = node.next.val;
                if (node.next.next == null) {
                    node.next = null;
                }
                else {
                    node = node.next;
                }
            }
            node = null;
        }
    }

    @Test
    public void test() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);

        deleteNode(node);
        assertEquals(node.val, 2);
    }
}
