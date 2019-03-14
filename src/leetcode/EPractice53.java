package leetcode;

/**
 * Created by kimvra on 2019-03-13
 */
public class EPractice53 {
    public int maxSubArray(int[] nums) {
        int len = nums.length, dp = nums[0], max = dp;
        for (int i = 1; i < len; i++) {
            dp = nums[i] + (dp > 0 ? dp : 0);
            if (dp > max) {
                max = dp;
            }
        }
        return max;
    }

}
