package leetcode;

/**
 * Created by kimvra on 2019-09-19
 */
public class _0486_Predict_The_Winner {
    private boolean predictTheWinner(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int first = dfs(nums, 0, nums.length - 1);
        return first > sum - first;
    }

    private int dfs(int[] nums, int i, int j) {
        if(i == j)
            return nums[i];
        if(i+1 == j)
            return Math.max(nums[i], nums[j]);

        // 都是聪明人，你如果想要赢实际上就是你在选更大数字的时候，同时要保证留给对方更小的数字
        return Math.max(
                nums[i] + Math.min(dfs(nums, i+1, j-1), dfs(nums, i+2, j)),
                nums[j] + Math.min(dfs(nums, i+1, j-1), dfs(nums, i, j-2)));
    }

    private boolean dynamic(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (i == j) {
                    dp[i][j] = nums[i];
                } else if (i + 1 == j) {
                    dp[i][j] = Math.abs(nums[i] - nums[j]);
                } else {
                    dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
                }
            }
        }
        return dp[0][len - 1] >= 0;
    }
}
