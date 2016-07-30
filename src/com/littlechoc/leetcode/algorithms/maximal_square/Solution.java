package com.littlechoc.leetcode.algorithms.maximal_square;

/**
 * Problem 221. See in <a href="https://leetcode.com/problems/maximal-square/">LeetCode</a>
 *
 * @author 周俊皓.
 *         2016-07-21 16:59
 */
public class Solution {
  public int maximalSquare(char[][] matrix) {
    int max = 0;
    int row = matrix.length;
    if (row == 0) {
      return 0;
    }
    int column = matrix[0].length;
    int[][] count = new int[row][column];

    for (int i = 0; i < column; i++) {
      count[0][i] = matrix[0][i] - '0';
      if (count[0][i] == 1) {
        max = 1;
      }
    }
    for (int i = 0; i < row; i++) {
      count[i][0] = matrix[i][0] - '0';
      if (count[i][0] == 1) {
        max = 1;
      }
    }
    for (int i = 1; i < row; i++) {
      for (int j = 1; j < column; j++) {
        if (matrix[i][j] - '0' == 0) {
          count[i][j] = 0;
        } else {
          if (count[i - 1][j - 1] == 0) {
            count[i][j] = 1;
            max = max > 1 ? max : 1;
            continue;
          }
          int k = 1;
          for (; k <= (int) Math.sqrt(count[i - 1][j - 1]); k++) {
            if (matrix[i][j - k] == '0' || matrix[i - k][j] == '0') {
              break;
            }
          }
          count[i][j] = k * k;
          max = max > count[i][j] ? max : count[i][j];
        }
      }
    }

    return max;
  }
}
