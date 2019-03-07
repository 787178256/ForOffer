package leetcode;

/**
 * Created by kimvra on 2019-03-07
 */
public class MPractice34 {
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
}
