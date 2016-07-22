package com.littlechoc.leetcode.algorithms.house_robber_ii;

/**
 * Problem 213. See in <a href="https://leetcode.com/problems/house-robber-ii/">LeetCode</a>
 *
 * @author 周俊皓.
 *         2016-07-22 18:25
 */
public class Solution {
  public int rob(int[] nums) {

    int[][] lastNight = new int[2][2];
    int[] money = new int[2];

    if (nums.length == 1) {
      return nums[0];
    }

    for (int i = 0; i < nums.length - 1; i++) {
      money[0] = Math.max(nums[i] + lastNight[0][0], lastNight[0][1]);
      lastNight[0][0] = lastNight[0][1];
      lastNight[0][1] = money[0];

      money[1] = Math.max(nums[i + 1] + lastNight[1][0], lastNight[1][1]);
      lastNight[1][0] = lastNight[1][1];
      lastNight[1][1] = money[1];
    }

    return Math.max(money[0], money[1]);
  }
}
