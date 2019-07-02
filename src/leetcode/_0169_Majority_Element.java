package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by kimvra on 2019-07-02
 * 找出数组中出现次数大于【length/2】的数
 */
public class _0169_Majority_Element {
    private int majorityElement(int[] nums) {
        int count = 1;
        int c = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                c = nums[i];
                count++;
                continue;
            }
            if (c == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return c;
    }

    @Test
    public void test() {
        Assert.assertEquals(3, majorityElement(new int[]{3,2,3}));
        Assert.assertEquals(2, majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
}
