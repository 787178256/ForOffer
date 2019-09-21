package companycode;

import java.util.Scanner;

/**
 * Created by kimvra on 2019-09-21
 */
public class NetEase03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = in.nextInt();
            }
            System.out.println(func(nums));
        }
    }

    private static int func(int[] nums) {
        int max = 1;
        int len = nums.length;
        int[] dp = new int[len];
        int[] sum = new int[len];
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                dp[i] = 1;
                sum[i] = nums[i];
            } else {
                if (nums[i] >= sum[i - 1]) {
                    dp[i] = dp[i - 1] + 1;
                    sum[i] = sum[i - 1] + nums[i];
                } else {
                    dp[i] = 1;
                    sum[i] = nums[i];
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
