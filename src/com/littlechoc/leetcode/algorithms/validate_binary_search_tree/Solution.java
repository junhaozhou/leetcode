package com.littlechoc.leetcode.algorithms.validate_binary_search_tree;

import com.littlechoc.leetcode.datastructure.TreeNode;

/**
 * Problem 98. See in <a href="https://leetcode.com/problems/validate-binary-search-tree/">LeetCode</a>
 *
 * @author 周俊皓.
 *         2016-07-18 17:16
 */
public class Solution {

  public boolean isValidBST(TreeNode root) {
    if (root == null) {
      return true;
    }
    if (root.left == null && root.right == null) {
      return true;
    }
    if (root.left != null && root.val <= root.left.val) {
      return false;
    }
    if (root.right != null && root.val >= root.right.val) {
      return false;
    }
    return checkLeft(root.left, Long.MIN_VALUE, root.val) && checkRight(root.right, root.val, Long.MAX_VALUE);
  }

  private boolean checkLeft(TreeNode root, long min, long max) {
    if (root == null) {
      return true;
    }
    if (root.right == null && root.left == null) {
      return root.val < max;
    }
    if (root.left != null && (root.left.val >= root.val || root.left.val <= min)) {
      return false;
    }
    if (root.right != null && (root.right.val <= root.val || root.right.val >= max)) {
      return false;
    }
    return checkLeft(root.left, min, root.val) && checkRight(root.right, root.val, max);
  }

  private boolean checkRight(TreeNode root, long min, long max) {
    if (root == null) {
      return true;
    }
    if (root.right == null && root.left == null) {
      return root.val > min;
    }
    if (root.left != null && (root.left.val >= root.val || root.left.val <= min)) {
      return false;
    }
    if (root.right != null && (root.right.val <= root.val || root.right.val >= max)) {
      return false;
    }
    return checkLeft(root.left, min, root.val) && checkRight(root.right, root.val, max);
  }
}
