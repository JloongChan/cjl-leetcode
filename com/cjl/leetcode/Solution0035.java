package com.cjl.leetcode;

/**
 * 35. Search Insert Position
 * <p>
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * Example 2:
 * <p>
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * Example 3:
 * <p>
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 * Example 4:
 * <p>
 * Input: nums = [1,3,5,6], target = 0
 * Output: 0
 * Example 5:
 * <p>
 * Input: nums = [1], target = 0
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums contains distinct values sorted in ascending order.
 * -104 <= target <= 104
 *
 * @author chenjinlong
 * @date : 2020/12/17
 */
public class Solution0035 {

    /**
     * 支持暴力解
     *
     * @param nums   原数组
     * @param target 目标
     * @return 下标
     */
    private static int searchInsert(int[] nums, int target) {
        int i = 0;
        for (; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return i;
    }

    /**
     * TODO 二分法
     *
     * @param nums   原数组
     * @param target 目标
     * @return 下标
     */
    private static int searchInsert2(int[] nums, int target) {
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2));
    }
}
