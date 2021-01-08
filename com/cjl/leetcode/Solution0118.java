package com.cjl.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 //  118 杨辉三角
 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 //
 //
 //
 // 在杨辉三角中，每个数是它左上方和右上方的数的和。
 //
 // 示例:
 //
 // 输入: 5
 //输出:
 //[
 //     [1],
 //    [1,1],
 //   [1,2,1],
 //  [1,3,3,1],
 // [1,4,6,4,1]
 //]
 *
 * @author chenjinlong
 * @date : 2021/1/8
 */
public class Solution0118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>(i + 1);
            result.add(list);
            list.add(1);
            for (int j = 0; j < i; j++) {
                if (j == i - 1) {
                    list.add(1);
                } else {
                    list.add(result.get(i - 1).get(j + 1) + result.get(i - 1).get(j));
                }
            }
        }
        return result;
    }
}
