package com.littlechoc.leetcode.algorithms.single_number_iii;

/**
 * Problem 260. See in <a href="https://leetcode.com/problems/single-number-iii/">LeetCode</a>
 *
 * @author 周俊皓.
 *         2016-08-11 14:18
 */
public class Solution {

  public int[] singleNumber(int[] nums) {
    int aXORb = 0;
    for (int num : nums) {
      aXORb ^= num;
    }
    aXORb &= -aXORb;
    int[] result = new int[2];
    for (int num : nums) {
      if ((num & aXORb) == 0) {
        result[0] ^= num;
      } else {
        result[1] ^= num;
      }
    }
    return result;
  }
}
