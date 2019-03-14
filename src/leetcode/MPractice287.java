package leetcode;

/**
 * Created by kimvra on 2019-03-14
 */
public class MPractice287 {
    public int findDuplicate(int[] nums) {
        int n = nums.length - 1;
        int low = 0, high = n;
        while (low <= high) {
            int mid = low + high >>> 1;
            int count = 0;
            for (int i = 0; i <= n; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
