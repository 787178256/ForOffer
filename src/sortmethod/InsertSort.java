package sortmethod;

/**
 * Created by kimvra on 2019-03-13
 */

/**
 * 时间复杂度 O(n^2)
 */
public class InsertSort {
    public static void sort(int[] nums) {
        int len = nums.length;
        for (int i = 1; i <= len - 1; i++) {
            int temp = nums[i];
            while (i - 1 >= 0 && temp < nums[i - 1]) {
                nums[i] = nums[i - 1];
                i--;
            }
            nums[i] = temp;
        }
    }
}
