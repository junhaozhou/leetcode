package com.littlechoc.leetcode.algorithms.maximum_product_subarray;

/**
 * Problem 152. See in <a href="https://leetcode.com/problems/maximum-product-subarray/">LeetCode</a>
 *
 * @author 周俊皓.
 *         2016-07-20 12:47
 */
public class Solution {

  public int maxProduct(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int[] positive = new int[nums.length];
    int[] negative = new int[nums.length];
    positive[0] = nums[0] > 0 ? nums[0] : 0;
    negative[0] = nums[0] > 0 ? 0 : nums[0];
    int maxProduct = nums[0];

    for (int i = 1; i < nums.length; ++i) {
      int maxTemp = nums[i] * positive[i - 1];
      int minTemp = nums[i] * negative[i - 1];
      if (nums[i] > 0) {
        positive[i] = maxTemp > nums[i] ? maxTemp : nums[i];
        negative[i] = minTemp < nums[i] ? minTemp : nums[i];
        maxProduct = maxProduct > positive[i] ? maxProduct : positive[i];
      } else {
        positive[i] = minTemp > nums[i] ? minTemp : nums[i];
        negative[i] = maxTemp < nums[i] ? maxTemp : nums[i];
        maxProduct = maxProduct > positive[i] ? maxProduct : positive[i];
      }
    }

    return maxProduct;
  }
}
