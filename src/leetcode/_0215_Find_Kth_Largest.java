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

    @Test
    public void test() {
        Assert.assertEquals(findKthLargest(new int[]{3,2,1,5,6,4}, 2), 5);
        Assert.assertEquals(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 2), 5);
    }
}
