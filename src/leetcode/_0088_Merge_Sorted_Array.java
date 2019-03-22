package leetcode;

/**
 * Created by kimvra on 2019-03-10
 */
public class _0088_Merge_Sorted_Array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1, index2 = n - 1;
        int indexMerge = m + n - 1;
        while (index1 >= 0 || index2 >= 0) {
            if (index1 < 0) {
                nums1[indexMerge--] = nums2[index2--];
            } else if (index2 < 0) {
                nums1[indexMerge--] = nums1[index1--];
            } else if (nums1[index1] > nums2[index2]) {
                nums1[indexMerge--] = nums1[index1--];
            } else {
                nums1[indexMerge--] = nums2[index2--];
            }
        }
    }

    public static void m(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1, index2 = n - 1, indexMerge = m + n - 1;
        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index1] > nums2[index2]) {
                nums1[indexMerge--] = nums1[index1--];
            } else {
                nums1[indexMerge--] = nums2[index2--];
            }
        }
        if (index1 < 0) {
            while (index2 >= 0) {
                nums1[indexMerge--] = nums2[index2--];
            }
        } else {
            while (index1 >= 0) {
                nums1[indexMerge--] = nums1[index1--];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {4,5,6,0,0,0};
        int[] nums2 = {1,2,3};
        m(nums1,3,nums2,3);
    }
}
