package leetcode;

/**
 * Created by kimvra on 2019-08-24
 * "aabcc"
 * "dbbca"
 * "aadbbcbcac"
 */
public class _0097_IsInterleave {
    private boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length(), l = s3.length();
        if (m + n != l) {
            return false;
        }
        boolean[][] dp = new boolean[m + 1][n + 1];//dp[i][j]表示s1.substring(0, i) s2.substring(0, j)
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = s2.substring(0, j).equals(s3.substring(0, j));
                } else if (j == 0) {
                    dp[i][j] = s1.substring(0, i).equals(s3.substring(0, i));
                } else {
                    dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[m][n];
    }
}
