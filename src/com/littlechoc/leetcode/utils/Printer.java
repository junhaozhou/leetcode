package com.littlechoc.leetcode.utils;

import com.littlechoc.leetcode.datastructure.ListNode;

/**
 * 打印工具类
 *
 * @author 周俊皓.
 *         2016-07-07 17:13
 */
public class Printer {

  /**
   * 打印字符串
   *
   * @param s
   */
  public static void print(String s) {
    System.out.print(s);
  }

  /**
   * 打印时间
   *
   * @param second 时间 毫秒
   */
  public static void printTime(long second) {
    System.out.print("--------- Runtime: " + second + " ms ---------\n");
  }

  /**
   * 打印链表
   *
   * @param head 链表头
   */
  public static void printLinkedList(ListNode head) {
    System.out.print("[");
    while (head != null) {
      System.out.printf("" + head.val);
      if (head.next != null) {
        System.out.printf(",");
      }
      head = head.next;
    }
    System.out.print("]\n");
  }
}
