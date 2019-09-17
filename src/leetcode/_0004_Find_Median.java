package leetcode;

import org.junit.Test;

/**
 * Created by kimvra on 2019-08-02
 */
public class _0004_Find_Median {
    private double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len % 2 == 0) {
            return (helper(nums1, 0, nums2, 0, len / 2) + helper(nums1, 0, nums2, 0, len / 2 + 1)) / 2.0;
        }
        return helper(nums1, 0, nums2, 0, (len + 1) / 2);
    }

    private int helper(int[] nums1, int m, int[] nums2, int n, int k) {
        if (m >= nums1.length) return nums2[n + k - 1];
        if (n >= nums2.length) return nums1[m + k - 1];
        if (k == 1) return Math.min(nums1[m], nums2[n]);

        int p1 = m + k / 2 - 1;
        int p2 = n + k / 2 - 1;
        int mid1 = p1 < nums1.length ? nums1[p1] : Integer.MAX_VALUE;
        int mid2 = p2 < nums2.length ? nums2[p2] : Integer.MAX_VALUE;
        if (mid1 < mid2) {
            return helper(nums1, m + k / 2, nums2, n, k - k / 2);
        }
        return helper(nums1, m, nums2, n + k / 2, k - k / 2);
    }

    private int review(int[] nums1, int n, int[] nums2, int m, int k) {
        if (n >= nums1.length) return nums2[m + k - 1];
        if (m >= nums2.length) return nums1[n + k - 1];
        if (k == 1) {
            return Math.min(nums1[n], nums2[m]);
        }
        int p1 = n + k / 2 - 1;
        int p2 = m + k / 2 - 1;
        int mid1 = p1 >= nums1.length ? Integer.MAX_VALUE : nums1[p1];
        int mid2 = p2 >= nums2.length ? Integer.MAX_VALUE : nums2[p2];
        if (mid1 > mid2) {
            return review(nums1, n, nums2, m + k / 2, k - k / 2);
        }
        return review(nums1, n + k / 2, nums2, m, k - k / 2);
    }

    @Test
    public void test() {
        int[] nums1 = new int[]{1,2,3};
        int[] nums2 = new int[]{4,5,6};
        System.out.println(helper(nums1, 0, nums2, 0, 1));
    }
}
