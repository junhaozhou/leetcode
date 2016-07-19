package com.littlechoc.leetcode.algorithms.binary_tree_preorder_traversal;

import com.littlechoc.leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Problem 144. See in <a href="https://leetcode.com/problems/binary-tree-preorder-traversal/">LeetCode</a>
 *
 * @author 周俊皓.
 *         2016-07-19 15:11
 */
public class Solution {

  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    Stack<TreeNode> stack = new Stack<TreeNode>();

    stack.push(root);
    while (!stack.empty()) {
      TreeNode node = stack.peek();
      if (node == null) {
        stack.pop();
        if (!stack.empty()) {
          stack.push(stack.pop().right);
        }
      } else {
        result.add(node.val);
        while (node.left != null) {
          node = node.left;
          stack.push(node);
          result.add(node.val);
        }
        stack.pop();
        if (node.right != null) {
          stack.push(node.right);
        } else {
          if (!stack.empty()) {
            stack.push(stack.pop().right);
          }
        }
      }
    }

    return result;
  }
}
