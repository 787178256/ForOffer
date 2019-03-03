package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by kimvra on 2019-03-02
 */
public class MPractice17 {
    private static String[] map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return Collections.emptyList();
        }
        List<String> list = new ArrayList<>();
        combine(list, digits, "");
        return list;
    }

    private void combine(List<String> list, String digits, String ans) {
        if (ans.length() == digits.length()) {
            list.add(ans);
            return;
        }

        for (char c : map[digits.charAt(ans.length()) - '2'].toCharArray()) {
            combine(list, digits, ans + c);
        }
    }
}
