package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by kimvra on 2019-07-12
 */
public class Byte_Search {
    private int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int index = findIndex(nums, 0, nums.length - 1);
        if (index == 0) {
            return search(nums, 0, nums.length - 1, target);
        }
        if (target >= nums[0]) {
            return search(nums, 0, index - 1, target);
        } else {
            return search(nums, index, nums.length - 1, target);
        }
    }

    private int search(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + right >>> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
    private int findIndex(int[] nums, int left, int right) {
        if (left >= right || nums[left] < nums[right]) {
            return 0; // 表示数组未排序
        }
        while (left <= right) {
            int mid = left + right >>> 1;
            if (nums[mid] > nums[mid+1]) {
                return mid+1;
            } else if (nums[mid] > nums[left]) {
                left++;
            } else {
                right--;
            }
        }
        return 0;
    }

    @Test
    public void test() {
        int[] nums = new int[]{4,5,6,7,8,0,1,2,3};
        Assert.assertEquals(5, search(nums, 0));
        System.out.println(findIndex(nums, 0, 8));
    }
}
