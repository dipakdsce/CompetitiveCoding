package com.leetCode.TopInterviewQuestions.Easy.LinkedList;

import com.utilsDataStructures.ListNode;


public class MergedTwoSortedLinkedList {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res;
        if (l1.val < l2.val) {
            res = l1;
            l1 = l1.next;
        } else {
            res = l2;
            l2 = l2.next;
        }

        ListNode head = res;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                res.next = l1;
                res = res.next;
                l1 = l1.next;
            } else {
                res.next = l2;
                res = res.next;
                l2 = l2.next;
            }
        }

        if (l1 != null) {
            res.next = l1;
        }

        if (l2 != null) {
            res.next = l2;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode mergedList = mergeTwoLists(l1, l2);
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
    }
}
