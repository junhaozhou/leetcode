package com.littlechoc.leetcode.algorithms.odd_even_linked_list;

import com.littlechoc.leetcode.datastructure.ListNode;
import com.littlechoc.leetcode.utils.InputHelper;
import com.littlechoc.leetcode.utils.Printer;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 328. See in <a href="https://leetcode.com/problems/odd-even-linked-list/">LeetCode</a>
 *
 * @author 周俊皓.
 *         2016-07-11 09:57
 */
public class OddEvenLinkedList {

  public static void main(String[] args) {

    List<String> param = new ArrayList<String>();
    param.add("[]");

    long beginTime = System.currentTimeMillis();

    // put your code here
    ListNode result = new OddEvenLinkedList().oddEvenList(InputHelper.createLinkedList(param.get(0)));

    long endTime = System.currentTimeMillis();

    Printer.printLinkedList(result);
    Printer.printTime(endTime - beginTime);
  }

  public ListNode oddEvenList(ListNode head) {

    ListNode oddHead = new ListNode(-1);
    ListNode evenHead = new ListNode(-1);
    ListNode oddNode = oddHead;
    ListNode evenNode = evenHead;
    ListNode node = head;
    int index = 1;

    while (node != null) {
      if (index % 2 == 0) {
        evenNode.next = node;
        evenNode = evenNode.next;
      } else {
        oddNode.next = node;
        oddNode = oddNode.next;
      }

      index++;
      node = node.next;
    }
    oddNode.next = evenHead.next;
    evenNode.next = null;

    return oddHead.next;
  }

}
