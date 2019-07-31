package leetcode;

import org.junit.Test;

/**
 * Created by kimvra on 2019-07-31
 */
public class _0312_Max_Coins {
    private int maxCoins(int[] nums) {
        int n = nums.length;
        int[] coin = new int[n + 2];
        coin[0] = 1;
        coin[n + 1] = 1;
        for (int i = 0, j = 1; i < n; i++, j++) {
            coin[j] = nums[i];
        }
        int[][] dp = new int[n + 2][n + 2];
        for (int i = 2; i < coin.length; i++) {
            for (int j = 0; j + i < coin.length; j++) {
                for (int k = j + 1; k < j + i; k++) {
                    dp[j][j + i] = Math.max(dp[j][j + i], dp[j][k] + dp[k][j + i] + coin[j] * coin[k] * coin[j + i]);
                }
            }
        }
//        for (int i = 0; i < coin.length; i++) {
//            for (int j = i + 2; j < coin.length; j++) {
//                for (int k = i + 1; k < j; k++) {
//                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + coin[i] * coin[k] * coin[j]);
//                }
//            }
//        }
        return dp[0][n + 1];
    }

    @Test
    public void test() {
        System.out.println(maxCoins(new int[]{3, 1, 5, 8}));
    }
}
