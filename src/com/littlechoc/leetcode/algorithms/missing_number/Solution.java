package com.littlechoc.leetcode.algorithms.missing_number;

/**
 * Problem 268. See in <a href="https://leetcode.com/problems/missing-number/">LeetCode</a>
 *
 * @author 周俊皓.
 *         2016-08-12 11:13
 */
public class Solution {

  public int missingNumber(int[] nums) {
    int missing = 0;
    int mask = 0;
    for (int num : nums) {
      missing ^= num ^ mask++;
    }
    missing = missing ^ mask;
    return missing;
  }
}
