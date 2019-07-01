package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by kimvra on 2019-07-01
 * 定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 */
public class _0152_Max_Product {
    private int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imin = 1, imax = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(imax*nums[i], nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);

            max = Math.max(imax, max);
        }
        return max;
    }


    @Test
    public void test() {
        Assert.assertEquals(maxProduct(new int[]{2,-5,-2,-4,3}), 24);
    }
}
