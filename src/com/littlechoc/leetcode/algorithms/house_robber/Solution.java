package com.littlechoc.leetcode.algorithms.house_robber;

/**
 * Problem 198. See in <a href="https://leetcode.com/problems/house-robber/">LeetCode</a>
 *
 * @author 周俊皓.
 *         2016-07-20 22:17
 */
public class Solution {
  public int rob(int[] nums) {
    int[] lastSum = {0, 0};
    int max = 0;
    for (int i = 0; i < nums.length; i++) {
      max = Math.max(lastSum[0] + nums[i], lastSum[1]);
      lastSum[0] = lastSum[1];
      lastSum[1] = max;
    }
    return max;
  }
}
