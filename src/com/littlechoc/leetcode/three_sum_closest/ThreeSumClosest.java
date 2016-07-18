package com.littlechoc.leetcode.three_sum_closest;

/**
 * Problem 16. See in <a href="https://leetcode.com/problems/3sum-closest/">LeetCode</a>.
 *
 * @author 周俊皓.
 *         2016-07-14 13:14
 */
public class ThreeSumClosest {

  public int threeSumClosest(int[] nums, int target) {
    int length = nums.length;
    int min = Integer.MAX_VALUE;
    int sum = 0;
    for (int i = 0; i < length; ++i) {
      for (int j = i + 1; j < length; ++j) {
        for (int k = j + 1; k < length; ++k) {
          int sumTemp = nums[i] + nums[j] + nums[k];
          int diff = Math.abs(target - sumTemp);
          min = min < diff ? min : diff;
          sum = min < diff ? sum : sumTemp;
          if (min == 0) {
            return sumTemp;
          }
        }
      }
    }
    return sum;
  }

}
