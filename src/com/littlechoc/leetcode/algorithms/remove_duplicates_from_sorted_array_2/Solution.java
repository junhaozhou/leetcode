package com.littlechoc.leetcode.algorithms.remove_duplicates_from_sorted_array_2;

/**
 * Problem 80. See in <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/">LeetCode</a>
 *
 * @author 周俊皓.
 *         2016-07-18 13:56
 */
public class Solution {

  public int removeDuplicates(int[] nums) {
    int length = 0;
    int lastNumber = nums.length == 0 ? 0 : nums[0] - 1;
    int lastCount = 1;

    for (int i = 0; i < nums.length; ++i) {
      if (nums[i] != lastNumber) {
        nums[length++] = nums[i];
        lastNumber = nums[i];
        lastCount = 0;
      } else {
        ++lastCount;
        if (lastCount < 2) {
          nums[length++] = nums[i];
        }
      }
    }

    return length;
  }
}
