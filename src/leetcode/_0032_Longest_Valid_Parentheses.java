package leetcode;

import java.util.Stack;

/**
 * Created by kimvra on 2019-05-27
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 */
public class _0032_Longest_Valid_Parentheses {
    public static int longestValidParentheses(String s) {
        if (s == null || s.trim().length() == 0) {
            return 0;
        }
        int len = s.length(), curLen = 0, validLen = 0, maxLen = 0, sum = 0;
        for (int i = 0; i < len; i++) {
            sum += s.charAt(i) == '(' ? 1 : -1;
            curLen++;
            if (sum < 0) {
                maxLen = Math.max(maxLen, validLen);
                sum = 0;
                curLen = 0;
                validLen = 0;
            }
            if (sum == 0) {
                validLen = curLen;
            }
        }
        maxLen = Math.max(maxLen, validLen);
        int curLen1 = 0, validLen1 = 0, maxLen1 = 0, sum1 = 0;
        for (int i = len - 1; i >= 0; i--) {
            sum1 += s.charAt(i) == ')' ? 1 : -1;
            curLen1++;
            if (sum1 < 0) {
                maxLen1 = Math.max(maxLen1, validLen1);
                sum1 = 0;
                validLen1 = 0;
                curLen1 = 0;
            }
            if (sum1 == 0) {
                validLen1 = curLen1;
            }
        }
        maxLen1 = Math.max(maxLen1, validLen1);
        return Math.max(maxLen, maxLen1);
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses(")())()"));
        System.out.println(longestValidParentheses("()(())"));
        System.out.println(longestValidParentheses("))))())()()(()"));
    }
}
