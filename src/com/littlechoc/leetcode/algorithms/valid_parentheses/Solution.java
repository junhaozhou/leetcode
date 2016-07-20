package com.littlechoc.leetcode.algorithms.valid_parentheses;

import java.util.Stack;

/**
 * Problem 20. See in <a href="https://leetcode.com/problems/valid-parentheses/">LeetCode</a>
 *
 * @author 周俊皓.
 *         2016-07-20 19:35
 */
public class Solution {

  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<Character>();

    for (int i = 0; i < s.length(); ++i) {
      char ch = s.charAt(i);
      if (ch == '(' || ch == '{' || ch == '[') {
        stack.push(ch);
      } else if (ch == ')') {
        if (!stack.empty() && stack.peek() == '(') {
          stack.pop();
        } else {
          return false;
        }
      } else if (ch == ']') {
        if (!stack.empty() && stack.peek() == '[') {
          stack.pop();
        } else {
          return false;
        }
      } else if (ch == '}') {
        if (!stack.empty() && stack.peek() == '{') {
          stack.pop();
        } else {
          return false;
        }
      }
    }

    return stack.empty();
  }

}
