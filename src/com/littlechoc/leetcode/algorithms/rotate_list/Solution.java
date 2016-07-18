package com.littlechoc.leetcode.algorithms.rotate_list;

import com.littlechoc.leetcode.datastructure.ListNode;

/**
 * Problem 61. See in <a href="https://leetcode.com/problems/rotate-list/">LeetCode</a>
 *
 * @author 周俊皓.
 *         2016-07-18 10:53
 */
public class Solution {

  public ListNode rotateRight(ListNode head, int k) {

    if (head == null) {
      return null;
    }

    ListNode begin = head;
    ListNode end = head;
    int length = 0;
    boolean isLengthConfirmed = false;
    for (int i = 0; i < k; ++i) {
      if (!isLengthConfirmed) {
        length++;
      }
      if (end.next == null) {
        end = head;
        isLengthConfirmed = true;
        i = -1;
        k = k % length;
      } else {
        end = end.next;
      }
    }
    while (end.next != null) {
      end = end.next;
      begin = begin.next;
    }
    end.next = head;
    head = begin.next == null ? head : begin.next;
    begin.next = null;

    return head;
  }
}
