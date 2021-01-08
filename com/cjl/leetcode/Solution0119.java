package com.cjl.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 119 杨辉三角 二
 * //给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * //
 * //
 * //
 * // 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * //
 * // 示例:
 * //
 * // 输入: 3
 * //输出: [1,3,3,1]
 * //
 * //
 * // 进阶：
 * //
 * // 你可以优化你的算法到 O(k) 空间复杂度吗？
 * @author chenjinlong
 * @date : 2021/1/8
 */
public class Solution0119 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < rowIndex + 1; i++) {
            result.add(1);
            for (int j = i - 1; j > 0; j--) {
                result.set(j, result.get(j - 1) + result.get(j));
            }
        }
        return result;
//        int[] arr = new int[rowIndex + 1];
//        for (int i = 0; i < rowIndex + 1; i++) {
//            arr[i] = 1;
//            for (int j = i - 1; j > 0; j--) {
//                arr[j] = arr[j - 1] + arr[j];
//            }
//        }
//        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }
}
