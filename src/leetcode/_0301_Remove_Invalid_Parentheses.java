package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kimvra on 2019-07-31
 */
public class _0301_Remove_Invalid_Parentheses {

    // 1. 算出不合法的左括号和右括号数量
    // 2. 删除对应数量的左括号和右括号
    // 3. 检查删除不合法括号后的字符串是否合法

    private List<String> removeInvalidParentheses(String s) {
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else if (s.charAt(i) == ')'){
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }
        List<String> ans = new ArrayList<>();
        dfs(s, 0, left, right, ans);
        return ans;
    }

    private void dfs(String s, int index, int left, int right, List<String> ans) {
        if (left == 0 && right == 0) {
            if (check(s)) {
                ans.add(s);
                return;
            }
        }
        for (int i = index; i < s.length(); i++) {
            if (i - 1 >= index && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            if (left > 0 && s.charAt(i) == '(') {
                dfs(s.substring(0, i) + s.substring(i + 1), i, left - 1, right, ans);
            } else if (right > 0 && s.charAt(i) == ')') {
                dfs(s.substring(0, i) + s.substring(i + 1), i, left, right - 1, ans);
            }
        }
    }

    private boolean check(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cnt++;
            } else if (s.charAt(i) == ')') {
                if (cnt > 0) {
                    cnt--;
                } else {
                    return false;
                }
            }
        }
        return cnt == 0;
    }

    @Test
    public void test() {
        System.out.println(removeInvalidParentheses("(()"));
    }
}
