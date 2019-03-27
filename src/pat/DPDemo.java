package pat;

import java.util.Scanner;

/**
 * Created by kimvra on 2019-03-25
 */
public class DPDemo {
    final static int maxn = 1000;
    static int[][] f = new int[maxn][maxn];
    static int[][] dp = new int[maxn][maxn];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                f[i][j] = scanner.nextInt();
            }
        }
        for (int j = 1; j <= n; j++) {
            dp[n][j] = f[n][j];
        }

        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j + 1]) + f[i][j];
            }
        }
        System.out.println(dp[1][1]);
    }
}
