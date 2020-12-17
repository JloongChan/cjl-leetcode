package com.cjl.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 * <p>
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * <p>
 * If target is not found in the array, return [-1, -1].
 * <p>
 * Follow up: Could you write an algorithm with O(log n) runtime complexity?
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * Example 3:
 * <p>
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums is a non-decreasing array.
 * -109 <= target <= 109
 *
 * @author chenjinlong
 * @date : 2020/12/17
 */
public class Solution0034 {

    private static int[] searchRange(int[] nums, int target) {
        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int begin = numList.indexOf(target);
        if (begin == -1) {
            return new int[]{-1, -1};
        }
        return new int[]{begin, numList.lastIndexOf(target)};
    }

    public static void main(String[] args) {
        Arrays.stream(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8))
                .forEach(System.out::println);
    }
}
