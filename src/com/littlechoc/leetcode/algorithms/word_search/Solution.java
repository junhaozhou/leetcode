package com.littlechoc.leetcode.algorithms.word_search;

/**
 * Problem 79. See in <a href="https://leetcode.com/problems/word-search/">LeetCode</a>
 *
 * @author 周俊皓.
 *         2016-07-20 15:16
 */
public class Solution {

  private int row;

  private int column;

  public boolean exist(char[][] board, String word) {

    if (word.length() == 0) {
      return false;
    }
    row = board.length;
    if (row == 0) {
      return false;
    }
    column = board[0].length;

    if (word.length() > row * column) {
      return false;
    }

    int[][] table = new int[row][column];

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < column; j++) {
        if (board[i][j] != word.charAt(0)) {
          continue;
        }
        table[i][j] = 1;
        boolean exist = find(i, j, word.substring(1, word.length()), board, table);
        if (exist) {
          return true;
        } else {
          table[i][j] = 0;
        }
      }
    }

    return false;
  }

  private boolean find(int x, int y, String word, char[][] board, int[][] table) {
    if (word.length() == 0) {
      return true;
    }
    char ch = word.charAt(0);
    if (x - 1 >= 0 && table[x - 1][y] != 1 && board[x - 1][y] == ch) {
      table[x - 1][y] = 1;
      boolean exist = find(x - 1, y, word.substring(1, word.length()), board, table);
      if (exist) {
        return true;
      } else {
        table[x - 1][y] = 0;
      }
    }
    if (x + 1 < row && table[x + 1][y] != 1 && board[x + 1][y] == ch) {
      table[x + 1][y] = 1;
      boolean exist = find(x + 1, y, word.substring(1, word.length()), board, table);
      if (exist) {
        return true;
      } else {
        table[x + 1][y] = 0;
      }
    }
    if (y - 1 >= 0 && table[x][y - 1] != 1 && board[x][y - 1] == ch) {
      table[x][y - 1] = 1;
      boolean exist = find(x, y - 1, word.substring(1, word.length()), board, table);
      if (exist) {
        return true;
      } else {
        table[x][y - 1] = 0;
      }
    }
    if (y + 1 < column && table[x][y + 1] != 1 && board[x][y + 1] == ch) {
      table[x][y + 1] = 1;
      boolean exist = find(x, y + 1, word.substring(1, word.length()), board, table);
      if (exist) {
        return true;
      } else {
        table[x][y + 1] = 0;
      }
    }
    return false;
  }
}
