package leetcode;

/**
 * Created by kimvra on 2019-03-06
 */
public class _0033_Search_in_Rotated_Sorted_Array {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid;
        while (l <= r) {
            mid = l + r >>> 1;
            if (nums[mid] == target) return mid;
            else if (nums[mid] >= nums[l]) {
                if (nums[l] <= target && target < nums[mid]) r = mid - 1;
                else l = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[r]) l = mid + 1;
                else r = mid - 1;
            }
        }
        return -1;
    }
}
