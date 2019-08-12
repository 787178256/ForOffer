package leetcode;

import org.junit.Test;

/**
 * Created by kimvra on 2019-08-12
 */
public class _0154_Find_Min {
    private int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + right >>> 1;
            if (nums[mid] == nums[right]) {
                right = right - 1;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    @Test
    public void test() {
        int[] nums = {3,1,3};
        System.out.print(findMin(nums));
    }
}
