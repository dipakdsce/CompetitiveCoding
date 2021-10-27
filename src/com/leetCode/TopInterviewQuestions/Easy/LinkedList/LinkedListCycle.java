package com.leetCode.TopInterviewQuestions.Easy.LinkedList;

import com.utilsDataStructures.ListNode;

public class LinkedListCycle {
    public static boolean isCycle(ListNode listNode) {
        ListNode slow = listNode;
        ListNode fast = listNode;
        if(slow == null || slow.next == null) {
            return false;
        }
        while(slow != null && fast != null ) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = listNode;
        System.out.println(isCycle(listNode));
    }
}
