package companycode;

import java.util.Scanner;

/**
 * Created by kimvra on 2019-08-29
 */
public class 顺丰2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int[] dp = new int[n];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] >= nums[j]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            res = Math.max(dp[i], res);
        }
        System.out.println(res);
    }
}


