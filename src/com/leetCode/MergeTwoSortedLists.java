package com.leetCode;

import com.utilsDataStructures.ListNode;


public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        l1 = null;
        /*l1.val = 1;
        ListNode l2 = new ListNode();
        l2.val = 2;
        l1.next = l2;
        ListNode l3 = new ListNode(4, null);
        l2.next = l3;*/

        ListNode l4 = new ListNode();
        l4.val = 0;
        l4.next = null;
        /*ListNode l5 = new ListNode();
        l5.val = 3;
        l4.next = l5;
        ListNode l6 = new ListNode(4, null);
        l5.next = l6;*/

        ListNode mergedList = getMergedList(l1, l4);
        while (mergedList != null) {
            System.out.println(mergedList.val);
            mergedList = mergedList.next;
        }
    }

    public static ListNode getMergedList(ListNode l1, ListNode l2) {
        ListNode mergedList = new ListNode();
        ListNode curr;
        if(l1 == null) {
            return  l2;
        }
        if(l2 ==  null) {
            return  l1;
        }

        if(l1.val <= l2.val) {
            mergedList = l1;
            curr = mergedList;
            l1 = l1.next;
        } else {
            mergedList = l2;
            curr = mergedList;
            l2 = l2.next;
        }
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                curr.next = l1;
                curr = curr.next;
                l1 = l1.next;
            } else  {
                curr.next = l2;
                curr = curr.next;
                l2 = l2.next;
            }
        }
        if(l1 != null) {
            curr.next = l1;
        }
        if(l2 != null) {
            curr.next = l2;
        }
        return mergedList;
    }
}
