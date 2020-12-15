package com.cjl.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1. Two Sum
 *
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 103
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 *
 * @author chenjinlong
 * @date : 2020/12/15
 */
public class Solution0001 {

    private static List twoSum(int[] nums, int target) {
        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        for (int i = 0; i < numList.size() - 1; i++) {
            Integer value = target - numList.get(i);
            if (numList.indexOf(value) > -1) {
                return Arrays.stream(new int[]{i, numList.indexOf(value)}).boxed().collect(Collectors.toList());
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(twoSum(new int[]{2, 7, 11, 15}, 9));
    }
}