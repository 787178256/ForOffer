package leetcode;

/**
 * Created by kimvra on 2019-08-12
 */
public class _0123_Max_Profit {
    private int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[][][] dp = new int[n][3][2];
        for (int i = 0; i < n; i++) {
            for (int k = 2; k >= 1; k--) {
                if (i - 1 == -1) {
                    /* 处理 base case */
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
            }
        }
// 穷举了 n × max_k × 2 个状态，正确。
        return dp[n - 1][2][0];
    }
}
