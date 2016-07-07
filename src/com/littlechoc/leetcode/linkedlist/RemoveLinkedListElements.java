package com.littlechoc.leetcode.linkedlist;

import com.littlechoc.leetcode.model.ListNode;
import com.littlechoc.leetcode.utils.Printer;

/**
 * 203
 *
 * @author 周俊皓.
 *         2016-07-07 17:13
 */
public class RemoveLinkedListElements {

  public static void main(String[] args) {

    long beginTime = System.currentTimeMillis();

    // put your code here
    new RemoveLinkedListElements().removeElements(null, 0);

    long endTime = System.currentTimeMillis();
    Printer.printTime(endTime - beginTime);
  }

  public ListNode removeElements(ListNode head, int val) {
    if (head == null) {
      return null;
    } else {
      if (head.val == val) {
        return removeElements(head.next, val);
      } else {
        head.next = removeElements(head.next, val);
        return head;
      }
    }
  }

}
