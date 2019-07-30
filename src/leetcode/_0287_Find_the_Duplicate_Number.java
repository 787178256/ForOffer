package leetcode;

/**
 * Created by kimvra on 2019-03-14
 */
public class _0287_Find_the_Duplicate_Number {
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

    /**
     * 用循环链表的思想
     * @param nums
     * @return
     */
    private int findDuplicate_(int[] nums) {
        int fast = 0, slow = 0;
        while (true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if (slow == fast) {
                fast = 0;
                while (nums[fast] != nums[slow]) {
                    fast = nums[fast];
                    slow = nums[slow];
                }
                return nums[slow];
            }
        }
    }
}
