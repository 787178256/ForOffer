package leetcode;

import org.junit.Test;

import java.util.*;

/**
 * Created by kimvra on 2019-07-20
 */
public class _0480_Median_Sliding_Window {
    private double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new double[]{};
        }
        int len = nums.length;
        double[] res = new double[len - k + 1];
        int left = 0, right = 0;
        List<Integer> list = new ArrayList<>();
        while (right < len) {
            if (right < k - 1) {
                list.add(nums[right]);
                right++;
                continue;
            }
            if (right == k - 1) {
                list.add(nums[right]);
                Collections.sort(list);
                res[right - k + 1] = k % 2 == 0 ? Math.abs(list.get(k / 2 - 1)-list.get(k / 2)) / 2.0 + Math.min(list.get(k / 2 - 1), list.get(k / 2)): list.get(k / 2);
                right++;
                continue;
            }
            list.remove((Integer) nums[left++]);
            list.add(nums[right]);
            Collections.sort(list);
            res[right - k + 1] = k % 2 == 0 ? (list.get(k / 2 - 1) + list.get(k / 2)) / 2.0 : list.get(k / 2);
            right++;
        }
        System.out.println(res[0]);
        return res;
    }

    @Test
    public void test() {
        int[] nums = new int[]{2147483647,2147483647};
        System.out.println(medianSlidingWindow(nums, 2));
    }
}
