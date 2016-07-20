package com.littlechoc.leetcode.utils;

import com.littlechoc.leetcode.datastructure.ListNode;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

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
}
