package leetcode;

import java.util.List;

/**
 * Created by kimvra on 2019-03-10
 */
public class _0524_Find_Longest_Word {
    public String findLongestWord(String s, List<String> d) {
        String res = "";
        int maxLen = 0;
        for (String s1 : d) {
            int l1 = s1.length();
            if (l1 < maxLen || (l1 == maxLen && res.compareTo(s1) < 0)) {
                continue;
            }
            if (isValid(s, s1)) {
                res = s1;
                maxLen = l1;
            }
        }
        return res;
    }

    private boolean isValid(String s, String target) {
        int i = 0, j = 0;
        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                ++j;
            }
            ++i;
        }
        return j == target.length();
    }
}
