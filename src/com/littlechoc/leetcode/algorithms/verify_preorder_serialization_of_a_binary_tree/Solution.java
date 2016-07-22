package com.littlechoc.leetcode.algorithms.verify_preorder_serialization_of_a_binary_tree;

import java.util.Stack;

/**
 * Problem 331. See in <a href="https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/">LeetCode</a>
 *
 * @author 周俊皓.
 *         2016-07-22 11:38
 */
public class Solution {
  public boolean isValidSerialization(String preorder) {
    Stack<Character> statck = new Stack<Character>();

    preorder += ",";
    for (int i = 0; i < preorder.length(); i++) {
      if (preorder.charAt(i) == ',') {
        if (i == 0) {
          return false;
        }
        if (preorder.charAt(i - 1) == '#') {
          while (true) {
            if (statck.empty()) {
              statck.push('#');
              break;
            }
            if (statck.peek() == '#') {
              statck.pop();
              if (statck.empty()) {
                return false;
              }
              statck.pop();
            } else {
              statck.push('#');
              break;
            }
          }
        } else {
          statck.push('*');
        }
      }
    }
    return !statck.empty() && statck.pop() == '#' && statck.empty();
  }
}
