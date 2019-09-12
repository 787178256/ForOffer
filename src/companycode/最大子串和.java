package companycode;

/**
 * Created by kimvra on 2019-09-12
 */
public class 最大子串和 {
    private static int func(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i];
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,-3,-4,10};
        func(nums);
    }

}
