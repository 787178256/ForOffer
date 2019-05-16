package leetcode;

/**
 * Created by kimvra on 2019-03-13
 */
public class _0053_Max_Sub_Array {
    private static int maxSubArray(int[] nums) {
        int len = nums.length, dp = nums[0], max = dp;
        for (int i = 1; i < len; i++) {
            dp = nums[i] + (dp > 0 ? dp : 0);
            if (dp > max) {
                max = dp;
            }
        }
        return max;
    }


    private static int reviewSolution(int[] nums) {
        int len = nums.length, max = nums[0];
        int[] dp = new int[len];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(reviewSolution(nums));
      //  System.out.println(maxSubArray(nums));
    }

}
