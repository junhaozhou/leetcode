package com.littlechoc.leetcode.algorithms.house_robber_iii;

import com.littlechoc.leetcode.datastructure.TreeNode;

/**
 * Problem 337. See in <a href="https://leetcode.com/problems/house-robber-iii/">LeetCode</a>
 *
 * @author 周俊皓.
 *         2016-07-20 21:54
 */
public class Solution {

  public int rob(TreeNode root) {
    if (root == null) {
      return 0;
    }
    if (root.right == null && root.left == null) {
      return root.val;
    }
    int max1 = 0, max2 = 0;
    max1 += root.val;
    if (root.left != null) {
        max1 += rob(root.left.left) + rob(root.left.right);
        max2 += rob(root.left);
    }
    if (root.right != null) {
      max1 += rob(root.right.left) + rob(root.right.right);
      max2 += rob(root.right);
    }

    return max1 > max2 ? max1 : max2;
  }

}
