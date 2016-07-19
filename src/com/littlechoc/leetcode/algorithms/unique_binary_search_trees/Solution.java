package com.littlechoc.leetcode.algorithms.unique_binary_search_trees;

/**
 * Problem 96. See in <a href="https://leetcode.com/problems/unique-binary-search-trees/">LeetCode</a>
 *
 * @author 周俊皓.
 *         2016-07-19 16:35
 */
public class Solution {
  public int numTrees(int n) {
    int count[] = new int[n + 1];
    count[0] = 1;
    for (int i = 1; i <= n; i++) {
      count[i] = 0;
      for (int j = 1; j <= i; j++) {
        count[i] += count[i - j] * count[j - 1];
      }
    }
    count[0] = 0;
    return count[n];
  }
}
