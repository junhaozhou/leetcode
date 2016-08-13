package com.littlechoc.leetcode.algorithms.majority_element;

/**
 * Problem 169. See in <a href="https://leetcode.com/problems/majority-element/">LeetCode</a>
 *
 * @author 周俊皓.
 *         2016-08-12 13:01
 */
public class Solution {

  public int majorityElement(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int count = 1;
    int major = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (major == nums[i]) {
        count++;
      } else {
        if (count == 0) {
          major = nums[i];
          count = 1;
        } else {
          count--;
        }
      }
    }
    return major;
  }
}
