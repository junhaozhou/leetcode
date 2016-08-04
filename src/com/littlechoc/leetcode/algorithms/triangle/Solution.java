package com.littlechoc.leetcode.algorithms.triangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 120. See in <a href="https://leetcode.com/problems/triangle/">LeetCode</a>
 *
 * @author 周俊皓.
 *         2016-08-04 15:11
 */
public class Solution {

  public int minimumTotal(List<List<Integer>> triangle) {
    int height = triangle.size();
    if (height == 0) {
      return 0;
    }
    int result = triangle.get(0).get(0);
    List<Integer> resultLine = new ArrayList<Integer>(1);
    resultLine.add(result);
    for (int row = 1; row < height; row++) {
      List<Integer> resultTmp = resultLine;
      resultLine = new ArrayList<Integer>(row + 1);
      result = Integer.MAX_VALUE;
      for (int i = 0; i < row + 1; i++) {
        int min;
        if (i == 0) {
          min = resultTmp.get(0) + triangle.get(row).get(i);
        } else if (i == row) {
          min = resultTmp.get(i - 1) + triangle.get(row).get(i);
        } else {
          min = Math.min(resultTmp.get(i - 1), resultTmp.get(i)) + triangle.get(row).get(i);
        }
        resultLine.add(min);
        result = Math.min(min, result);
      }
    }

    return result;
  }
}
