package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by kimvra on 2019-03-17
 */
public class _0300_Longest_Increasing_Subsequence {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n==0) {
            return 0;
        }

        int res = 1;
        int[] memo = new int[n];

        Arrays.fill(memo, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    memo[i] = max(memo[i] , memo[j]+1);
            }
        }

        for(int i = 0;i<n;i++){
            res = max(memo[i],res);
        }
        return res;
    }

    private int dp(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }
    private int max(int a, int b) {
        return a > b ? a : b;
    }

    @Test
    public void test() {
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        Assert.assertEquals(dp(nums), 4);
    }
}
