package leetcode;


/**
 * Created by kimvra on 2019-03-01
 */
public class _0005_Longest_Palindrome {
    public String longestPalindrome(String s) {
        int max = 0;
        String result = "";
        if (s == null || s.length() == 0) {
            return result;
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (isPalindrome(s.substring(i, j))) {
                    if (j - i > max) {
                        max = j - i;
                        result = s.substring(i, j);
                    }
                }
            }
        }
        return result;
    }

    boolean isPalindrome(String s) {
        int len = s.length();
        for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static String longestPalindrome1(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int start = 0, end = 0;
        for (int j = 0; j < len; j++) {
            dp[j][j] = true;
            for (int i = 0; i < j; i++) {
                if (i + 1 == j) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else if (i + 1 < j) {
                    dp[i][j] = dp[i+1][j-1] && s.charAt(i) == s.charAt(j);
                }
                if (j - i > end - start && dp[i][j]) {
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
