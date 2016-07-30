package com.littlechoc.leetcode.algorithms.largest_divisible_subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem 368. See in <a href="https://leetcode.com/problems/largest-divisible-subset/">LeetCode</a>
 *
 * @author 周俊皓.
 *         2016-07-30 20:37
 */
public class Solution {

  public List<Integer> largestDivisibleSubset(int[] nums) {
    List<Integer> res = new ArrayList<Integer>();

    int length = nums.length;
    if (length == 0) {
      return res;
    }
    int[] count = new int[length];
    int[] pre = new int[length];

    // init
    for (int i = 0; i < length; i++) {
      count[i] = 1;
      pre[i] = -1;
    }

    // sort
    Arrays.sort(nums);

    // dp
    for (int i = 1; i < length; i++) {
      for (int j = i - 1; j >= 0; j--) {
        if (nums[i] % nums[j] == 0 && count[j] + 1 > count[i]) {
          count[i] = count[j] + 1;
          pre[i] = j;
        }
      }
    }

    // find the max and the position
    int maxPosition = -1;
    int max = 0;
    for (int i = 0; i < length; i++) {
      if (count[i] > max) {
        max = count[i];
        maxPosition = i;
      }
    }

    // find the list
    int index = maxPosition;
    while (index >= 0) {
      res.add(0, nums[index]);
      index = pre[index];
    }

    return res;
  }
}
