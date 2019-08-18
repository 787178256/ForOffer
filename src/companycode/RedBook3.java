package companycode;

import java.util.Scanner;

/**
 * Created by kimvra on 2019-08-18
 */
public class RedBook3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = in.nextInt();
        }
        int len = nums.length;
        if (len == 1) {
            System.out.print(nums[0] + " " + 1);
            return;
        }
        int[][] dp = new int[len][len];
        int[][] count = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (j == i) {
                    dp[i][j] = nums[i];
                    count[i][j] = 1;
                } else if (j == i + 1) {
                    dp[i][j] = Math.max(nums[i], nums[j]);
                    count[i][j] = 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i][j - 2] + nums[j]);
                    if (dp[i][j - 1] >= dp[i][j - 2] + nums[j]) {
                        count[i][j] = count[i][j - 1];
                    } else {
                        count[i][j] = count[i][j - 2] + 1;
                    }
                }
            }
        }
        System.out.println(dp[0][len - 1] + " " + count[0][len - 1]);
    }
}
