package com.cjl.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 40. Combination Sum II
 *
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note: The solution set must not contain duplicate combinations.
 *
 *
 *
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5
 * Output:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 *
 * Constraints:
 *
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 *
 * @author chenjinlong
 * @date : 2021/1/3
 */
public class Solution0040 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    /**
     * 递归
     *
     * @param candidates 数组
     * @param target     目标值
     * @param startIndex 循环的起始下标
     * @param pickList   已经取到值
     * @param result     结果集
     */
    private static void dfs(int[] candidates, int target, int startIndex, List<Integer> pickList, List<List<Integer>> result) {
        if (target == 0) {
            result.add(pickList);
            return;
        } else if (target < 0 || startIndex >= candidates.length) {
            return;
        }
        int i = startIndex;
        int temp = 0;
        for (; i < candidates.length; i++) {
            if (temp == candidates[i]) {
                continue;
            }
            temp = candidates[i];
            List<Integer> tempPickList = new ArrayList<>(pickList);
            tempPickList.add(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1, tempPickList, result);
        }
    }
}
