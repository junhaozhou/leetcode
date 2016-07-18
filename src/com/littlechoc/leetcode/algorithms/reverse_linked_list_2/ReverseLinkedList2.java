package com.littlechoc.leetcode.algorithms.reverse_linked_list_2;

import com.littlechoc.leetcode.datastructure.ListNode;
import com.littlechoc.leetcode.utils.Printer;

/**
 * Problem 92. See in <a href="https://leetcode.com/problems/reverse-linked-list-ii/">LeetCode</a>
 *
 * @author 周俊皓.
 *         2016-07-09 17:23
 */
public class ReverseLinkedList2 {

  public static void main(String[] args) {

    ListNode node = new ListNode(-1);
    ListNode head = node;
    for (int i = 1; i <= 5; i++) {
      node.next = new ListNode(i);
      node = node.next;
    }

    long beginTime = System.currentTimeMillis();

    // put your code here
    new ReverseLinkedList2().reverseBetween(head.next, 3, 4);

    long endTime = System.currentTimeMillis();
    Printer.printTime(endTime - beginTime);

    node = head.next;
    while (node != null) {
      System.out.printf(" " + node.val);
      node = node.next;
    }
  }

  public ListNode reverseBetween(ListNode head, int m, int n) {
    int index = 1;
    ListNode begin = new ListNode(-1);
    begin.next = head;
    ListNode end = head;
    ListNode node = head;
    while (node != null) {
      if (index == m - 1) {
        begin = node;
      }
      if (index == m) {
        end = node;
      }
      if (index > m && index <= n) {
        end.next = node.next;
        node.next = begin.next;
        begin.next = node;
      }
      if (index == n) {
        break;
      }
      index++;
      if (index <= m) {
        node = node.next;
      } else {
        node = end.next;
      }
    }

    return m == 1 ? begin.next : head;
  }
}
