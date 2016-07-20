package com.littlechoc.leetcode.algorithms.binary_tree_postorder_traversal;

import com.littlechoc.leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Problem 145. See in <a href="https://leetcode.com/problems/binary-tree-postorder-traversal/">LeetCode</a>
 *
 * @author 周俊皓.
 *         2016-07-20 21:00
 */
public class Solution {
  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    Stack<TreeNode> stack = new Stack<TreeNode>();

    stack.push(root);
    while (!stack.empty()) {
      TreeNode node = stack.peek();
      if (node == null) {
        stack.pop();
        if (!stack.isEmpty()) {
          TreeNode temp = stack.pop();
          result.add(temp.val);
          if (!stack.isEmpty()) {
            if (stack.peek().right == temp) {
              stack.push(null);
            } else {
              stack.push(stack.peek().right);
            }
          }
        }
      } else {
        while (node.left != null) {
          stack.push(node.left);
          node = node.left;
        }
        stack.push(node.right);
      }
    }

    return result;
  }
}
