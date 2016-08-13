package com.littlechoc.leetcode.algorithms.single_number;

/**
 * Problem 136. See in <a href="https://leetcode.com/problems/single-number/">LeetCode</a>
 * @author 周俊皓.
 *         2016-08-11 14:40
 */
public class Solution {

  public int singleNumber(int[] nums) {
    int result = 0;

    for (int num : nums) {
      result ^= num;
    }

    return result;
  }
}
