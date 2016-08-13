package com.littlechoc.leetcode.algorithms.power_of_two;

/**
 * Problem 231. See in <a href="https://leetcode.com/problems/power-of-two/">LeetCode</a>
 *
 * @author 周俊皓.
 *         2016-08-12 11:51
 */
public class Solution {

  public boolean isPowerOfTwo(int n) {
    if (n <= 0) {
      return false;
    }
    int count = 0;
    for (int offset = 0; offset <= 31; offset++) {
      if ((n >> offset & 1) == 1) {
        count++;
      }
    }
    return count == 1;
  }
}
