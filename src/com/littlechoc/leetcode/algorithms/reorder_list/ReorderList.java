package com.littlechoc.leetcode.algorithms.reorder_list;

import com.littlechoc.leetcode.datastructure.ListNode;

/**
 * Problem 143. See in <a herf="https://leetcode.com/problems/reorder-list/">LeetCode</a>
 *
 * @author 周俊皓.
 *         2016-07-14 11:33
 */
public class ReorderList {

  private ListNode start;

  public void reorderList(ListNode head) {

    // 1. find the middle point
    if (head == null || head.next == null || head.next.next == null) return;

    ListNode middle = head, end = head;

    while (end.next != null) {
      // a1 step = 1
      middle = middle.next;
      // a2 step = 2
      end = end.next;
      if (end.next == null) break;
      else end = end.next;
    }
    // middle now points to middle, end points to last node

    // 2. reverse the second half of the list
    this.reverseList(middle);

    // 3. merge two lists
    ListNode p = head, t1 = head, t2 = head;
    while (end != middle) { // start from both side of the list. when a1, a2 meet, the merge finishes.
      t1 = p;
      t2 = end;
      p = p.next;
      end = end.next;

      t2.next = t1.next;
      t1.next = t2;
    }
  }

  // use recursion to reverse the right part of the list
  private ListNode reverseList(ListNode head) {
    ListNode reverse = null;
    ListNode next;
    while (head != null) {
      next = head.next;
      head.next = reverse;
      reverse = head;
      head = next;
    }
    return reverse;
  }

}
