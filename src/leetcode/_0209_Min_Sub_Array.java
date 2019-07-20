package leetcode;

/**
 * Created by kimvra on 2019-07-20
 */
public class _0209_Min_Sub_Array {
    private int minSubArray(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0, end = 0, len = nums.length, sum = nums[0], minLen = Integer.MAX_VALUE;
        while (start < len) {
            while (sum < s) {
                end++;
                if (end == len) {
                    return minLen == Integer.MAX_VALUE ? 0 : minLen;
                }
                sum += nums[end];
            }
            if (end - start + 1 < minLen) {
                minLen = end - start + 1;
            }
            sum -= nums[start];
            start++;
        }
        return minLen;
    }
}
