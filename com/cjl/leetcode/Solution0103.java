package com.cjl.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 //给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 //
 // 例如：
 //给定二叉树 [3,9,20,null,null,15,7],
 //
 //
 //    3
 //   / \
 //  9  20
 //    /  \
 //   15   7
 //
 //
 // 返回锯齿形层序遍历如下：
 //
 //
 //[
 //  [3],
 //  [20,9],
 //  [15,7]
 //]
 *
 * @author chenjinlong
 * @date : 2021/1/6
 */
public class Solution0103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreeNode node, int level, List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        if (result.size() == level) {
            result.add(new ArrayList<>());
        }
        if ((level & 1) == 1) {
            result.get(level).add(0, node.val);
        } else {
            result.get(level).add(node.val);
        }
        dfs(node.left, level + 1, result);
        dfs(node.right, level + 1, result);
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
