package com.littlechoc.leetcode.algorithms.sum_of_two_integers;

/**
 * Problem 371. See in <a href="https://leetcode.com/problems/sum-of-two-integers/">LeetCode</a>
 *
 * @author 周俊皓.
 *         2016-08-12 14:25
 */
public class Solution {
  public int getSum(int a, int b) {
    if (a == 0) {
      return b;
    }
    if (b == 0) {
      return a;
    }
    int sum = a ^ b;
    int carry = (a & b) << 1;
    return getSum(sum, carry);
  }
}
