package com.littlechoc.leetcode.algorithms.sum_root_to_leaf_numbers;

import com.littlechoc.leetcode.datastructure.TreeNode;

/**
 * Problem 129. See in <a href="https://leetcode.com/problems/sum-root-to-leaf-numbers/">LeetCode</a>
 *
 * @author 周俊皓.
 *         2016-07-21 10:31
 */
public class Solution {

  private int result = 0;

  public int sumNumbers(TreeNode root) {
    if (root == null) {
      return 0;
    }
    if (root.left == null && root.right == null) {
      return root.val;
    }
    sum(root.left, root.val);
    sum(root.right, root.val);
    return result;
  }

  private void sum(TreeNode root, int sum) {
    if (root == null) {
      return;
    }
    sum = 10 * sum + root.val;
    if (root.right == null && root.left == null) {
      result += sum;
      return;
    }
    sum(root.left, sum);
    sum(root.right, sum);
  }
}
