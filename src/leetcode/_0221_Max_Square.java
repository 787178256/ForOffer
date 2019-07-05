package leetcode;

/**
 * Created by kimvra on 2019-07-05
 */
public class _0221_Max_Square {
    private int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        if (rows < 1) {
            return 0;
        }
        int cols = matrix[0].length;
        int max = 0;
        int[][] dp = new int[rows+1][cols+1];
        for (int i = 1; i <= rows; ++i) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i-1][j-1] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i-1][j]));
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }
}
