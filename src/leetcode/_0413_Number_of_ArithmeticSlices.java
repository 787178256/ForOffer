package leetcode;

/**
 * Created by kimvra on 2019-03-12
 */
public class _0413_Number_of_ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        int len = A.length;
        int[] dp = new int[len];
        for (int i = 2; i < len; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        int total = 0;
        for (int a : dp) {
            total += a;
        }
        return total;
    }
}
