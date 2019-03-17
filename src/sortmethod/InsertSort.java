package sortmethod;

/**
 * Created by kimvra on 2019-03-13
 */

import java.util.Arrays;

/**
 * 时间复杂度 O(n^2)
 */
public class InsertSort {
    public static void sort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                   swap(nums, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,4,3,2,1};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
