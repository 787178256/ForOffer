package pat;

/**
 * Created by kimvra on 2019-03-25
 */
public class DPDemo1 {
    private static void func(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < len; i++) {
            dp[i] = dp[i - 1] > 0 ? nums[i] + dp[i - 1] : nums[i];
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,11,-4,13,-5,-2};
        func(nums);
    }
}
