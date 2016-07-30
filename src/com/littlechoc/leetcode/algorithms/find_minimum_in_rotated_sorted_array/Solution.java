package com.littlechoc.leetcode.algorithms.find_minimum_in_rotated_sorted_array;

/**
 * Problem 153. See in <a href="https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/">LeetCode</a>
 *
 * @author 周俊皓.
 *         2016-07-20 01:03
 */
public class Solution {

  public int findMin(int[] nums) {
    int begin = 0;
    int length = nums.length;
    int half = length % 2 == 1 ? (length + 1) / 2 : length / 2;

    if (length == 1) {
      return nums[0];
    }

    for (int i = 0; i < half; ++i) {
      if (nums[i] > nums[i + 1]) {
        begin = i + 1;
      }
      if (nums[length - 1 - i] < nums[length - 2 - i]) {
        begin = length - 1 - i;
      }
    }

    return nums[begin];
  }

}
