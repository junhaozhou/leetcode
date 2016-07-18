package com.littlechoc.leetcode.gray_code;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 89. See in <a href="https://leetcode.com/problems/gray-code/">LeetCode</a>
 *
 * @author 周俊皓.
 *         2016-07-18 14:50
 */
public class Solution {

  public List<Integer> grayCode(int n) {
    int size = (int) Math.pow(2, n);
    List<Integer> result = new ArrayList<Integer>(size);
    result.add(0);

    for (int i = 0; i < n; i++) {
      int pow = (int) Math.pow(2, i);
      for (int j = 0; j < pow; j++) {
        result.add(pow + result.get(pow - j - 1));
      }
    }

    return result;
  }
}
