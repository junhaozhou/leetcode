package com.littlechoc.leetcode.linkedlist.medium;

import com.littlechoc.leetcode.model.ListNode;
import com.littlechoc.leetcode.utils.Printer;

/**
 * Problem 142. See in <a href="https://leetcode.com/problems/linked-list-cycle-ii/">LeetCode</a>.
 *
 * @author 周俊皓.
 *         2016-07-08 13:50
 */
public class LinkedListCycle2 {

  public static void main(String[] args) {

    long beginTime = System.currentTimeMillis();

    // put your code here


    long endTime = System.currentTimeMillis();
    Printer.printTime(endTime - beginTime);
  }

  public ListNode detectCycle(ListNode head) {
    if (head == null || head.next == null || head.next.next == null) {
      return null;
    }
    ListNode slow = head.next;
    ListNode fast = head.next.next;
    //Step 1: 找到slow和fast相遇的点
    while (slow != fast) {
      if (fast.next == null || fast.next.next == null) {
        return null;
      }
      slow = slow.next;
      fast = fast.next.next;
    }
    //Step 2: 让指针从起点和相遇点同时出发
    slow = head;
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }
    return slow;
  }

}
