package leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by kimvra on 2019-03-07
 * [1,2,2,2,3]使用二分法查找元素2，返回最小下标和最大下标
 */
public class _0034_Search_for_a_Range {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int[] result = {-1, -1};
        if (len == 0) {
            return result;
        }
        if (nums[0] > target || nums[len - 1] < target) {
            return result;
        }
        int i = 0;
        while (i < len && nums[i] != target) {
            ++i;
        }
        if (i == len) {
            return result;
        } else {
            result[0] = i;
            while (i < len - 1 && nums[i + 1] == target) {
                ++i;
            }
            result[1] = i;
            return result;
        }
    }

    private int [] searchRangeByBinarySearch(int[] nums, int target) {
        int len = nums.length;
        int[] result = {-1, -1};
        if (len == 0) {
            return result;
        }
        result[0] = searchLeftIndex(nums, target);
        result[1] = searchRightIndex(nums, target);
        return result;
    }

    private int searchLeftIndex(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + right >>> 1;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left == nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    private int searchRightIndex(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + right >>> 1;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left == 0 || nums[left - 1] != target) {
            return -1;
        }
        return left - 1;
    }

    @Test
    public void test() {
        int[] nums = {1,2,2,2,3};
        System.out.println(Arrays.toString(searchRangeByBinarySearch(nums, 3)));
    }
}
