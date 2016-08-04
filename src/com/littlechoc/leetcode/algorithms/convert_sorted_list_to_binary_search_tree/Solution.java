package com.littlechoc.leetcode.algorithms.convert_sorted_list_to_binary_search_tree;

import com.littlechoc.leetcode.datastructure.ListNode;
import com.littlechoc.leetcode.datastructure.TreeNode;

/**
 * Problem 109. See in <a href="https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/">LeetCode</a>
 *
 * @author 周俊皓.
 *         2016-07-21 10:53
 */
public class Solution {

  public TreeNode sortedListToBST(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode middle = head;
    ListNode tail = head.next;
    ListNode pre = null;
    if (tail == null) {
      return new TreeNode(head.val);
    }
    while (tail.next != null && tail.next.next != null) {
      pre = middle;
      middle = middle.next;
      tail = tail.next.next;
    }
    if (tail.next != null) {
      pre = middle;
      middle = middle.next;
    }
    TreeNode treeNode = new TreeNode(middle.val);
    if (pre != null) {
      pre.next = null;
      treeNode.left = sortedListToBST(head);
    }
    treeNode.right = sortedListToBST(middle.next);

    return treeNode;
  }
}
