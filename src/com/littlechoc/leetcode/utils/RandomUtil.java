package com.littlechoc.leetcode.utils;

/**
 * 随机数据生成工具
 *
 * @author 周俊皓.
 *         2016-07-10 17:28
 */
public class RandomUtil {

  /**
   * 生成一个随机int数
   *
   * @param begin 起始范围
   * @param end   终止范围
   * @return 随机整数
   */
  public static int randomInt(int begin, int end) {
    return (int) (begin + Math.random() * (end - begin));
  }
}
