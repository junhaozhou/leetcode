package com.littlechoc.leetcode.utils;

import com.littlechoc.leetcode.datastructure.ListNode;
import com.littlechoc.leetcode.datastructure.TreeNode;

import java.io.Console;
import java.util.*;

/**
 * 输入工具类
 *
 * @author 周俊皓.
 *         2016-07-10 18:47
 */
public class InputHelper {

  /**
   * 获取控制台输入
   *
   * @return 控制台输入的参数
   */
  public static List<String> input() {
    List<String> paras = new ArrayList<String>();
    Console console = System.console();
    while (true) {
      String line = console.readLine();
      if (line.length() == 0) {
        break;
      }
      paras.add(line);
    }
    return paras;
  }

  /**
   * 根据输入字符串构建链表
   *
   * @param s 字符串
   * @return 链表头
   */
  public static ListNode createLinkedList(String s) {
    if (s.startsWith("[") && s.endsWith("]")) {
      s = s.replace("[", "").replace("]", "");
      String[] numbers = s.split(",");
      ListNode node = new ListNode(-1);
      ListNode head = node;
      for (String number : numbers) {
        try {
          node.next = new ListNode(Integer.valueOf(number));
          node = node.next;
        } catch (NumberFormatException e) {
          // do nothing
        }
      }
      return head.next;
    }
    return null;
  }

  /**
   * 根据输入字符串构建int数组
   *
   * @param s 字符串
   * @return 数组
   */
  public static int[] createIntArray(String s) {
    List<Integer> list = new ArrayList<Integer>();
    if (s.startsWith("[") && s.endsWith("]")) {
      s = s.replace("[", "").replace("]", "");
      String[] numbers = s.split(",");
      for (String number : numbers) {
        try {
          list.add(Integer.valueOf(number));
        } catch (NumberFormatException e) {
          // do nothing
        }
      }
      int[] array = new int[list.size()];
      int index = 0;
      for (Integer integer : list) {
        array[index++] = integer;
      }
      return array;
    }
    return null;
  }

  /**
   * 根据输入字符串构建int数组
   *
   * @param s 字符串
   * @return 数组
   */
  public static TreeNode createTree(String s) {
    Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
    TreeNode root = null;
    if (s.startsWith("[") && s.endsWith("]")) {
      s = s.replace("[", "").replace("]", "");
      String[] numbers = s.split(",");
      boolean left = true;
      for (String number : numbers) {
        if (number.equals("null")) {
          if (queue.isEmpty()) {
            return null;
          }
          if (!left) {
            queue.poll();
          }
          left = !left;
        } else {
          try {
            int num = Integer.valueOf(number);
            TreeNode node = new TreeNode(num);
            if (queue.isEmpty()) {
              root = node;
            } else {
              if (left) {
                queue.peek().left = node;
              } else {
                queue.poll().right = node;
              }
              left = !left;
            }
            queue.offer(node);
          } catch (NumberFormatException e) {
            // do nothing
          }
        }
      }
      return root;
    }
    return null;
  }
}
