package leetcode;

import org.junit.Test;

/**
 * Created by kimvra on 2019-08-12
 */
public class _0153_Find_Min {
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

    private int findMin_(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0, right = nums.length - 1;
        if (nums[right] > nums[left]) {
            return nums[left];
        }

        while (left <= right) {
            int mid = left + right >>> 1;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        int[] nums = {3,4,5,1,2};
        System.out.println(findMin(nums));
    }
}
