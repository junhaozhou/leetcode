package com.littlechoc.leetcode.algorithms.sort_colors;

/**
 * Problem 75. See in <a href="https://leetcode.com/problems/sort-colors/">LeetCode</a>
 *
 * @author 周俊皓.
 *         2016-07-18 13:15
 */
public class Solution {

  private static final int RED = 0;
  private static final int WHITE = 1;
  private static final int BLUE = 2;

  private static final int NO_POSITION = -1;

  public void sortColors(int[] nums) {
    int whiteBeginPosition = NO_POSITION;
    int blueBeginPosition = NO_POSITION;

    for (int i = 0; i < nums.length; ++i) {
      if (nums[i] == RED) { // Red
        if (whiteBeginPosition == NO_POSITION && blueBeginPosition != NO_POSITION) {
          nums[blueBeginPosition++] = RED;
          nums[i] = BLUE;
        }
        if (whiteBeginPosition != NO_POSITION && blueBeginPosition == NO_POSITION) {
          nums[whiteBeginPosition++] = RED;
          nums[i] = WHITE;
        }
        if (whiteBeginPosition != NO_POSITION && blueBeginPosition != NO_POSITION) {
          nums[whiteBeginPosition++] = RED;
          nums[blueBeginPosition++] = WHITE;
          nums[i] = BLUE;
        }

      } else if (nums[i] == WHITE) { // white
        if (whiteBeginPosition != NO_POSITION && blueBeginPosition != NO_POSITION) {
          nums[blueBeginPosition++] = WHITE;
          nums[i] = BLUE;
        }
        if (whiteBeginPosition == NO_POSITION && blueBeginPosition == NO_POSITION) {
          whiteBeginPosition = i;
        }
        if (whiteBeginPosition == NO_POSITION && blueBeginPosition != NO_POSITION) {
          whiteBeginPosition = blueBeginPosition;
          nums[blueBeginPosition++] = WHITE;
          nums[i] = BLUE;
        }
      } else { // blue
        // do nothing
        if (blueBeginPosition == NO_POSITION) {
          blueBeginPosition = i;
        }
      }
    }
  }
}
