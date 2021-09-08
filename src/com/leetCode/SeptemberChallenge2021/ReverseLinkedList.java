package com.leetCode.SeptemberChallenge2021;

import com.utilsDataStructures.ListNode;

public class ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode cur = head, next = head;
        ListNode prev = null;
        while (cur != null) {
            next = cur;
            cur = cur.next;
            next.next = prev;
            prev = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode reverseHead = reverseList(head);
        ListNode cur = reverseHead;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }
}
