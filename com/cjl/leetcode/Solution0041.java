package com.cjl.leetcode;

/**
 * 41. First Missing Positive
 * <p>
 * Given an unsorted integer array nums, find the smallest missing positive integer.
 * <p>
 * Follow up: Could you implement an algorithm that runs in O(n) time and uses constant extra space.?
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,0]
 * Output: 3
 * Example 2:
 * <p>
 * Input: nums = [3,4,-1,1]
 * Output: 2
 * Example 3:
 * <p>
 * Input: nums = [7,8,9,11,12]
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= nums.length <= 300
 * -231 <= nums[i] <= 231 - 1
 *
 * @author chenjinlong
 * @date : 2021/1/3
 */
public class Solution0041 {

    private static int firstMissingPositive(int[] nums) {
        // solution1
//        Arrays.sort(nums);
//        int result = 1;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] <= 0 || nums[i] < result) {
//                continue;
//            }
//            if (result != nums[i]) {
//                return result;
//            }
//            result++;
//        }
//        return result;

        // solution2
        int[] arr = new int[nums.length + 1];
        for (int i : nums) {
            if (i > 0 && i <= nums.length) {
                arr[i] = 1;
            }
        }
        int i = 1;
        for (; i < arr.length; i++) {
            if (arr[i] != 1) {
                return i;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1, 2, 0}));
    }

}
