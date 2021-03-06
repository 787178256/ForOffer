package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by kimvra on 2019-06-22
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 */
public class _0136_Single_Number {
    private int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    @Test
    public void test() {
        Assert.assertEquals(singleNumber(new int[]{2,2,1}), 1);
        Assert.assertEquals(singleNumber(new int[]{4,1,2,1,2}), 4);
    }
}
