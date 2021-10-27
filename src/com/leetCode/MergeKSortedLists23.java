package com.leetCode;

import com.utilsDataStructures.ListNode;

import java.util.HashSet;
import java.util.List;

/*
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.



Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []


Constraints:

k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] is sorted in ascending order.
The sum of lists[i].length won't exceed 10^4.
 */
public class MergeKSortedLists23 {
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode res = null ,curr = null;
        int minIndex = 0;
        int nullCount = 0;
        HashSet<Integer> isChecked = new HashSet<>();
        do {
            int curMin = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && lists[i].val <= curMin) {
                    minIndex = i;
                    curMin = lists[minIndex].val;
                } else if (lists[i] == null && !isChecked.contains(i)) {
                    nullCount++;
                    isChecked.add(i);
                }
            }
            if(nullCount < lists.length) {
                if(res == null) {
                    curr = lists[minIndex];
                    res = curr;
                } else {
                    curr.next = lists[minIndex];
                    curr = curr.next;
                }
                lists[minIndex] = lists[minIndex].next;
            }
        } while (nullCount < lists.length);
        return res;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(5);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);

        ListNode head3 = new ListNode(2);
        head3.next = new ListNode(6);

        ListNode[] listNodes = {head1, head2, head3};
        ListNode res = mergeKLists(listNodes);
        while(res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
