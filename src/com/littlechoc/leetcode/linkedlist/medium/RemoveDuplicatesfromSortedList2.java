package com.littlechoc.leetcode.linkedlist.medium;

import com.littlechoc.leetcode.model.ListNode;
import com.littlechoc.leetcode.utils.InputHelper;
import com.littlechoc.leetcode.utils.Printer;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 82. See in <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/">LeetCode</a>
 *
 * @author 周俊皓.
 *         2016-07-11 12:14
 */
public class RemoveDuplicatesfromSortedList2 {

  public static void main(String[] args) {

    List<String> params = new ArrayList<String>();
    params.add("[1,1,2]");

    long beginTime = System.currentTimeMillis();

    // put your code here
    ListNode result = new RemoveDuplicatesfromSortedList2().deleteDuplicates(InputHelper.createLinkedList(params.get(0)));

    long endTime = System.currentTimeMillis();

    Printer.printLinkedList(result);
    Printer.printTime(endTime - beginTime);
  }

  public ListNode deleteDuplicates(ListNode head) {
    ListNode node = new ListNode(-1);
    ListNode result = node;

    int lastVal = head != null ? head.val - 1 : 0;
    while (head != null) {
      if (head.val == lastVal) {
        head = head.next;
        continue;
      }
      lastVal = head.val;
      if (head.next == null || head.next.val != lastVal) {
        node.next = new ListNode(lastVal);
        node = node.next;
      }

      head = head.next;
    }

    return result.next;
  }

}
