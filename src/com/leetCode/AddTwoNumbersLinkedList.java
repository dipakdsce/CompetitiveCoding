package com.leetCode;

import com.leetCode.helper.ListNode;

import java.util.List;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbersLinkedList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
//        l1.next.next.next = null;

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
//        l2.next.next = new ListNode(4);
//        l2.next.next.next = null;

        ListNode res = addTwoNumbers(l1, l2);

    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = null;
        ListNode prev = null;
        ListNode temp = null;
        int carry = 0;
        while (l1 != null || l2!=null) {
            int sum = carry + (l1!=null ? l1.val : 0) + (l2!=null ? l2.val : 0);

            carry = sum >= 10 ? 1 : 0;
            sum = sum % 10;
            temp = new ListNode(sum);
            if(res == null) {
                res = temp;
            } else {
                prev.next =temp;
            }
            prev = temp;

            if (l1 != null) {
                l1 = l1.next;
            }

            if(l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            temp.next = new ListNode(carry);
        }
        return res;
    }
}
