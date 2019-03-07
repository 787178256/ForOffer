package leetcode;

/**
 * Created by kimvra on 2019-03-07
 */
public class MPractice35 {
    public static int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (nums[0] > target) {
            return 0;
        }
        if (target > nums[len - 1]) {
            return len;
        }
        return search(nums, target, 0, len - 1);
    }

    private static int search(int[] num, int target, int left, int right) {
        while (left < right) {
            int mid = left + right >>> 1;
            if (num[mid] == target) {
                return mid;
            } else if (num[mid] < target) {
                left = mid + 1;
                search(num, target, left, right);
            } else {
                right = mid - 1;
                search(num, target, left, right);
            }
        }
        return target > num[left] ? left + 1 : left;
    }

    public static void main(String[] args) {
        int[] num = {1,3,5,6};
        System.out.println(searchInsert(num, 5));
    }
}
