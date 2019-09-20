package sortmethod;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by kimvra on 2019-03-13
 */
public class HeapSort {
    /**
     *
     * @param nums 数组从下标1开始
     * @param k 在k位置插入元素
     */
    private void shiftUp(int[] nums, int k) {
        while (k  > 1 && nums[k / 2] < nums[k]) {
            int temp = nums[k];
            nums[k] = nums[k / 2];
            nums[k / 2] = temp;
            k = k / 2;
        }
    }

    /**
     *
     * @param nums 数组下标从1开始
     * @param k 调整k位置的元素
     */
    private void shiftDown(int[] nums, int k, int end) {
        while (2 * k <= end) {
            int j = 2 * k;
            if (j + 1 <= end && nums[j+1] > nums[j]) {
                j = j + 1;
            }
            if (nums[k] >= nums[j]) {
                break;
            }
            int temp = nums[k];
            nums[k] = nums[j];
            nums[j] = temp;
            k = j;
        }
    }


    private void heapify(int[] nums) {
        int len = nums.length;
        int k = (len - 1) / 2;
        for (int i = len - 1; i >= 1; i--) {
            //shiftDown(nums, i, len - 1);
            shiftUp(nums, i);
        }
        for (int i : nums) {
            System.out.print(i + " ");
        }
        for (int i = len - 1; i >= 2; i--) {
            int temp = nums[i];
            nums[i] = nums[1];
            nums[1] = temp;
            shiftDown(nums, 1, i - 1);
        }
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    @Test
    public void test() {
        int[] nums = {0,1,3,2,5,4};
        sort(nums);
    }

    private void adjustUp(int[] nums, int k) {
        while (k > 1 && nums[k] > nums[k / 2]) {
            int temp = nums[k];
            nums[k] = nums[k / 2];
            nums[k / 2] = temp;
            k = k / 2;
        }
    }

    private void adjustDown(int[] nums, int k, int end) {
        while (k * 2 <= end) {
            int j = 2 * k;
            if (j + 1 <= end && nums[j] < nums[j + 1]) {
                j = j + 1;
            }
            if (nums[k] >= nums[j]) {
                break;
            }
            int temp = nums[k];
            nums[k] = nums[j];
            nums[j] = temp;
            k = j;
        }
    }

    private void sort(int[] nums) {
        int len = nums.length;
        for (int i = len - 1; i > 1; i--) {
            shiftUp(nums, i);
        }
        for (int i = len - 1; i > 1; i--) {
            int temp = nums[i];
            nums[i] = nums[1];
            nums[1]= temp;
            shiftDown(nums, 1, i - 1);
        }
        System.out.println(Arrays.toString(nums));
    }
}
