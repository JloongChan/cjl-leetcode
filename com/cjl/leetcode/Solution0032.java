package com.cjl.leetcode;

/**
 * 32. Longest Valid Parentheses
 * <p>
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * Example 1:
 * <p>
 * Input: s = "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()".
 * Example 2:
 * <p>
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()".
 * Example 3:
 * <p>
 * Input: s = ""
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= s.length <= 3 * 104
 * s[i] is '(', or ')'.
 *
 * @author chenjinlong
 * @date : 2020/12/16
 */
public class Solution0032 {

    private static int longestValidParentheses(String s) {
        int result = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.length() - i < result) {
                break;
            }
            if (s.charAt(i) ==  ')') {
                continue;
            }
            // 左括号数量
            int leftCount = 1;
            // 匹配的数量
            int count = 1;
            // 当前i循环的临时最大解
            int tempResult = 0;
            for (int j = i + 1; j < s.length(); j++) {
                // 如果是左括号就加，又括号就减
                leftCount = s.charAt(j) ==  '(' ? leftCount + 1 : leftCount - 1;
                if (leftCount < 0) {
                    // 又括号大于左括号说明不匹配
                    break;
                }
                count++;
                if (leftCount == 0) {
                    tempResult = count;
                }
            }
            result = tempResult > result ? tempResult : result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses(")()())((())())(())"));
    }
}
