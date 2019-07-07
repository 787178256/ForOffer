package leetcode;


import java.util.Arrays;

/**
 * Created by kimvra on 2019-03-16
 * ByteDance
 */
public class _0031_Next_Permutation {

    private static void nextPermutationI(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int len = nums.length;
        for (int i = len - 2; i >= 0; i--) {
            for (int j = len - 1; j > i; j--) {
                if (nums[j] > nums[i]) {
                    swap(nums, i, j);
                    Arrays.sort(nums, i+1, len);
                    return;
                }
            }
        }
        Arrays.sort(nums);
    }


    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int len = nums.length;
        int i = len - 1;
        while (i >= 1 && nums[i] <= nums[i - 1]) {
            i--;
        }
        int start = i, end = len - 1;
        while (start <= end) {
            swap(nums, start, end);
            start++;
            end--;
        }
        if (i == 0) {
            return;
        }
        int n = i - 1;
        for (;i < len; i++) {
            if (nums[i] > nums[n]) {
                swap(nums, i, n);
                break;
            }
        }
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1};
        nextPermutation(nums);
    }
}
