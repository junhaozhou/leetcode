package com.littlechoc.leetcode.algorithms.reverse_bits;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem 190. See in <a href="https://leetcode.com/problems/reverse-bits/">LeetCode</a>
 *
 * @author 周俊皓.
 *         2016-08-12 14:04
 */
public class Solution {

  private Map<Byte, Integer> cache = new HashMap<Byte, Integer>();

  public int reverseBits(int n) {
    byte[] bytes = new byte[4];
    for (int i = 0; i < 4; i++) {
      bytes[i] = (byte) ((n >>> 8 * i) & 0xFF);
    }
    int result = 0;
    for (int i = 0; i < 4; i++) {
      result = result << 8;
      result += reverse(bytes[i]);
    }
    return result;
  }

  private int reverse(byte b) {
    Integer result;
    result = cache.get(b);
    if (result == null) {
      result = 0x000000FF & b;
      result = (result & 0x00000055) << 1 | (result >>> 1) & 0x00000055;
      result = (result & 0x00000033) << 2 | (result >>> 2) & 0x00000033;
      result = (result & 0x0000000F) << 4 | (result >>> 4) & 0x0000000F;
      cache.put(b, result);
    }
    return result;
  }
}
