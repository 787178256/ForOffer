package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kimvra on 2019-03-21
 */
public class _0409_Longest_Palindrome {
    public static int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(s.charAt(i))) {
                int count = map.get(s.charAt(i));
                map.put(s.charAt(i), count + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        int res = 0;
        int maxOddCount = 0;
        for (Map.Entry entry : map.entrySet()) {
            if ((int) entry.getValue() % 2 == 0) {
                res += (int) entry.getValue();
            } else {
//                if ((int) entry.getValue() > maxOddCount) {
//                    maxOddCount = (int) entry.getValue();
//                }
                res = res + (int) entry.getValue() - 1;
            }
        }
        if (res < len) {
            res = res + 1;
        }
        return res;
    }

    private static int betterSolution(String s) {
        int[] cnts = new int[256];
        for (char c : s.toCharArray()) {
            cnts[c]++;
        }
        int res = 0;
        for (int cnt : cnts) {
            res = (cnt / 2) * 2;
        }
        if (res < s.length()) {
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abbbcccccdd"));
    }
}
