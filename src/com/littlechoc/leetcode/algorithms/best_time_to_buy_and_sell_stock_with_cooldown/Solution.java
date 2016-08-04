package com.littlechoc.leetcode.algorithms.best_time_to_buy_and_sell_stock_with_cooldown;

/**
 * Problem 309. See in <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/">LeetCode</a>
 *
 * @author 周俊皓.
 *         2016-08-04 14:24
 */
public class Solution {
  public int maxProfit(int[] prices) {
    int state_1, state_2, state_3;
    if (prices.length == 0) {
      return 0;
    }

    // init
    state_1 = 0;
    state_2 = -prices[0];
    state_3 = Integer.MIN_VALUE;

    // begin
    for (int day = 1; day < prices.length; day++) {
      int state_1_tmp = state_1;
      state_1 = Math.max(state_1, state_3);
      state_2 = Math.max(state_2, state_1_tmp - prices[day]);
      state_3 = state_2 + prices[day];
    }

    return Math.max(state_1, state_3);
  }
}
