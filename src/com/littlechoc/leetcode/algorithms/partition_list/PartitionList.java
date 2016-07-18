package com.littlechoc.leetcode.algorithms.partition_list;

import com.littlechoc.leetcode.datastructure.ListNode;

/**
 * Problem 86. See in <a href="https://leetcode.com/problems/partition-list/">LeetCode</a>
 *
 * @author 周俊皓.
 *         2016-07-11 12:33
 */
public class PartitionList {

  public ListNode partition(ListNode head, int x) {
    ListNode lessHead = new ListNode(-1);
    ListNode lessTail = lessHead;
    ListNode greaterHead = new ListNode(-1);
    ListNode greaterTail = greaterHead;

    while (head != null) {
      if (head.val < x) {
        lessTail.next = head;
        lessTail = lessTail.next;
      } else {
        greaterTail.next = head;
        greaterTail = greaterTail.next;
      }

      head = head.next;
    }
    greaterTail.next = null;
    lessTail.next = greaterHead.next;

    return lessHead.next;
  }
}
