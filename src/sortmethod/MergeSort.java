package sortmethod;

import java.util.Arrays;

/**
 * Created by kimvra on 2019-03-17
 */
public class MergeSort {
    /**
     * 将nums[l, mid]与nums[mid + 1, r]合并
     */
    private static int[] mergeR(int[] nums, int l, int mid, int r) {
        int k = mid + 1;
        int[] res = Arrays.copyOfRange(nums, l, r + 1);
        while (l <= mid && k <= r) {
            if (nums[l] < nums[k]) {
                res[l++] = nums[l++];
            } else {
                res[l++] = nums[k++];
            }
        }
        if (l > mid) {
            while (k <= r) {
                res[l++] = nums[k++];
            }
        } else {
            while (l <= mid) {
                res[l++] = nums[l++];
            }
        }
        return res;
    }

    private static void merge(int[] nums, int l, int mid, int r) {
        int k = mid + 1;
        int[] res = Arrays.copyOfRange(nums, l, r + 1);
        while (l <= mid && k <= r) {
            if (nums[l] < nums[k]) {
                res[l++] = nums[l++];
            } else {
                nums[l++] = nums[k++];
            }
        }
        if (l > mid) {
            while (k <= r) {
                res[l++] = nums[k++];
            }
        } else {
            while (l <= mid) {
                res[l++] = nums[l++];
            }
        }
    }

    public static void sort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + r >>> 1;
        sort(nums, l, mid);
        sort(nums, mid + 1, r);
        merge(nums, l, mid, r);
    }
}
