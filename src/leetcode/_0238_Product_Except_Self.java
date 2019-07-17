package leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by kimvra on 2019-07-17
 * Input:[1,2,3,4]
 * Output:[24,12,8,6]
 */
public class _0238_Product_Except_Self {
    private int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = left[i-1] * nums[i-1];
        }
        right[len-1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i+1] * nums[i+1];
        }
        for (int i = 0; i < len; i++) {
            nums[i] = left[i] * right[i];
        }
        return nums;
    }

    @Test
    public void test() {
        int[] nums = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
}
