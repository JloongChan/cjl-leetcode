package com.cjl.leetcode;

/**
 * 33. Search in Rotated Sorted Array
 *
 *
 * You are given an integer array nums sorted in ascending order, and an integer target.
 *
 * Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * If target is found in the array return its index, otherwise, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * Example 3:
 *
 * Input: nums = [1], target = 0
 * Output: -1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * All values of nums are unique.
 * nums is guranteed to be rotated at some pivot.
 * -10^4 <= target <= 10^4
 *
 * @author chenjinlong
 * @date : 2020/12/15
 */
public class Solution0033 {

    private static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        return equals(nums, target, 0, nums.length - 1);
    }

    private static int equals(int[] nums, int target, int begin, int end) {
        if (nums[begin] == target) {
            return begin;
        } else if (nums[end] == target) {
            return end;
        }
        int size = end - begin;
        if (size <= 1) {
            return -1;
        }
        int mid = begin + size / 2;
        if (nums[begin] < nums[mid]) {
            return nums[begin] < target && target <= nums[mid] ? equals(nums, target, begin, mid) : equals(nums, target, mid, end);
        } else {
            return nums[mid] <= target && target < nums[end] ? equals(nums, target, mid, end) : equals(nums, target, begin, mid);
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 5;
        System.out.println(search(nums, target));
    }
}
