package com.littlechoc.leetcode.algorithms.longest_increasing_subsequence;

/**
 * Problem 300. See in <a href="https://leetcode.com/problems/longest-increasing-subsequence/">LeetCode</a>
 *
 * @author 周俊皓.
 *         2016-08-04 15:39
 */
public class Solution {


  public int longestIncreasingSubsequence(int[] nums) {
    // write your code here
    if(nums.length == 0){
      return 0;
    }
    // len表示当前最长的升序序列长度（为了方便操作tails我们减1）
    int len = 0;
    // tails[i]表示长度为i的升序序列其末尾的数字
    int[] tails = new int[nums.length];
    tails[0] = nums[0];
    // 根据三种情况更新不同升序序列的集合
    for(int i = 1; i < nums.length; i++){
      if(nums[i] < tails[0]){
        tails[0] = nums[i];
      } else if (nums[i] >= tails[len]){
        tails[++len] = nums[i];
      } else {
        // 如果在中间，则二分搜索
        tails[binarySearch(tails, 0, len, nums[i])] = nums[i];
      }
    }
    return len + 1;
  }

  private int binarySearch(int[] tails, int min, int max, int target){
    while(min <= max){
      int mid = min + (max - min) / 2;
      if(tails[mid] == target){
        return mid;
      }
      if(tails[mid] < target){
        min = mid + 1;
      }
      if(tails[mid] > target){
        max = mid - 1;
      }
    }
    return min;
  }

  public int lengthOfLIS(int[] nums) {
    int length = nums.length;
    if (length == 0) {
      return 0;
    }
    int[] tails = new int[length];
    tails[0] = Integer.MAX_VALUE;
    int index = 0;

    for (int num : nums) {
      if (num < tails[0]) {
        tails[0] = num;
      } else if (num >= tails[index]) {
        tails[++index] = num;
      } else {
        tails[binarySearch(nums, index, num)] = num;
      }
    }

    return index + 1;
  }

  private int binarySearch(int[] nums, int length, int target) {
    int begin = 0, end = length;
    while (begin <= end) {
      int mid = begin + (end - begin) / 2;
      if (nums[mid] == target) {
        return mid;
      }
      if (nums[mid] > target) {
        end = mid - 1;
      }
      if (nums[mid] < target) {
        begin = mid + 1;
      }
    }
    return begin;
  }
//  public int lengthOfLIS(int[] nums) {
//    int length = nums.length;
//    if (length == 0) {
//      return 0;
//    }
//    int[] result = new int[length];
//    result[0] = 1;
//    for (int i = 1; i < length; i++) {
//      int max = 1;
//      for (int j = 0; j < i; j++) {
//        if (nums[i] > nums[j]) {
//          max = Math.max(result[j] + 1, max);
//        }
//      }
//      result[i] = max;
//    }
//
//    return result[length - 1];
//  }
}
