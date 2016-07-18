package com.littlechoc.leetcode.add_two_numbers;

import com.littlechoc.leetcode.datastructure.ListNode;
import com.littlechoc.leetcode.utils.InputHelper;
import com.littlechoc.leetcode.utils.Printer;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 2. See in <a href="https://leetcode.com/problems/add-two-numbers/">LeetCode</a>
 *
 * @author 周俊皓.
 *         2016-07-11 11:23
 */
public class AddTwoNumbers {

  public static void main(String[] args) {

    List<String> params = new ArrayList<String>();
    params.add("[2,4,3]");
    params.add("[5,6,7]");

    long beginTime = System.currentTimeMillis();

    // put your code here
    ListNode result = new AddTwoNumbers().addTwoNumbers(InputHelper.createLinkedList(params.get(0)), InputHelper.createLinkedList(params.get(1)));

    long endTime = System.currentTimeMillis();

    Printer.printLinkedList(result);
    Printer.printTime(endTime - beginTime);
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int register = 0;
    ListNode node1 = l1;
    ListNode node2 = l2;
    ListNode result = new ListNode(-1);
    ListNode head = result;
    while (node1 != null || node2 != null || register != 0) {
      int val1 = node1 == null ? 0 : node1.val;
      int val2 = node2 == null ? 0 : node2.val;
      int add = register + val1 + val2;

      result.next = new ListNode(add % 10);
      register = add / 10;

      result = result.next;
      node1 = node1 == null ? null : node1.next;
      node2 = node2 == null ? null : node2.next;
    }
    return head.next;
  }
}
