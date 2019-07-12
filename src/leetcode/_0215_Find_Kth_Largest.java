package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by kimvra on 2019-07-04
 * 在未排序的数组中找到第k大的数
 */
public class _0215_Find_Kth_Largest {
    private int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    private int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> n1 - n2);//求第k大值,建最小堆
        for (int n : nums) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.poll();
    }

    private int findKthLargest2(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) {
            return -1;
        }
        int len = nums.length;
        int start = 0, end = len - 1;
        int index = getIndex(nums, start, end);
        while (index != len - k && start <= end) {
            if (index < len - k) {
                start = index + 1;
                index = getIndex(nums, start, end);
            } else {
                end = index - 1;
                index = getIndex(nums, start, end);
            }
        }
        return nums[index];
    }

    private int getIndex(int[] nums, int start, int end) {
        int pivot = nums[start];
        swap(nums, start, end);
        int curIndex = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] < pivot) {
                swap(nums, i, curIndex);
                curIndex++;
            }
        }
        swap(nums, curIndex, end);
        return curIndex;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    @Test
    public void test() {
        Assert.assertEquals(getIndex(new int[]{3,2,1,5,6,4}, 0, 5), 2);
        Assert.assertEquals(findKthLargest2(new int[]{3,2,1,5,6,4}, 2), 5);
        Assert.assertEquals(findKthLargest2(new int[]{3,2,3,1,2,4,5,5,6}, 2), 5);
    }
}
