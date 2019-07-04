package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by kimvra on 2019-07-04
 * 在未排序的数组中找到第k大的数
 */
public class _0215_Find_Kth_Largest {
    private int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    @Test
    public void test() {
        Assert.assertEquals(findKthLargest(new int[]{3,2,1,5,6,4}, 2), 5);
        Assert.assertEquals(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 2), 5);
    }
}
