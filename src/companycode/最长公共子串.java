package companycode;

import org.junit.Test;

/**
 * Created by kimvra on 2019-09-19
 */
public class 最长公共子串 {
    private void solution(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] dp = new int[len1][len2];
        int start = 0, end = 0, max = 0;
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    if (j == 0 || i == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                } else {
                    dp[i][j] = 0;
                }
                if (dp[i][j] > max) {
                    end = j;
                    start = j - dp[i][j] + 1;
                    max = dp[i][j];
                }
            }
        }
        for (int[] n : dp) {
            for (int i : n) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println(max);
        System.out.println(start + "  " + end);
        System.out.println(str1.substring(start, end + 1));
    }

    @Test
    public void test() {
        solution("abab", "aba");
    }
}
