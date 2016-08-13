package com.littlechoc.leetcode.algorithms.perfect_squares;

/**
 * Problem 279. See in <a href="https://leetcode.com/problems/perfect-squares/">LeetCode</a>
 *
 * @author 周俊皓.
 *         2016-08-10 14:55
 */
public class Solution {

  public int numSquares(int n) {
    if (isSquare(n) && n != 0) {
      return 1;
    }
    int[] result = new int[n + 1];
    result[0] = 0;
    for (int i = 1; i <= n; ++i) {
      if (isSquare(i)) {
        result[i] = 1;
        continue;
      }
      int min = Integer.MAX_VALUE;
      int square = (int) Math.sqrt(i);
      for (int j = 1; j <= square; j++) {
        min = Math.min(min, result[i - j * j] + 1);
      }
      result[i] = min;
    }
    return result[n];
  }

  private boolean isSquare(int num) {
    int square = (int) Math.floor(Math.sqrt(num));
    return square * square == num;
  }
}
