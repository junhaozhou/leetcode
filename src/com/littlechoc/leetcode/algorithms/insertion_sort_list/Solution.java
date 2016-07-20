package com.littlechoc.leetcode.algorithms.insertion_sort_list;

import com.littlechoc.leetcode.datastructure.ListNode;

/**
 * Problem 147. See in <a href="https://leetcode.com/problems/insertion-sort-list/">LeetCode</a>
 *
 * @author 周俊皓.
 *         2016-07-20 14:28
 */
public class Solution {

  public ListNode insertionSortList(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode node = head;
    while (node.next != null) {
      if (node.next.val < node.val) {
        ListNode insertionPoint = new ListNode(-1);
        insertionPoint.next = head;
        while (insertionPoint.next.val < node.next.val) {
          insertionPoint = insertionPoint.next;
        }
        ListNode temp = node.next;
        node.next = temp.next;
        temp.next = insertionPoint.next;
        insertionPoint.next = temp;

        if (temp.next == head) {
          head = temp;
        }
      } else {
        node = node.next;
      }
    }
    return head;
  }
}
