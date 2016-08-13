package com.littlechoc.leetcode.algorithms.maximum_product_of_word_lengths;

/**
 * Problem 318. See in <a href="https://leetcode.com/problems/maximum-product-of-word-lengths/">LeetCode</a>
 *
 * @author 周俊皓.
 *         2016-08-12 10:57
 */
public class Solution {
  public int maxProduct(String[] words) {
    int[] nums = new int[words.length];
    int max = 0;

    // init
    for (int i = 0; i < words.length; ++i) {
      String word = words[i];
      for (int j = 0; j < word.length(); ++j) {
        nums[i] |= 1 << (word.charAt(j) - 'a');
      }
    }

    // find the max
    for (int i = 0; i < words.length - 1; ++i) {
      for (int j = i + 1; j < words.length; ++j) {
        if ((nums[i] & nums[j]) == 0) {
          max = Math.max(max, words[i].length() * words[j].length());
        }
      }
    }

    return max;
  }
}
