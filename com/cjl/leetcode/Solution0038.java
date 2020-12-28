package com.cjl.leetcode;

/**
 * 38. Count and Say
 *
 * The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
 *
 * countAndSay(1) = "1"
 * countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
 * To determine how you "say" a digit string, split it into the minimal number of groups so that each group is a contiguous section all of the same character. Then for each group, say the number of characters, then say the character. To convert the saying into a digit string, replace the counts with a number and concatenate every saying.
 *
 * For example, the saying and conversion for digit string "3322251":
 *
 *
 * Given a positive integer n, return the nth term of the count-and-say sequence.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 1
 * Output: "1"
 * Explanation: This is the base case.
 * Example 2:
 *
 * Input: n = 4
 * Output: "1211"
 * Explanation:
 * countAndSay(1) = "1"
 * countAndSay(2) = say "1" = one 1 = "11"
 * countAndSay(3) = say "11" = two 1's = "21"
 * countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
 *
 * @author chenjinlong
 * @date : 2020/12/28
 */
public class Solution0038 {

    public static String countAndSay(int n) {
        String result = "1";
        while (--n > 0) {
            result = say(result);
        }
        return result;
    }

    private static String say(String result) {
        StringBuilder sb = new StringBuilder();
        // i为匹配的起始点，cur为游标
        int i = 0, cur = 0;
        while (cur < result.length()) {
            // 滑动游标直到游标与起点字符不匹配
            if (result.charAt(i) != result.charAt(cur)) {
                // 添加具体字符串
                sb.append(cur - i).append(result.charAt(i));
                // 修改匹配起点为当前游标的值
                i = cur;
            }
            cur++;
        }
        // 最后一轮的字符也要加上返回
        return sb.append(cur - i).append(result.charAt(i)).toString();
    }

    public static void main(String[] args) {
        countAndSay(4);
    }

}
