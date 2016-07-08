package com.littlechoc.leetcode.linkedlist.medium;

import com.littlechoc.leetcode.model.ListNode;
import com.littlechoc.leetcode.utils.Printer;
import com.sun.javafx.collections.MappingChange;

import java.util.HashMap;
import java.util.Map;

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
    if (head == null || head.next == null || head.next.next == null) return null;
    ListNode pointer1 = head.next;
    ListNode pointer2 = head.next.next;
    //Step 1
    while (pointer1 != pointer2) {
      if (pointer2.next == null || pointer2.next.next == null) return null;
      pointer1 = pointer1.next;
      pointer2 = pointer2.next.next;
    }
    pointer1 = head;
    //Step 2
    while (pointer1 != pointer2) {
      pointer1 = pointer1.next;
      pointer2 = pointer2.next;
    }
    return pointer1;
  }

}
