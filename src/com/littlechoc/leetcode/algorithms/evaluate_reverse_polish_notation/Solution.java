package com.littlechoc.leetcode.algorithms.evaluate_reverse_polish_notation;

import java.util.Stack;

/**
 * Problem 150. See in <a href="https://leetcode.com/problems/evaluate-reverse-polish-notation/">LeetCode</a>
 *
 * @author 周俊皓.
 *         2016-07-20 00:50
 */
public class Solution {
  public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<Integer>();

    for (String token : tokens) {
      if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
        int operand1 = stack.pop();
        int operand2 = stack.pop();
        stack.push(eval(operand2, operand1, token));
      } else {
        Integer number = Integer.valueOf(token);
        stack.push(number);
      }
    }

    return stack.pop();
  }

  private int eval(int operand1, int operand2, String op) {
    char ch = op.charAt(0);
    int result = 0;
    switch (ch) {
      case '+':
        result = operand1 + operand2;
        break;
      case '-':
        result = operand1 - operand2;
        break;
      case '*':
        result = operand1 * operand2;
        break;
      case '/':
        result = operand1 / operand2;
        break;
    }
    return result;
  }
}
