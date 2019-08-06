package leetcode;

/**
 * Created by kimvra on 2019-03-07
 */
public class _0035_Search_Insert {
    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + right >>> 1; // 加法优先级高于右移
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        int[] num = {1,3,5,6};
        System.out.println(searchInsert(num, 7));
    }
}
