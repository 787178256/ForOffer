package leetcode;

/**
 * Created by kimvra on 2019-03-10
 */
public class MPractice213 {
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (j == i) {
                    dp[i][j] = nums[i];
                } else if (j == i + 1) {
                    dp[i][j] = Math.max(nums[i], nums[j]);
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i][j - 2] + nums[j]);
                }
            }
        }
        dp[0][len - 1] = Math.max(dp[1][len - 1], dp[0][len - 2]);
        return dp[0][len - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,2};
        System.out.println(rob(nums));
    }
}
