package com.leetCode.TopInterviewQuestions.Easy.LinkedList;

import com.utilsDataStructures.ListNode;

/*
Given the head of a singly linked list, return true if it is a palindrome.



Example 1:


Input: head = [1,2,2,1]
Output: true
Example 2:


Input: head = [1,2]
Output: false


Constraints:

The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9


Follow up: Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {

    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode cur = slow;
        ListNode prev = null;
        ListNode next ;
        while(cur != null) {
            next = cur;
            cur = cur.next;
            next.next = prev;
            prev = next;
        }
        while(prev != null) {
            if(head.val == prev.val) {
                head = head.next;
                prev = prev.next;
            } else {
                return false;
            }
        }
        if(head == null || head.next == null) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(listNode));
    }
}
