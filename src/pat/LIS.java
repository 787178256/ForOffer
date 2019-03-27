package pat;

/**
 * Created by kimvra on 2019-03-25
 */
public class LIS {
    private static void func(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        int maxLen = -1;
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] >= nums[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        System.out.println(maxLen);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,-1,-2,7,9};
        func(nums);
    }
}
