package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kimvra on 2019-06-05
 * 给定一个字符串 S 和一个字符串 T，请在 S 中找出包含 T 所有字母的最小子串。
 *
 * 示例：
 *
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 */
public class _0076_Min_Wiindow {
    public static String minWindow(String s, String t) {
        Map<Character, Integer> lookup = new HashMap<>();
        for (char c : s.toCharArray())
            lookup.put(c, 0);
        for (char c : t.toCharArray()) {
            if (lookup.containsKey(c))
                lookup.put(c, lookup.get(c) + 1);
            else
                return "";
        }
        int start = 0;
        int end = 0;
        int min_len = Integer.MAX_VALUE;
        int counter = t.length();
        String res = "";
        while (end < s.length()) {
            char c1 = s.charAt(end);
            if (lookup.get(c1) > 0)
                counter--;
            lookup.put(c1, lookup.get(c1) - 1);
            end++;
            while (counter == 0) {
                if (min_len > end - start) {
                    min_len = end - start;
                    res = s.substring(start, end);
                }
                char c2 = s.charAt(start);
                if (lookup.get(c2) == 0) counter++;
                lookup.put(c2, lookup.get(c2) + 1);
                start++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}
