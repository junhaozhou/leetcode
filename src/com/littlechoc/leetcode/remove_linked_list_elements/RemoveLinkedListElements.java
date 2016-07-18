package com.littlechoc.leetcode.remove_linked_list_elements;

import com.littlechoc.leetcode.datastructure.ListNode;
import com.littlechoc.leetcode.utils.Printer;

/**
 * Problem 203. Open in <a href="https://leetcode.com/problems/remove-linked-list-elements/">LeetCode</a>.
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
