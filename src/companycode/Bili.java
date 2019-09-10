package companycode;

import java.util.Scanner;

/**
 * Created by kimvra on 2019-09-10
 */
public class Bili {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word1 = in.next();
        String word2 = in.next();
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];//表示word1[0][i]-->word2[0][j]的次数
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = Math.max(i, j);
                } else {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
                    }
                }
            }
        }
        System.out.println(dp[m][n]);
    }
}
