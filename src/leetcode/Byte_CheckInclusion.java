package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kimvra on 2019-07-05
 * leetcode_567
 * 判断截取长度的字符串中包含的各个字符个数与s1中各个字符个数是否相等
 */
public class Byte_CheckInclusion {
    private boolean[] used;
    private List<String> res;

    private boolean checkInclusion(String s1, String s2, int i) {
        if (s1 == null || s1.length() > s2.length()) {
            return false;
        }
        int len1 = s1.length();
        int[] hash1 = new int[26];
        int[] hash2 = new int[26];
        for (int j = 0; j < len1; j++) {
            hash1[s1.charAt(j)-'a']++;
            hash2[s2.charAt(j)-'a']++;
        }
        for (int j = len1; j < s2.length(); j++) {
            if (func(hash1, hash2)) {
                return true;
            }
            hash2[s2.charAt(j-len1)-'a']--;
            hash2[s2.charAt(j)-'a']++;
        }
        if (func(hash1, hash2)) {
            return true;
        }
        return false;
    }

    private boolean func(int[] chars1, int[] chars2) {
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i]) {
                return false;
            }
        }
        return true;
    }
    private boolean checkInclusion(String s1, String s2) {
        used = new boolean[s1.length()];
        res = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        helper(s1, stringBuilder, used, res);
        for (String s : res) {
            if (s2.contains(s)) {
                return true;
            }
        }
        return false;
    }

    // 全排列 超时。。
    private void helper(String s, StringBuilder stringBuilder, boolean[] used, List<String> res) {
        if (stringBuilder.length() == s.length()) {
            res.add(stringBuilder.toString());
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (!used[i]) {
                used[i] = true;
                stringBuilder.append(s.charAt(i));
                helper(s, stringBuilder, used, res);
                used[i] = false;
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }
    }

    @Test
    public void test() {
        Assert.assertFalse(checkInclusion("prosperity", "properties", 1));
        Assert.assertFalse(checkInclusion("prosperity", "properties"));
    }
}
