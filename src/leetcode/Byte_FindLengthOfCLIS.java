package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by kimvra on 2019-07-12
 */
public class Byte_FindLengthOfCLIS {
    private int findLengthOfCLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < len; i++) {
            dp[i] = nums[i] > nums[i-1] ? dp[i-1]+1 : 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = new int[]{1,3,5,4,7};
        Assert.assertEquals(3, findLengthOfCLIS(nums));
    }
}
