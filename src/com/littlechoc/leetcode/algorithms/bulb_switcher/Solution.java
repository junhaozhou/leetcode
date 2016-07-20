package com.littlechoc.leetcode.algorithms.bulb_switcher;

/**
 * Problem 319. See in <a href="https://leetcode.com/problems/bulb-switcher/">LeetCode</a>
 *
 * @author 周俊皓.
 *         2016-07-20 16:37
 */
public class Solution {

  public int bulbSwitch(int n) {
    return (int) Math.floor(Math.sqrt(n));
  }
}
