package com.littlechoc.leetcode.algorithms.bitwise_and_of_numbers_range;

/**
 * Problem 201. See in <a href="https://leetcode.com/problems/bitwise-and-of-numbers-range/">LeetCode</a>
 *
 * @author 周俊皓.
 *         2016-08-12 11:46
 */
public class Solution {

  public int rangeBitwiseAnd(int m, int n) {
    if (m == 0) {
      return 0;
    }
    int offset = 0;
    while (m != n) {
      m = m >> 1;
      n = n >> 1;
      offset++;
    }
    return m << offset;
  }
}
