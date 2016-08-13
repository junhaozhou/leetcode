package com.littlechoc.leetcode.algorithms.range_sum_query_2d_immutable;

/**
 * Problem 304. See in <a href="https://leetcode.com/problems/range-sum-query-2d-immutable/">LeetCode</a>
 *
 * @author 周俊皓.
 *         2016-08-05 10:42
 */
public class NumMatrix {

  private int col;
  private int row;
  private int[][] countArray;

  public NumMatrix(int[][] matrix) {
    row = matrix.length;
    col = 0;
    if (row != 0) {
      col = matrix[0].length;
    }
    countArray = new int[row][col];
    for (int i = 0; i < row; i++) {
      int count = 0;
      for (int j = 0; j < col; j++) {
        countArray[i][j] = matrix[i][j];
        if (i - 1 >= 0 && j - 1 >= 0) {
          countArray[i][j] += countArray[i - 1][j - 1];
        }
        for (int k = 0; k < i; k++) {
          countArray[i][j] += matrix[k][j];
        }
        countArray[i][j] += count;
        count += matrix[i][j];
      }
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    int r1 = countArray[row2][col2];
    int r2 = (row1 > 0 && col1 > 0) ? countArray[row1 - 1][col1 - 1] : 0;
    int r3 = (col1 > 0) ? countArray[row2][col1 - 1] : 0;
    int r4 = (row1 > 0) ? countArray[row1 - 1][col2] : 0;
    return r1 - r3 - r4 + r2;
  }
}
