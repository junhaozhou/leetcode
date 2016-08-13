package com.littlechoc.leetcode.algorithms.number_of_1_bits;

/**
 * Problem 191. See in <a href="https://leetcode.com/problems/number-of-1-bits/">LeetCode</a>
 *
 * @author 周俊皓.
 *         2016-08-12 13:38
 */
public class Solution {

  public int hammingWeight(int n) {
    int count = 0;
    while (n != 0) {
      count += n & 1;
      n = n >>> 1;
    }

    return count;
  }
}
