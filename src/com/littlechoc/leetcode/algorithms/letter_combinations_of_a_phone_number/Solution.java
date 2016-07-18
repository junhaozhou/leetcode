package com.littlechoc.leetcode.algorithms.letter_combinations_of_a_phone_number;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 17. See in <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number/">LeetCode</a>
 *
 * @author 周俊皓.
 *         2016-07-18 15:23
 */
public class Solution {

  private static char[][] LETTER_MAP = {
          {' '},
          {' '},
          {'a', 'b', 'c'},
          {'d', 'e', 'f'},
          {'g', 'h', 'i'},
          {'j', 'k', 'l'},
          {'m', 'n', 'o'},
          {'p', 'q', 'r', 's'},
          {'t', 'u', 'v'},
          {'w', 'x', 'y', 'z'}
  };

  public List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<String>();
    if (digits.length() == 0) {
      return result;
    }
    combination(digits, "", result);
    return result;
  }

  private void combination(String digits, String parent, List<String> result) {
    if (digits == null || digits.length() == 0) {
      result.add(parent);
      return;
    }
    int number = Integer.valueOf(digits.substring(0, 1));
    for (int i = 0; i < LETTER_MAP[number].length; i++) {
      combination(digits.substring(1, digits.length()), parent + LETTER_MAP[number][i], result);
    }
  }
}
