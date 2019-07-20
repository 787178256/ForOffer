package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
public class _0076_Min_Window {
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
        System.out.println(minWindow("bbaa", "aba"));
    }

    private String slidingWindow(String s, String t) {
        if (s == null || s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> maps = new HashMap<>();
        Map<Character, Integer> mapt = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (mapt.containsKey(t.charAt(i))) {
                int num = mapt.get(t.charAt(i));
                mapt.put(t.charAt(i), num+1);
            } else {
                mapt.put(t.charAt(i), 1);
            }
        }
        int start = 0, end = 0, len = s.length(), minLen = Integer.MAX_VALUE, minStart = 0, minEnd = 0;
        while (start < len) {
            while (end < len && !helper(maps, mapt)) {
                if (maps.containsKey(s.charAt(end))) {
                    int num = maps.get(s.charAt(end));
                    maps.put(s.charAt(end), num+1);
                } else {
                    maps.put(s.charAt(end), 1);
                }
                end++;
            }
            if (!helper(maps, mapt)) {
                break;
            }
            int l = end - start;
            if (l < minLen) {
                minStart = start;
                minEnd = end;
                minLen = l;
            }
            int num = maps.get(s.charAt(start));
            maps.put(s.charAt(start), num-1);
            start++;
        }
        System.out.println(minStart + " " + minEnd);
        return s.substring(minStart, minEnd);
    }

    private boolean helper(Map<Character, Integer> maps, Map<Character, Integer> mapt) {
        Set<Character> keySet = mapt.keySet();
        for (Character c : keySet) {
            if (!maps.containsKey(c) || maps.get(c) < mapt.get(c)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        //Assert.assertEquals("BANC", slidingWindow("ADOBECODEBANC", "ABC"));
        Assert.assertEquals("baa", slidingWindow("bbaa", "aba"));

    }
}
